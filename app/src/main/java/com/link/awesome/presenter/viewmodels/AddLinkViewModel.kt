package com.link.awesome.presenter.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class AddLinkViewModel : ViewModel() {

    var url : String = ""

    var editText = ObservableField<String>()

    var canAttach = ObservableField<Boolean>()

    var canFetching = ObservableField<Boolean>()

    var isFetching = ObservableField<Boolean>()

    init {
        isFetching.set(false)
        canFetching.set(false)



    }

    fun updateInputText(text: String) {
        //check Web link

        editText.set(text)

        if (text.isNotEmpty()) {
            canFetching.set(true)
        }
    }

    fun setClippedText(text: String) {
        editText.set(text)
        canFetching.set(text.isNotEmpty())
        canAttach.set(text.isNotEmpty())
    }

    fun fetchUrl() : Boolean {
        return false
    }

    fun getClippedText() {

    }


}