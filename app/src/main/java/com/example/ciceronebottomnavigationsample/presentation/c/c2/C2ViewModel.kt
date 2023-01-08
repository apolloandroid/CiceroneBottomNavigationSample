package com.example.ciceronebottomnavigationsample.presentation.c.c2

import androidx.lifecycle.ViewModel
import com.example.ciceronebottomnavigationsample.navigation.routers.ICRouter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class C2ViewModel @Inject constructor(private val cRouter: ICRouter) : ViewModel() {

    fun onNextButtonClicked() = cRouter.routeToC3Fragment()
}