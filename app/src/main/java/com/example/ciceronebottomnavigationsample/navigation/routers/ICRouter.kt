package com.example.ciceronebottomnavigationsample.navigation.routers

import com.example.ciceronebottomnavigationsample.navigation.Screens
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

interface ICRouter {
    fun setFirstScreen()
    fun routeToC2Fragment()
    fun routeToC3Fragment()
}

class CRouter @Inject constructor(private val router: Router) : ICRouter {

    override fun setFirstScreen() = router.newRootScreen(Screens.C1Screen())

    override fun routeToC2Fragment() = router.navigateTo(Screens.C2Screen())

    override fun routeToC3Fragment() = router.navigateTo(Screens.C3Screen())
}