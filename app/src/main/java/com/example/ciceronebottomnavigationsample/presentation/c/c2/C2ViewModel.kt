package com.example.ciceronebottomnavigationsample.presentation.c.c2

import androidx.lifecycle.ViewModel
import com.example.ciceronebottomnavigationsample.navigation.routers.CRouter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class C2ViewModel @Inject constructor(private val cRouter: CRouter) : ViewModel() {

    fun onNextButtonClicked() = cRouter.routeToC3Fragment()

    fun onBackPressed() = cRouter.routeBack()
}