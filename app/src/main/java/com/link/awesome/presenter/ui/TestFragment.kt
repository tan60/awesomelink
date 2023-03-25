package com.link.awesome.presenter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.link.awesome.databinding.FragmentTestBinding
import com.link.awesome.presenter.viewmodels.TestViewModel

class TestFragment: Fragment() {
    private lateinit var binding: FragmentTestBinding

    private val viewModel: TestViewModel by lazy {
        ViewModelProvider(this).get(TestViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTestBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.testViewModel = viewModel

        viewModel.text1 = "This is text 1"
        viewModel.text2 = "This is text 2"

    }
}