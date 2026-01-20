package com.hints.datingapp

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import coil.load
import com.hints.datingapp.data.DataRepository
import com.hints.datingapp.data.User

class DiscoverFragment : Fragment() {
    
    private lateinit var profileImage: ImageView
    private lateinit var profileName: TextView
    private lateinit var profileAge: TextView
    private lateinit var profileBio: TextView
    private lateinit var profileLocation: TextView
    private lateinit var likeButton: Button
    private lateinit var passButton: Button
    private lateinit var noMoreProfilesText: TextView
    
    private var currentUsers: MutableList<User> = mutableListOf()
    private var currentIndex = 0
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        profileImage = view.findViewById(R.id.profile_image)
        profileName = view.findViewById(R.id.profile_name)
        profileAge = view.findViewById(R.id.profile_age)
        profileBio = view.findViewById(R.id.profile_bio)
        profileLocation = view.findViewById(R.id.profile_location)
        likeButton = view.findViewById(R.id.like_button)
        passButton = view.findViewById(R.id.pass_button)
        noMoreProfilesText = view.findViewById(R.id.no_more_profiles_text)
        
        loadUsers()
        
        likeButton.setOnClickListener {
            if (currentIndex < currentUsers.size) {
                val user = currentUsers[currentIndex]
                DataRepository.likeUser(user.id)
                animateSwipeRight()
            }
        }
        
        passButton.setOnClickListener {
            animateSwipeLeft()
        }
        
        // Simple swipe gesture handling
        var startX = 0f
        profileImage.setOnTouchListener { v, event ->
            when (event.action) {
                android.view.MotionEvent.ACTION_DOWN -> {
                    startX = event.x
                }
                android.view.MotionEvent.ACTION_UP -> {
                    val endX = event.x
                    val diff = endX - startX
                    
                    if (diff > 200) {
                        // Swipe right - like
                        if (currentIndex < currentUsers.size) {
                            val user = currentUsers[currentIndex]
                            DataRepository.likeUser(user.id)
                            animateSwipeRight()
                        }
                    } else if (diff < -200) {
                        // Swipe left - pass
                        animateSwipeLeft()
                    }
                }
            }
            true
        }
    }
    
    private fun loadUsers() {
        currentUsers = DataRepository.getDiscoverUsers().toMutableList()
        currentIndex = 0
        showCurrentUser()
    }
    
    private fun showCurrentUser() {
        if (currentIndex < currentUsers.size) {
            val user = currentUsers[currentIndex]
            profileImage.load(user.profileImages.firstOrNull() ?: "") {
                placeholder(android.R.drawable.ic_menu_gallery)
                error(android.R.drawable.ic_menu_gallery)
            }
            profileName.text = user.name
            profileAge.text = "${user.age}"
            profileBio.text = user.bio
            profileLocation.text = user.location
            
            profileImage.visibility = View.VISIBLE
            profileName.visibility = View.VISIBLE
            profileAge.visibility = View.VISIBLE
            profileBio.visibility = View.VISIBLE
            profileLocation.visibility = View.VISIBLE
            likeButton.visibility = View.VISIBLE
            passButton.visibility = View.VISIBLE
            noMoreProfilesText.visibility = View.GONE
        } else {
            profileImage.visibility = View.GONE
            profileName.visibility = View.GONE
            profileAge.visibility = View.GONE
            profileBio.visibility = View.GONE
            profileLocation.visibility = View.GONE
            likeButton.visibility = View.GONE
            passButton.visibility = View.GONE
            noMoreProfilesText.visibility = View.VISIBLE
        }
    }
    
    private fun animateSwipeRight() {
        profileImage.animate()
            .translationX(1000f)
            .alpha(0f)
            .setDuration(300)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    currentIndex++
                    profileImage.translationX = 0f
                    profileImage.alpha = 1f
                    showCurrentUser()
                }
            })
    }
    
    private fun animateSwipeLeft() {
        profileImage.animate()
            .translationX(-1000f)
            .alpha(0f)
            .setDuration(300)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    currentIndex++
                    profileImage.translationX = 0f
                    profileImage.alpha = 1f
                    showCurrentUser()
                }
            })
    }
}
