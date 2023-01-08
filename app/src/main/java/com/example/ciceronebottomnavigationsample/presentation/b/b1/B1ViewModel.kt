package com.example.ciceronebottomnavigationsample.presentation.b.b1

import androidx.lifecycle.ViewModel
import com.example.ciceronebottomnavigationsample.navigation.routers.IBRouter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class B1ViewModel @Inject constructor(private val bRouter: IBRouter) : ViewModel() {

    fun onNextButtonClicked() = bRouter.routeToB2Fragment()
}