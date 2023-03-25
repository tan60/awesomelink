package com.link.awesome.domain

import com.link.awesome.data.models.LinkModel
import com.link.awesome.data.service.BaseService

class AddLinkUseCase(val service: BaseService) {

    fun parseLink(url: String) : LinkEntity? {
        return convertLinkModelToEntity(service.parseLink(url))
    }

    private fun convertLinkModelToEntity(model : LinkModel): LinkEntity {
        return LinkEntity().apply {
            title = model.title
            content = model.content
            site = model.siteName
            imageUrl = model.thumbnailUrl
            iconUrl = model.iconUrl
        }
    }
}

