package com.example.ciceronebottomnavigationsample.presentation.c.root

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.ciceronebottomnavigationsample.R
import com.example.ciceronebottomnavigationsample.databinding.FragmentCRootBinding
import com.example.ciceronebottomnavigationsample.presentation.base.RootFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CRootFragment : RootFragment() {

    private lateinit var binding: FragmentCRootBinding

    override val viewModel: CRootViewModel by viewModels()
    override val fragmentContainerId = R.id.layoutContainerC

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCRootBinding.inflate(inflater, container, false)
        return binding.root
    }
}