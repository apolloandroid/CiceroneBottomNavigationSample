package com.example.ciceronebottomnavigationsample.navigation.routers

import com.example.ciceronebottomnavigationsample.navigation.Screens
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class DRouter @Inject constructor(private val router: Router) : ILocalRouter {

    override fun setFirstScreen() = router.newRootScreen(Screens.D1Screen())

    override fun routeBack() = router.exit()
}