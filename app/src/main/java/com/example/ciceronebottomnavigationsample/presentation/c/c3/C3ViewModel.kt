package com.example.ciceronebottomnavigationsample.presentation.c.c3

import androidx.lifecycle.ViewModel
import com.example.ciceronebottomnavigationsample.navigation.routers.ICRouter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class C3ViewModel @Inject constructor(private val cRouter: ICRouter) : ViewModel() {

    fun onBackPressed() = cRouter.routeBack()
}