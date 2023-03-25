package com.link.awesome.data.service

import com.link.awesome.data.models.LinkModel


interface BaseService {
    fun parseLink(url: String): LinkModel

}