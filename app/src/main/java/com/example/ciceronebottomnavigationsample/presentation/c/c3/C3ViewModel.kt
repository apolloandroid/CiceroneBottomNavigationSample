package com.example.ciceronebottomnavigationsample.presentation.c.c3

import androidx.lifecycle.ViewModel
import com.example.ciceronebottomnavigationsample.navigation.routers.CRouter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class C3ViewModel @Inject constructor(private val cRouter: CRouter) : ViewModel() {

    fun onBackPressed() = cRouter.routeBack()
}