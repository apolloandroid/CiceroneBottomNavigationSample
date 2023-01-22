package com.example.ciceronebottomnavigationsample.presentation.b.b2

import androidx.lifecycle.ViewModel
import com.example.ciceronebottomnavigationsample.navigation.routers.BRouter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class B2ViewModel @Inject constructor(private val bRouter: BRouter) : ViewModel() {

    fun onNextButtonClicked() = bRouter.routeToB3Fragment()

    fun onBackPressed() = bRouter.routeBack()
}