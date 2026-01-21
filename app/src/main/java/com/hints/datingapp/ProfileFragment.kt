package com.hints.datingapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import coil.load
import com.hints.datingapp.data.DataRepository

class ProfileFragment : Fragment() {
    
    private lateinit var profileImage: ImageView
    private lateinit var nameText: TextView
    private lateinit var ageText: TextView
    private lateinit var bioText: TextView
    private lateinit var locationText: TextView
    private lateinit var uploadPhotoButton: Button
    private lateinit var uploadVideoButton: Button
    private lateinit var editProfileButton: Button
    
    private val imagePickerLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val imageUri = data?.data
            if (imageUri != null) {
                profileImage.load(imageUri)
                // In a real app, you would upload this to a server
            }
        }
    }
    
    private val videoPickerLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // In a real app, you would handle video upload here
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        profileImage = view.findViewById(R.id.profile_image)
        nameText = view.findViewById(R.id.name_text)
        ageText = view.findViewById(R.id.age_text)
        bioText = view.findViewById(R.id.bio_text)
        locationText = view.findViewById(R.id.location_text)
        uploadPhotoButton = view.findViewById(R.id.upload_photo_button)
        uploadVideoButton = view.findViewById(R.id.upload_video_button)
        editProfileButton = view.findViewById(R.id.edit_profile_button)
        
        loadUserProfile()
        
        uploadPhotoButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            imagePickerLauncher.launch(intent)
        }
        
        uploadVideoButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI)
            videoPickerLauncher.launch(intent)
        }
        
        editProfileButton.setOnClickListener {
            // In a real app, this would open an edit profile screen
        }
    }
    
    private fun loadUserProfile() {
        val user = DataRepository.getCurrentUser()
        
        profileImage.load(user.profileImages.firstOrNull() ?: "") {
            placeholder(android.R.drawable.ic_menu_myplaces)
            error(android.R.drawable.ic_menu_myplaces)
        }
        
        nameText.text = user.name
        ageText.text = "Age: ${user.age}"
        bioText.text = user.bio
        locationText.text = user.location
    }
}
