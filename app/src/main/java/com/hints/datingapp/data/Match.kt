package com.hints.datingapp.data

data class Match(
    val id: String,
    val userId1: String,
    val userId2: String,
    val timestamp: Long,
    val isActive: Boolean = true
)
