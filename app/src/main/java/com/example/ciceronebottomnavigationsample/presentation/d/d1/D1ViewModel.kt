package com.example.ciceronebottomnavigationsample.presentation.d.d1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ciceronebottomnavigationsample.data.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class D1ViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {

    val isAuthenticated = authRepository.loggedIn

    fun onLogOutButtonClicked() {
        viewModelScope.launch { authRepository.logOut() }
    }
}