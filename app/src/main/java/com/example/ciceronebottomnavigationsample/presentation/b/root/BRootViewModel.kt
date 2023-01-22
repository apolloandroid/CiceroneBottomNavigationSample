package com.example.ciceronebottomnavigationsample.presentation.b.root

import com.example.ciceronebottomnavigationsample.di.BCicerone
import com.example.ciceronebottomnavigationsample.navigation.routers.ILocalRouter
import com.example.ciceronebottomnavigationsample.presentation.base.RootViewModel
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BRootViewModel @Inject constructor(
    @BCicerone
    override val cicerone: Cicerone<Router>,
    @BCicerone
    override val localRouter: ILocalRouter
) : RootViewModel(cicerone, localRouter)