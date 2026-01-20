package com.hints.datingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hints.datingapp.data.DataRepository

class LikesFragment : Fragment() {
    
    private lateinit var likesRecyclerView: RecyclerView
    private lateinit var likesAdapter: LikesAdapter
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_likes, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        likesRecyclerView = view.findViewById(R.id.likes_recycler_view)
        
        likesAdapter = LikesAdapter()
        likesRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        likesRecyclerView.adapter = likesAdapter
        
        loadLikedUsers()
    }
    
    private fun loadLikedUsers() {
        val likedUsers = DataRepository.getLikedUsers()
        likesAdapter.submitList(likedUsers)
    }
}
