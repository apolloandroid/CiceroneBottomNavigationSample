package com.example.ciceronebottomnavigationsample.presentation.b.b3

import androidx.lifecycle.ViewModel
import com.example.ciceronebottomnavigationsample.navigation.routers.BRouter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class B3ViewModel @Inject constructor(private val bRouter: BRouter) : ViewModel() {

    fun onBackPressed() = bRouter.routeBack()
}