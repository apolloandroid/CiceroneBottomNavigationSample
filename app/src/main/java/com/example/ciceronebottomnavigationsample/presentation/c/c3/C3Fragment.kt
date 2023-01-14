package com.example.ciceronebottomnavigationsample.presentation.c.c3

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
class C3Fragment : Fragment(), BackPressable {

    private val viewModel: C3ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_c3, container, false)
    }

    override fun onBackPressed(): Boolean {
        viewModel.onBackPressed()
        return true
    }
}