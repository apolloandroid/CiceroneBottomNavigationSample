package com.example.ciceronebottomnavigationsample.navigation

import com.example.ciceronebottomnavigationsample.R
import com.example.ciceronebottomnavigationsample.presentation.a.RootAFragment
import com.example.ciceronebottomnavigationsample.presentation.b.RootBFragment
import com.example.ciceronebottomnavigationsample.presentation.c.RootCFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun RootScreen(tabTag: String) = FragmentScreen {
        when (tabTag) {
            TabTags.TAG_A -> ARootFragment()
            TabTags.TAG_B -> BRootFragment()
            else -> CRootFragment()
        }
    }
}