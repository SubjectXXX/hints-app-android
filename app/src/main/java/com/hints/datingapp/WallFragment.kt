package com.hints.datingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hints.datingapp.data.DataRepository
import com.hints.datingapp.data.WallPost
import java.util.UUID

class WallFragment : Fragment() {
    
    private lateinit var postInput: EditText
    private lateinit var postButton: Button
    private lateinit var postsRecyclerView: RecyclerView
    private lateinit var postsAdapter: WallPostsAdapter
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wall, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        postInput = view.findViewById(R.id.post_input)
        postButton = view.findViewById(R.id.post_button)
        postsRecyclerView = view.findViewById(R.id.posts_recycler_view)
        
        postsAdapter = WallPostsAdapter()
        postsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        postsRecyclerView.adapter = postsAdapter
        
        loadPosts()
        
        postButton.setOnClickListener {
            val content = postInput.text.toString()
            if (content.isNotBlank()) {
                val currentUser = DataRepository.getCurrentUser()
                val post = WallPost(
                    id = UUID.randomUUID().toString(),
                    userId = currentUser.id,
                    userName = currentUser.name,
                    content = content,
                    timestamp = System.currentTimeMillis()
                )
                DataRepository.addWallPost(post)
                postInput.text.clear()
                loadPosts()
            }
        }
    }
    
    private fun loadPosts() {
        val posts = DataRepository.getWallPosts()
        postsAdapter.submitList(posts)
    }
}
