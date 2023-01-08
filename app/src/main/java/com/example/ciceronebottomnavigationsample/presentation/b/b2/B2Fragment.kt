package com.example.ciceronebottomnavigationsample.presentation.b.b2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.ciceronebottomnavigationsample.databinding.FragmentB2Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class B2Fragment : Fragment() {

    private lateinit var binding: FragmentB2Binding

    private val viewModel: B2ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentB2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener { viewModel.onNextButtonClicked() }
    }
}