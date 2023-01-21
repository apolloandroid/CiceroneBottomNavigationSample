package com.example.ciceronebottomnavigationsample.presentation.main

import androidx.lifecycle.ViewModel
import com.example.ciceronebottomnavigationsample.data.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(authRepository: AuthRepository) : ViewModel() {

    val isAuthenticated = authRepository.isAuthenticated
}