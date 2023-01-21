package com.example.ciceronebottomnavigationsample.presentation.a.a1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.ciceronebottomnavigationsample.databinding.FragmentA1Binding
import com.example.ciceronebottomnavigationsample.presentation.collectOnLifecycle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class A1Fragment : Fragment() {

    private lateinit var binding: FragmentA1Binding
    private val viewModel: A1ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentA1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpNextButton()
        setUpLogInButton()
        subscribeOnViewModel()
    }

    private fun setUpNextButton() = binding.buttonNext.setOnClickListener {
        viewModel.onNextButtonClicked()
    }

    private fun setUpLogInButton() = binding.buttonLogIn.setOnClickListener {
        viewModel.onLogInButtonClicked()
    }

    private fun subscribeOnViewModel() = collectOnLifecycle(viewModel.isAuthenticated) {
        binding.buttonNext.isVisible = it
        binding.buttonLogIn.isVisible = !it
    }
}