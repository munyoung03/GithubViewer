package com.example.githubviewer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubviewer.databinding.FragmentSaveBinding
import com.example.githubviewer.presentation.adapter.GitAdapter
import com.example.githubviewer.presentation.viewmodel.GithubViewModel
import com.google.android.material.snackbar.Snackbar

class SaveFragment : Fragment() {

    private lateinit var binding:FragmentSaveBinding
    private lateinit var viewModel: GithubViewModel
    private lateinit var gitAdapter: GitAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_save, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSaveBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel
        gitAdapter = (activity as MainActivity).adapter

        gitAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("selected", it)
            }
            findNavController().navigate(
                R.id.action_saveFragment_to_infoFragment,
                bundle
            )
        }

        initRecyclerView()

        viewModel.getLocalUserList().observe(viewLifecycleOwner, {
            Log.d("TAG", "Local : $it")
            gitAdapter.differ.submitList(it)
        })

        val itemTouchHelperCallback = object: ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val user = gitAdapter.differ.currentList[position]
                viewModel.deleteUser(user)
                Snackbar.make(view, "Deleted Successfully!", Snackbar.LENGTH_LONG).apply {
                    setAction("Undo"){
                        viewModel.saveUser(user)
                    }
                    show()
                }
            }

        }

        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(binding.rvSave)
        }

    }

    private fun initRecyclerView(){
        binding.rvSave.apply {
            adapter = gitAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}