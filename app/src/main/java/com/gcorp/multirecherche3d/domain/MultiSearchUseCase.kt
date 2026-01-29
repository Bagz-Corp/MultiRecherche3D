package com.gcorp.multirecherche3d.domain

import com.gcorp.multirecherche3d.data.SearchRepository
import com.gcorp.multirecherche3d.domain.model.ModelItem
import javax.inject.Inject


class MultiSearchUseCase @Inject constructor(
    val searchRepository: SearchRepository
) {

    suspend operator fun invoke(searchQuery: String): List<ModelItem> {
        return searchRepository.multiSearch(searchQuery)
    }

}
