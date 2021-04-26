package com.example.githubviewer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubviewer.data.model.users.UsersItem
import com.example.githubviewer.data.util.Resource
import com.example.githubviewer.databinding.FragmentUsersBinding
import com.example.githubviewer.presentation.adapter.GitAdapter
import com.example.githubviewer.presentation.viewmodel.GithubViewModel


class UsersFragment : Fragment() {

    private lateinit var binding: FragmentUsersBinding
    private lateinit var viewModel: GithubViewModel
    private lateinit var gitAdapter: GitAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUsersBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel
        gitAdapter = (activity as MainActivity).adapter
        gitAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("selected", it)
            }
            findNavController().navigate(
                R.id.action_usersFragment_to_infoFragment,
                bundle
            )
        }

        gitAdapter.setOnItemSaveClickListener {
            saveUser(it)
            Toast.makeText(context, "저장완료", Toast.LENGTH_SHORT).show()
        }


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    getSearchList(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        initRecyclerView()
        getUserList()
    }

    private fun initRecyclerView(){
        binding.rvGit.apply {
            adapter = gitAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun getUserList(){
        viewModel.getUserList()
        viewModel.usersLists.observe(viewLifecycleOwner, { response ->
            when(response){
                is Resource.Success -> {
                    Log.d("TAG" ,"data : ${response.data}")
                    gitAdapter.differ.submitList(response.data)
                }
            }
        })
    }

    private fun getSearchList(q:String){
        viewModel.getSearchList(q)
        viewModel.searchLists.observe(viewLifecycleOwner, { response ->
            when(response){
                is Resource.Success -> {
                    Log.d("TAG", "data : ${response.data}")
                    gitAdapter.differ.submitList(response.data?.items)
                }
            }
        })
    }

    private fun saveUser(usersItem: UsersItem){
        viewModel.saveUser(usersItem)
    }

}