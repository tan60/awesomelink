package com.link.awesome.data.service

import com.link.awesome.data.models.LinkModel

class LocalService: BaseService {
    override fun parseLink(url: String): LinkModel {
        return LinkModel().apply {
            title = "dummy title"
            content = "dummy content"
            siteName = "dummy site"
        }
    }
}