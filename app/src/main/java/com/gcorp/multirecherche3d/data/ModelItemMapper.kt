package com.gcorp.multirecherche3d.data

import com.gcorp.multirecherche3d.domain.model.ModelItem
import com.gcorp.multirecherche3d.domain.model.Thumbnail
import com.gcorp.multirecherche3d.network.model.SketchFabModel
import java.net.URI

fun SketchFabModel.toModelItem() = ModelItem(
    thumbnails = thumbnails.images.map {
        Thumbnail(
            url = URI(it.url),
            width = it.width,
            height = it.height
        )
    },
    title = this.name,
    likeCount = this.likeCount,
    url = viewerUrl
)
