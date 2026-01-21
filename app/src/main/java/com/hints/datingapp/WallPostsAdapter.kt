package com.hints.datingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hints.datingapp.data.WallPost
import java.text.SimpleDateFormat
import java.util.*

class WallPostsAdapter : RecyclerView.Adapter<WallPostsAdapter.WallPostViewHolder>() {
    
    private var posts: List<WallPost> = emptyList()
    
    fun submitList(newPosts: List<WallPost>) {
        posts = newPosts
        notifyDataSetChanged()
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallPostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_wall_post, parent, false)
        return WallPostViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: WallPostViewHolder, position: Int) {
        holder.bind(posts[position])
    }
    
    override fun getItemCount(): Int = posts.size
    
    class WallPostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userNameText: TextView = itemView.findViewById(R.id.user_name_text)
        private val contentText: TextView = itemView.findViewById(R.id.content_text)
        private val timestampText: TextView = itemView.findViewById(R.id.timestamp_text)
        private val likesText: TextView = itemView.findViewById(R.id.likes_text)
        
        fun bind(post: WallPost) {
            userNameText.text = post.userName
            contentText.text = post.content
            timestampText.text = formatTimestamp(post.timestamp)
            likesText.text = "♥ ${post.likes}"
        }
        
        private fun formatTimestamp(timestamp: Long): String {
            val sdf = SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault())
            return sdf.format(Date(timestamp))
        }
    }
}
