package com.hints.datingapp.data

object DataRepository {
    private val currentUser = User(
        id = "user1",
        name = "John Doe",
        age = 28,
        bio = "Love to travel and explore new places",
        location = "San Francisco, CA",
        profileImages = listOf("https://picsum.photos/400/500?random=1"),
        profileVideos = emptyList()
    )

    private val sampleUsers = mutableListOf(
        User(
            id = "user2",
            name = "Sarah Smith",
            age = 26,
            bio = "Coffee enthusiast and bookworm",
            location = "New York, NY",
            profileImages = listOf("https://picsum.photos/400/500?random=2")
        ),
        User(
            id = "user3",
            name = "Michael Johnson",
            age = 30,
            bio = "Adventure seeker and photographer",
            location = "Los Angeles, CA",
            profileImages = listOf("https://picsum.photos/400/500?random=3")
        ),
        User(
            id = "user4",
            name = "Emily Brown",
            age = 25,
            bio = "Yoga instructor and food lover",
            location = "Austin, TX",
            profileImages = listOf("https://picsum.photos/400/500?random=4")
        ),
        User(
            id = "user5",
            name = "David Wilson",
            age = 29,
            bio = "Music producer and dog dad",
            location = "Seattle, WA",
            profileImages = listOf("https://picsum.photos/400/500?random=5")
        )
    )

    private val wallPosts = mutableListOf(
        WallPost(
            id = "post1",
            userId = "user1",
            userName = "John Doe",
            content = "Just had an amazing day at the beach! 🏖️",
            timestamp = System.currentTimeMillis() - 3600000,
            likes = 15
        ),
        WallPost(
            id = "post2",
            userId = "user2",
            userName = "Sarah Smith",
            content = "Reading my favorite book at the cafe ☕📚",
            timestamp = System.currentTimeMillis() - 7200000,
            likes = 23
        )
    )

    private val likedUsers = mutableSetOf<String>()
    private val matches = mutableListOf<Match>()

    fun getCurrentUser(): User = currentUser

    fun getDiscoverUsers(): List<User> = sampleUsers.filter { it.id !in likedUsers }

    fun getWallPosts(): List<WallPost> = wallPosts.sortedByDescending { it.timestamp }

    fun addWallPost(post: WallPost) {
        wallPosts.add(0, post)
    }

    fun likeUser(userId: String) {
        likedUsers.add(userId)
        // Simulate match (50% chance)
        if (Math.random() > 0.5) {
            matches.add(Match(
                id = "match_${System.currentTimeMillis()}",
                userId1 = currentUser.id,
                userId2 = userId,
                timestamp = System.currentTimeMillis()
            ))
        }
    }

    fun getLikedUsers(): List<User> = sampleUsers.filter { it.id in likedUsers }

    fun getMatches(): List<Match> = matches

    fun updateUserProfile(user: User) {
        // In a real app, this would update the user in the database
    }
}
