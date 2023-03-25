package com.link.awesome.presenter.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.link.awesome.databinding.ActivityAddLinkBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import java.io.IOException

class AddLinkActivity : AppCompatActivity() {
    val TAG = "AddLink"

    private lateinit var binding: ActivityAddLinkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddLinkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            fetchLink("https://techblog.woowahan.com/10795/")
            fetchLink("https://yeontalk.tistory.com/entry/flutter-%EC%98%A4%EB%A5%98%ED%95%B4%EA%B2%B0-Unable-to-find-bundled-Java-version-%ED%95%B4%EA%B2%B0")
        }
    }

    private fun initView() {

    }

    suspend fun fetchLink(url: String) = withContext(Dispatchers.IO){

        try {
            val doc = Jsoup.connect(url).get()

            val title = doc.title()
            Log.d(TAG, "fecthLink: title = $title")

            val imageUrl = doc.select("meta[property=og:image]").attr("content")
            Log.d(TAG, "fecthLink: imageUrl = $imageUrl")

            val content = doc.select("meta[property=og:description]").attr("content")
            Log.d(TAG, "fetchLink : content = $content")

            val siteName = doc.select("meta[property=og:site_name]").attr("content")
            Log.d(TAG, "fetchLink : siteName = $siteName")
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}