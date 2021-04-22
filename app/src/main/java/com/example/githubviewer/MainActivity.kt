package com.example.githubviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.githubviewer.databinding.ActivityMainBinding
import com.example.githubviewer.presentation.adapter.GitAdapter
import com.example.githubviewer.presentation.viewmodel.GithubViewModel
import com.example.githubviewer.presentation.viewmodel.GithubViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: GithubViewModelFactory
    @Inject
    lateinit var adapter: GitAdapter
    lateinit var viewModel: GithubViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bnvGit.setupWithNavController(
            navController
        )

        viewModel = ViewModelProvider(this,factory)
            .get(GithubViewModel::class.java)
    }


}