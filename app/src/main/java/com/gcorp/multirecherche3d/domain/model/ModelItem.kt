package com.gcorp.multirecherche3d.domain.model

import java.net.URI

data class ModelItem (
    val thumbnails: List<Thumbnail>,
    val title: String,
    val likeCount: Int,
    val url: String
)

data class Thumbnail(
    val url: URI,
    val width: Int,
    val height: Int
)