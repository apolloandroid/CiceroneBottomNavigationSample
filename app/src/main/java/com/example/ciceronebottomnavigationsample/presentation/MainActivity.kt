package com.example.ciceronebottomnavigationsample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.ciceronebottomnavigationsample.R
import com.example.ciceronebottomnavigationsample.databinding.ActivityMainBinding
import com.example.ciceronebottomnavigationsample.navigation.Screens
import com.example.ciceronebottomnavigationsample.navigation.NavigationTabTags
import com.example.ciceronebottomnavigationsample.presentation.base.RootFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val currentFragment: Fragment?
        get() = supportFragmentManager.fragments.firstOrNull { it.isVisible }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBottomNavigation()
    }

    override fun onBackPressed() {
        if (currentFragment != null &&
            (currentFragment as? BackPressable)?.onBackPressed() == true
        ) {
            return
        } else {
            super.onBackPressed()
        }
    }

    private fun setUpBottomNavigation() {
        binding.navigationView.apply {
            setOnItemSelectedListener { item ->
                getTabTag(item.itemId)?.let { tag -> selectTab(tag) }
                item.isChecked = true
                false
            }
            setOnItemReselectedListener { (currentFragment as? RootFragment)?.setFirstScreen() }
        }
        selectTab(NavigationTabTags.TAG_A)
    }

    private fun getTabTag(tabId: Int): String? = when (tabId) {
        R.id.menuItemA -> NavigationTabTags.TAG_A
        R.id.menuItemB -> NavigationTabTags.TAG_B
        R.id.menuItemC -> NavigationTabTags.TAG_C
        else -> null
    }

    private fun selectTab(tabTag: String) {
        val newFragment = supportFragmentManager.findFragmentByTag(tabTag)
        if (currentFragment != null && newFragment != null && currentFragment === newFragment) return
        else supportFragmentManager.beginTransaction().apply {
            if (newFragment == null) {
                val rootFragment = createRootFragment(tabTag)
                add(binding.layoutFragmentContainer.id, rootFragment, tabTag)
            }
            currentFragment?.let { hide(it) }
            newFragment?.let { show(it) }
            commitNow()
        }
    }

    private fun createRootFragment(tabTag: String): Fragment {
        val rootScreen = Screens.RootScreen(tabTag)
        return rootScreen.createFragment(supportFragmentManager.fragmentFactory)
    }
}