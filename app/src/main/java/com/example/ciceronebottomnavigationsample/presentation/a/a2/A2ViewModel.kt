package com.example.ciceronebottomnavigationsample.presentation.a.a2

import androidx.lifecycle.ViewModel
import com.example.ciceronebottomnavigationsample.navigation.routers.ARouter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class A2ViewModel @Inject constructor(private val aRouter: ARouter) : ViewModel() {

    fun onNextButtonClicked() = aRouter.routeToA3Fragment()

    fun onBackPressed() = aRouter.routeBack()
}