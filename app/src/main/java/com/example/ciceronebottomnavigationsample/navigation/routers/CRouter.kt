package com.example.ciceronebottomnavigationsample.navigation.routers

import com.example.ciceronebottomnavigationsample.navigation.Screens
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class CRouter @Inject constructor(private val router: Router) : ILocalRouter {

    override fun setFirstScreen() = router.newRootScreen(Screens.C1Screen())

    override fun routeBack() = router.exit()

    fun routeToC2Fragment() = router.navigateTo(Screens.C2Screen())

    fun routeToC3Fragment() = router.navigateTo(Screens.C3Screen())
}