package com.hints.datingapp.data

data class WallPost(
    val id: String,
    val userId: String,
    val userName: String,
    val content: String,
    val timestamp: Long,
    val likes: Int = 0,
    val mediaUrl: String? = null,
    val mediaType: MediaType = MediaType.NONE
)

enum class MediaType {
    NONE, IMAGE, VIDEO
}
