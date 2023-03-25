package com.link.awesome.data.models

data class LinkModel (
    var postNo : Int= -1,
    var title : String = "",
    var content : String = "",
    var siteName : String = "",
    var thumbnailUrl : String = "",
    var iconUrl : String = "",
    var issueDate : String = "", //YYYYMMDD
    var tags: Array<String> = arrayOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LinkModel

        if (!tags.contentEquals(other.tags)) return false

        return true
    }

    override fun hashCode(): Int {
        return tags.contentHashCode()
    }
}