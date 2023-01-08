package com.example.ciceronebottomnavigationsample.presentation.a.root

import com.example.ciceronebottomnavigationsample.di.ACicerone
import com.example.ciceronebottomnavigationsample.navigation.routers.IARouter
import com.example.ciceronebottomnavigationsample.presentation.base.RootViewModel
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ARootViewModel @Inject constructor(
    @ACicerone
    override val cicerone: Cicerone<Router>,
    private val aRouter: IARouter
) : RootViewModel(cicerone) {

    override fun setFirstScreen() = aRouter.setFirstScreen()
}