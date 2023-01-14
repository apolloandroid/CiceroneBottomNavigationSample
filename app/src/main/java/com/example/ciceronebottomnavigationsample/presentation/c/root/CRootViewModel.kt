package com.example.ciceronebottomnavigationsample.presentation.c.root

import com.example.ciceronebottomnavigationsample.di.CCicerone
import com.example.ciceronebottomnavigationsample.di.CLocalRouter
import com.example.ciceronebottomnavigationsample.navigation.routers.ILocalRouter
import com.example.ciceronebottomnavigationsample.presentation.base.RootViewModel
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CRootViewModel @Inject constructor(
    @CCicerone
    override val cicerone: Cicerone<Router>,
    @CLocalRouter
    private val localRouter: ILocalRouter
) : RootViewModel(cicerone, localRouter)