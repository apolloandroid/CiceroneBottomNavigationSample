package com.example.ciceronebottomnavigationsample.presentation.d.root

import com.example.ciceronebottomnavigationsample.di.DCicerone
import com.example.ciceronebottomnavigationsample.di.DLocalRouter
import com.example.ciceronebottomnavigationsample.navigation.routers.ILocalRouter
import com.example.ciceronebottomnavigationsample.presentation.base.RootViewModel
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DRootViewModel @Inject constructor(
    @DCicerone
    override val cicerone: Cicerone<Router>,
    @DLocalRouter
    override val localRouter: ILocalRouter
) : RootViewModel(cicerone, localRouter)