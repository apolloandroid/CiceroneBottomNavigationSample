package com.example.ciceronebottomnavigationsample.presentation.d.d1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.ciceronebottomnavigationsample.databinding.FragmentD1Binding
import com.example.ciceronebottomnavigationsample.presentation.collectOnLifecycle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class D1Fragment : Fragment() {
    private lateinit var binding: FragmentD1Binding
    private val viewModel: D1ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentD1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpLogOutButton()
        subscribeOnViewModel()
    }

    private fun setUpLogOutButton() = binding.buttonLogOut.setOnClickListener {
        viewModel.onLogOutButtonClicked()
    }

    private fun subscribeOnViewModel() = collectOnLifecycle(viewModel.isAuthenticated) {
        binding.buttonLogOut.isVisible = it
    }
}