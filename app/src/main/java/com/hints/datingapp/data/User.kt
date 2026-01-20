package com.hints.datingapp.data

data class User(
    val id: String,
    val name: String,
    val age: Int,
    val bio: String,
    val location: String,
    val profileImages: List<String> = emptyList(),
    val profileVideos: List<String> = emptyList(),
    val likedProfiles: Set<String> = emptySet()
)
