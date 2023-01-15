package com.example.ciceronebottomnavigationsample.presentation.base

import androidx.lifecycle.ViewModel
import com.example.ciceronebottomnavigationsample.navigation.routers.ILocalRouter
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.Router

abstract class RootViewModel(
    open val cicerone: Cicerone<Router>,
    open val localRouter: ILocalRouter
) : ViewModel() {

    open fun onResume(navigator: Navigator) = cicerone.getNavigatorHolder().setNavigator(navigator)

    open fun onPause() = cicerone.getNavigatorHolder().removeNavigator()

    open fun setFirstScreen() = localRouter.setFirstScreen()
}