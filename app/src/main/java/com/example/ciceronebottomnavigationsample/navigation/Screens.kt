package com.example.ciceronebottomnavigationsample.navigation

import com.example.ciceronebottomnavigationsample.R
import com.example.ciceronebottomnavigationsample.presentation.a.RootAFragment
import com.example.ciceronebottomnavigationsample.presentation.b.RootBFragment
import com.example.ciceronebottomnavigationsample.presentation.c.RootCFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun RootScreen(bottomTabId: String) = FragmentScreen {
        when (bottomTabId) {
            R.id.menuItemA.toString() -> RootAFragment()
            R.id.menuItemB.toString() -> RootBFragment()
            else -> RootCFragment()
        }
    }
}