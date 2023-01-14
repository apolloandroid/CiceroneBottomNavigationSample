package com.example.ciceronebottomnavigationsample.presentation.b.b2

import androidx.lifecycle.ViewModel
import com.example.ciceronebottomnavigationsample.navigation.routers.IBRouter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class B2ViewModel @Inject constructor(private val bRouter: IBRouter) : ViewModel() {

    fun onNextButtonClicked() = bRouter.routeToB3Fragment()

    fun onBackPressed() = bRouter.routeBack()
}