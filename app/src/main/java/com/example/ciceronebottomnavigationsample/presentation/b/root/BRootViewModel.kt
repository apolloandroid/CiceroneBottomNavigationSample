package com.example.ciceronebottomnavigationsample.presentation.b.root

import com.example.ciceronebottomnavigationsample.di.BCicerone
import com.example.ciceronebottomnavigationsample.navigation.routers.IBRouter
import com.example.ciceronebottomnavigationsample.presentation.base.RootViewModel
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BRootViewModel @Inject constructor(
    @BCicerone
    override val cicerone: Cicerone<Router>,
    private val bRouter: IBRouter
) : RootViewModel(cicerone) {

    override fun setFirstScreen() = bRouter.setFirstScreen()
}