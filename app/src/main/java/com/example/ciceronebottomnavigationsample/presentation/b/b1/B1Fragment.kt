package com.example.ciceronebottomnavigationsample.presentation.b.b1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.ciceronebottomnavigationsample.databinding.FragmentB1Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class B1Fragment : Fragment() {

    private lateinit var binding: FragmentB1Binding
    private val viewModel: B1ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentB1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener { viewModel.onNextButtonClicked() }
    }
}