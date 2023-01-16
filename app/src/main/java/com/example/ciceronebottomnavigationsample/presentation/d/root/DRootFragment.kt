package com.example.ciceronebottomnavigationsample.presentation.d.root

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.ciceronebottomnavigationsample.R
import com.example.ciceronebottomnavigationsample.databinding.FragmentDRootBinding
import com.example.ciceronebottomnavigationsample.presentation.base.RootFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DRootFragment : RootFragment() {

    private lateinit var binding: FragmentDRootBinding

    override val viewModel: DRootViewModel by viewModels()
    override val fragmentContainerId = R.id.layoutContainerD

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDRootBinding.inflate(inflater, container, false)
        return binding.root
    }
}