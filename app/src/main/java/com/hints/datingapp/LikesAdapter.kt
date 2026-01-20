package com.hints.datingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.hints.datingapp.data.User

class LikesAdapter : RecyclerView.Adapter<LikesAdapter.LikeViewHolder>() {
    
    private var users: List<User> = emptyList()
    
    fun submitList(newUsers: List<User>) {
        users = newUsers
        notifyDataSetChanged()
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_like, parent, false)
        return LikeViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: LikeViewHolder, position: Int) {
        holder.bind(users[position])
    }
    
    override fun getItemCount(): Int = users.size
    
    class LikeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val profileImage: ImageView = itemView.findViewById(R.id.profile_image)
        private val nameText: TextView = itemView.findViewById(R.id.name_text)
        private val ageText: TextView = itemView.findViewById(R.id.age_text)
        
        fun bind(user: User) {
            profileImage.load(user.profileImages.firstOrNull() ?: "") {
                placeholder(android.R.drawable.ic_menu_gallery)
                error(android.R.drawable.ic_menu_gallery)
            }
            nameText.text = user.name
            ageText.text = "${user.age}"
        }
    }
}
