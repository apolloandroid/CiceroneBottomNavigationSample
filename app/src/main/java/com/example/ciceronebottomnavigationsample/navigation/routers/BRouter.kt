package com.example.ciceronebottomnavigationsample.navigation.routers

import com.example.ciceronebottomnavigationsample.navigation.Screens
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class BRouter @Inject constructor(private val router: Router) : ILocalRouter {

    override fun setFirstScreen() = router.newRootScreen(Screens.B1Screen())

    override fun routeBack() = router.exit()

    fun routeToB2Fragment() = router.navigateTo(Screens.B2Screen())

    fun routeToB3Fragment() = router.navigateTo(Screens.B3Screen())
}