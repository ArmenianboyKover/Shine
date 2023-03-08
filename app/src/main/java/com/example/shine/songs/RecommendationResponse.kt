package com.example.shine.songs

data class RecommendationResponse(
    val tracks: List<SongResponse>?
)

data class SongResponse(
    val key: String?,
    val title: String?,
    val subtitle: String?,
    val images: ImagesResponse?,
    val hub: HubResponse?
)

data class ImagesResponse(
    val background: String?,
)

data class HubResponse(
    val actions: List<TrackLink>?,
)

data class TrackLink(
    val uri: String?
)