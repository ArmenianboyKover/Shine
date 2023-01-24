package com.example.shine.songs

data class RecommendationResponse(
    val tracks: List<SongResponse>?
)

data class SongResponse(
    val key: String?,
    val title: String?,
    val subtitle: String?,
    val images: ImagesResponse?
)

data class ImagesResponse(
    val background: String?,
)