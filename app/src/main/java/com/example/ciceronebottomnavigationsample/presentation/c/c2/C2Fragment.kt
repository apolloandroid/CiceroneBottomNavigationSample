package com.example.ciceronebottomnavigationsample.presentation.c.c2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.ciceronebottomnavigationsample.databinding.FragmentC2Binding
import com.example.ciceronebottomnavigationsample.presentation.BackPressable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class C2Fragment : Fragment(), BackPressable {

    private lateinit var binding: FragmentC2Binding

    private val viewModel: C2ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentC2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener { viewModel.onNextButtonClicked() }
    }

    override fun onBackPressed(): Boolean {
        viewModel.onBackPressed()
        return true
    }
}