package com.link.awesome.presenter.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.link.awesome.data.service.RemoteService
import com.link.awesome.databinding.FragmentAddLinkBinding
import com.link.awesome.domain.AddLinkUseCase
import com.link.awesome.presenter.viewmodels.AddLinkViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddLinkFragment : Fragment() {

    private lateinit var binding : FragmentAddLinkBinding

    private val viewModel : AddLinkViewModel by lazy {
        ViewModelProvider(this).get(AddLinkViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //set view binding
        binding = FragmentAddLinkBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //set data binding
        binding.vm = viewModel
        initData()
        initView()
    }

    private fun initData() {
        var clippedText = "https://yeontalk.tistory.com/entry/flutter-%EC%98%A4%EB%A5%98%ED%95%B4%EA%B2%B0-Unable-to-find-bundled-Java-version-%ED%95%B4%EA%B2%B0"

        if (clippedText.isNotEmpty()) {
            viewModel.setClippedText(clippedText)
        }
    }

    private fun initView() {
        binding.fabContinue.setOnClickListener {
            if (binding.etAddLink.text.isEmpty()) {
                Toast.makeText(context, "입력창이 비웠습니다.", Toast.LENGTH_SHORT).show()
            } else {
                lifecycleScope.launch {
                    parseLink(binding.etAddLink.text.toString())
                }
            }
        }
    }

    private suspend fun parseLink(url: String) = withContext(Dispatchers.IO) {
        val linkEntity = AddLinkUseCase(RemoteService()).parseLink(binding.etAddLink.text.toString())
        Log.d("TST", "${linkEntity?.title}, ${linkEntity?.content}")
    }
}