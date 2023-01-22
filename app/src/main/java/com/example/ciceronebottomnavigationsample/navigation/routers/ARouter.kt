package com.example.ciceronebottomnavigationsample.navigation.routers

import com.example.ciceronebottomnavigationsample.navigation.Screens
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class ARouter @Inject constructor(private val router: Router) : ILocalRouter {

    override fun setFirstScreen() = router.newRootScreen(Screens.A1Screen())

    override fun routeBack() = router.exit()

    fun routeToA2Fragment() = router.navigateTo(Screens.A2Screen())

    fun routeToA3Fragment() = router.navigateTo(Screens.A3Screen())
}