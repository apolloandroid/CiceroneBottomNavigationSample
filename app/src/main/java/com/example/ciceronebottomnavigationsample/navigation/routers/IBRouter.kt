package com.example.ciceronebottomnavigationsample.navigation.routers

import com.example.ciceronebottomnavigationsample.navigation.Screens
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

interface IBRouter {
    fun setFirstScreen()
    fun routeToB2Fragment()
    fun routeToB3Fragment()
}

class BRouter @Inject constructor(private val router: Router) : IBRouter {

    override fun setFirstScreen() = router.newRootScreen(Screens.B1Screen())

    override fun routeToB2Fragment() = router.navigateTo(Screens.B2Screen())

    override fun routeToB3Fragment() = router.navigateTo(Screens.B3Screen())
}