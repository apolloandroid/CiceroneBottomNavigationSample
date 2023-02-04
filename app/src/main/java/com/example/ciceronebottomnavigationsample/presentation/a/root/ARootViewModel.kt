package com.example.ciceronebottomnavigationsample.presentation.a.root

import androidx.lifecycle.viewModelScope
import com.example.ciceronebottomnavigationsample.data.AuthRepository
import com.example.ciceronebottomnavigationsample.di.ACicerone
import com.example.ciceronebottomnavigationsample.navigation.routers.ILocalRouter
import com.example.ciceronebottomnavigationsample.presentation.base.RootViewModel
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ARootViewModel @Inject constructor(
    @ACicerone
    override val cicerone: Cicerone<Router>,
    @ACicerone
    override val localRouter: ILocalRouter,
    authRepository: AuthRepository
) : RootViewModel(cicerone, localRouter) {

    init {
        authRepository.loggedIn.onEach {
            if (!it) setFirstScreen()
        }.launchIn(viewModelScope)
    }
}