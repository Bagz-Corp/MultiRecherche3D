package com.gcorp.multirecherche3d.network.model

import kotlinx.serialization.Serializable

@Serializable
data class SketchFabPayload(
    val results: List<SketchFabModel>,
    val next: String
)

@Serializable
data class SketchFabModel(
    val name: String,
    val viewerUrl: String,
    val publishedAt: String,
    val likeCount: Int,
    val thumbnails: Thumbnails
)

@Serializable
data class Thumbnails(
    val images: ArrayList<ImageData>
)

@Serializable
data class ImageData(
    val url: String,
    val width: Int,
    val height: Int
)