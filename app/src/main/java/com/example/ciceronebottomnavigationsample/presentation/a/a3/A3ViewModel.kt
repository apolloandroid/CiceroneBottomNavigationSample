package com.example.ciceronebottomnavigationsample.presentation.a.a3

import androidx.lifecycle.ViewModel
import com.example.ciceronebottomnavigationsample.navigation.routers.ARouter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class A3ViewModel @Inject constructor(private val aRouter: ARouter) : ViewModel() {

    fun onBackPressed() = aRouter.routeBack()
}