package com.example.ciceronebottomnavigationsample.presentation.b.root

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.ciceronebottomnavigationsample.R
import com.example.ciceronebottomnavigationsample.databinding.FragmentBRootBinding
import com.example.ciceronebottomnavigationsample.presentation.base.RootFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BRootFragment : RootFragment() {

    private lateinit var binding: FragmentBRootBinding

    override val viewModel: BRootViewModel by viewModels()
    override val fragmentContainerId = R.id.layoutContainerB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBRootBinding.inflate(inflater, container, false)
        return binding.root
    }
}