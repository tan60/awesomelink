package com.link.awesome.data.service

import com.link.awesome.data.models.LinkModel
import org.jsoup.Jsoup

class RemoteService : BaseService {
    override fun parseLink(url: String): LinkModel {
        return parse(url)
    }


    private fun parse(url: String) : LinkModel {
        return LinkModel().apply {
            val doc = Jsoup.connect(url).get()
            title = doc.title()
            thumbnailUrl = doc.select("meta[property=og:image]").attr("content")
            content = doc.select("meta[property=og:description]").attr("content")
            siteName = doc.select("meta[property=og:site_name]").attr("content")
            //iconUrl = doc.select("link[rel*=icon], link[href*=favicon]").attr("href")
        }
    }
}