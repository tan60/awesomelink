package com.link.awesome.presenter.viewmodels

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.link.awesome.domain.LinkEntity

class AddLinkViewModel : ViewModel() {

    var url : String = ""

    var editText = ObservableField<String>()
    var canAttach = ObservableField<Boolean>()
    var canParsing = ObservableField<Boolean>()
    var isShowEditText = ObservableField<Boolean>()
    var isParsing = ObservableField<Boolean>()
    var isParsingComplete = ObservableField<Boolean>()

    var title = ObservableField<String>()
    var content = ObservableField<String>()
    var image = ObservableField<String>()

    init {
        isShowEditText.set(true)
        isParsing.set(false)
        canParsing.set(false)
        isParsingComplete.set(false)
    }

    fun updateInputText(text: String) {
        //check Web link

        editText.set(text)

        if (text.isNotEmpty()) {
            canParsing.set(true)
        }
    }

    fun setClippedText(text: String) {
        editText.set(text)
        canParsing.set(text.isNotEmpty())
        canAttach.set(text.isNotEmpty())
    }

    fun updateLink(title: String, content: String, imageUrl: String) {
        this.title.set(content)
        this.content.set(content)
        this.image.set(imageUrl)
        this.isParsing.set(false)
        this.isParsingComplete.set(true)
    }

    fun fetchUrl() : Boolean {
        return false
    }

    fun getClippedText() {

    }


}