package com.example.ciceronebottomnavigationsample.navigation.routers

import com.example.ciceronebottomnavigationsample.navigation.Screens
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

interface IARouter : ILocalRouter {
    fun routeToA2Fragment()
    fun routeToA3Fragment()
}

class ARouter @Inject constructor(private val router: Router) : IARouter {

    override fun setFirstScreen() = router.newRootScreen(Screens.A1Screen())

    override fun routeBack() = router.exit()

    override fun routeToA2Fragment() = router.navigateTo(Screens.A2Screen())

    override fun routeToA3Fragment() = router.navigateTo(Screens.A3Screen())
}