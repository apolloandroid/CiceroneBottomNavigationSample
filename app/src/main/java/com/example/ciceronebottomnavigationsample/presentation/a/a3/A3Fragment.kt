package com.example.ciceronebottomnavigationsample.presentation.a.a3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.ciceronebottomnavigationsample.R
import com.example.ciceronebottomnavigationsample.presentation.base.BackPressable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class A3Fragment : Fragment(), BackPressable {

    private val viewModel: A3ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a3, container, false)
    }

    override fun onBackPressed(): Boolean {
        viewModel.onBackPressed()
        return true
    }
}