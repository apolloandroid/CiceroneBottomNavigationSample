package com.example.ciceronebottomnavigationsample.navigation

import com.example.ciceronebottomnavigationsample.presentation.a.a1.A1Fragment
import com.example.ciceronebottomnavigationsample.presentation.a.a2.A2Fragment
import com.example.ciceronebottomnavigationsample.presentation.a.a3.A3Fragment
import com.example.ciceronebottomnavigationsample.presentation.a.root.ARootFragment
import com.example.ciceronebottomnavigationsample.presentation.b.b1.B1Fragment
import com.example.ciceronebottomnavigationsample.presentation.b.b2.B2Fragment
import com.example.ciceronebottomnavigationsample.presentation.b.b3.B3Fragment
import com.example.ciceronebottomnavigationsample.presentation.b.root.BRootFragment
import com.example.ciceronebottomnavigationsample.presentation.c.c1.C1Fragment
import com.example.ciceronebottomnavigationsample.presentation.c.c2.C2Fragment
import com.example.ciceronebottomnavigationsample.presentation.c.c3.C3Fragment
import com.example.ciceronebottomnavigationsample.presentation.c.root.CRootFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun RootScreen(tabTag: String) = FragmentScreen {
        when (tabTag) {
            TabTags.TAG_A -> ARootFragment()
            TabTags.TAG_B -> BRootFragment()
            else -> CRootFragment()
        }
    }

    // A tab screens
    fun A1Screen() = FragmentScreen { A1Fragment() }

    fun A2Screen() = FragmentScreen { A2Fragment() }

    fun A3Screen() = FragmentScreen { A3Fragment() }

    // B tab screens
    fun B1Screen() = FragmentScreen { B1Fragment() }

    fun B2Screen() = FragmentScreen { B2Fragment() }

    fun B3Screen() = FragmentScreen { B3Fragment() }

    // C tab screens
    fun C1Screen() = FragmentScreen { C1Fragment() }

    fun C2Screen() = FragmentScreen { C2Fragment() }

    fun C3Screen() = FragmentScreen { C3Fragment() }
}