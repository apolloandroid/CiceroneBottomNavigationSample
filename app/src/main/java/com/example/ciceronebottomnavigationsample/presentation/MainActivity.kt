package com.example.ciceronebottomnavigationsample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ciceronebottomnavigationsample.R
import com.example.ciceronebottomnavigationsample.databinding.ActivityMainBinding
import com.example.ciceronebottomnavigationsample.navigation.Screens
import com.example.ciceronebottomnavigationsample.navigation.TabTags
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpNavigation()
    }

    //    TODO: implement
    override fun onBackPressed() {
//        var fragment: Fragment? = null
//        for (f in supportFragmentManager.fragments) {
//            if (f.isVisible) {
//                fragment = f
//                break
//            }
//        }
//        if (fragment != null && fragment is BackButtonListener
//            && (fragment as BackButtonListener).onBackPressed()) {
//            return
//        } else {
//            presenter.onBackPressed()
//        }
    }

    private fun setUpNavigation() {
        binding.navigationView.apply {
            setOnItemSelectedListener { item ->
                getTabTag(item.itemId)?.let { tag -> selectTab(tag) }
                item.isChecked = true
                false
            }
        }
        selectTab(TabTags.TAG_A)
    }

    private fun getTabTag(tabId: Int): String? = when (tabId) {
        R.id.menuItemA -> TabTags.TAG_A
        R.id.menuItemB -> TabTags.TAG_B
        R.id.menuItemC -> TabTags.TAG_C
        else -> null
    }

    private fun selectTab(tabTag: String) {
        val currentFragment = supportFragmentManager.fragments.firstOrNull { it.isVisible }
        val newFragment = supportFragmentManager.findFragmentByTag(tabTag)
        if (currentFragment != null && newFragment != null && currentFragment === newFragment) return
        supportFragmentManager.beginTransaction().apply {
            if (newFragment == null) {
                val rootScreen = Screens.RootScreen(tabTag)
                add(
                    R.id.layoutFragmentContainer,
                    rootScreen.createFragment(supportFragmentManager.fragmentFactory),
                    tabTag
                )
            }
            currentFragment?.let { hide(it) }
            newFragment?.let { show(it) }
            commitNow()
        }
    }
}