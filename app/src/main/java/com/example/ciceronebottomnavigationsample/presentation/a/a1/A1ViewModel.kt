package com.example.ciceronebottomnavigationsample.presentation.a.a1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ciceronebottomnavigationsample.data.AuthRepository
import com.example.ciceronebottomnavigationsample.navigation.routers.ARouter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class A1ViewModel @Inject constructor(
    private val aRouter: ARouter,
    private val authRepository: AuthRepository
) : ViewModel() {

    val isAuthenticated = authRepository.isAuthenticated

    fun onNextButtonClicked() = aRouter.routeToA2Fragment()

    fun onLogInButtonClicked() {
        viewModelScope.launch {
            authRepository.setAuthenticated(true)
        }
    }
}