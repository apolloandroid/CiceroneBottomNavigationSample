package com.example.ciceronebottomnavigationsample.presentation.c.c1

import androidx.lifecycle.ViewModel
import com.example.ciceronebottomnavigationsample.navigation.routers.CRouter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class C1ViewModel @Inject constructor(private val cRouter: CRouter) : ViewModel() {

    fun onNextButtonClicked() = cRouter.routeToC2Fragment()
}