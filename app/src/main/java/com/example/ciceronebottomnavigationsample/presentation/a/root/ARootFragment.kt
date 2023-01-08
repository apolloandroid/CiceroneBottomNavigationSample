package com.example.ciceronebottomnavigationsample.presentation.a.root

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.ciceronebottomnavigationsample.R
import com.example.ciceronebottomnavigationsample.databinding.FragmentARootBinding
import com.example.ciceronebottomnavigationsample.presentation.base.RootFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ARootFragment : RootFragment() {

    private lateinit var binding: FragmentARootBinding

    override val viewModel: ARootViewModel by viewModels()
    override val fragmentContainerId = R.id.layoutContainerA

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentARootBinding.inflate(inflater, container, false)
        return binding.root
    }
}