package com.example.ciceronebottomnavigationsample.presentation.b.b3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.ciceronebottomnavigationsample.R
import com.example.ciceronebottomnavigationsample.presentation.BackPressable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class B3Fragment : Fragment(), BackPressable {

    private val viewModel: B3ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b3, container, false)
    }

    override fun onBackPressed(): Boolean {
        viewModel.onBackPressed()
        return true
    }
}