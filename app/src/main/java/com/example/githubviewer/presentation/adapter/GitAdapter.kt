package com.example.githubviewer.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubviewer.data.model.users.UsersItem
import com.example.githubviewer.databinding.UserItemBinding

class GitAdapter : RecyclerView.Adapter<GitAdapter.GitViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<UsersItem>(){
        override fun areItemsTheSame(oldItem: UsersItem, newItem: UsersItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: UsersItem, newItem: UsersItem): Boolean {
            return oldItem == newItem
        }

    }

    val differ =  AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitViewHolder {
        val binding = UserItemBinding
                .inflate(LayoutInflater.from(parent.context),parent,false)
        return GitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GitViewHolder, position: Int) {
        val users = differ.currentList[position]
        holder.bind(users)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class GitViewHolder(
        val binding: UserItemBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bind(user: UsersItem){
            binding.userName.text = user.login

            Glide.with(binding.userIcon.context).
            load(user.avatar_url).
            into(binding.userIcon)

            binding.root.setOnClickListener {
                onItemClickListener?.invoke(user)
            }

            binding.userStar.setOnClickListener {
                onItemSaveClickListener?.invoke(user)
            }
        }
    }

    private var onItemClickListener: ((UsersItem) -> Unit)? = null
    private var onItemSaveClickListener: ((UsersItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (UsersItem) -> Unit){
        onItemClickListener = listener
    }

    fun setOnItemSaveClickListener(listener: (UsersItem) -> Unit){
        onItemSaveClickListener = listener
    }
}