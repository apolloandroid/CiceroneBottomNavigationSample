package com.example.ciceronebottomnavigationsample.presentation.b.b3

import androidx.lifecycle.ViewModel
import com.example.ciceronebottomnavigationsample.navigation.routers.IBRouter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class B3ViewModel @Inject constructor(private val bRouter: IBRouter) : ViewModel() {

    fun onBackPressed() = bRouter.routeBack()
}