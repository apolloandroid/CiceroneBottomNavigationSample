package com.example.ciceronebottomnavigationsample.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.ciceronebottomnavigationsample.R
import com.example.ciceronebottomnavigationsample.databinding.ActivityMainBinding
import com.example.ciceronebottomnavigationsample.navigation.Screens
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

    override fun onBackPressed() {
        var fragment: Fragment? = null
        for (f in supportFragmentManager.fragments) {
            if (f.isVisible) {
                fragment = f
                break
            }
        }
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
                selectTab(item.itemId.toString())
                item.isChecked = true
                false
            }

            setOnItemReselectedListener { item ->
                selectTab(item.itemId.toString())
            }
        }
    }

    private fun selectTab(tabId: String) {
        val fragmentManager = supportFragmentManager
        var currentFragment: Fragment? = null
        for (fragment in fragmentManager.fragments) {
            if (fragment.isVisible) {
                currentFragment = fragment
                break
            }
        }
        val newFragment = fragmentManager.findFragmentByTag(tabId)
        if (currentFragment != null && newFragment != null && currentFragment === newFragment) return
        fragmentManager.beginTransaction().apply {
            if (newFragment == null) {
                add(
                    R.id.layoutFragmentContainer,
                    Screens.RootScreen(tabId).createFragment(fragmentManager.fragmentFactory), tabId
                )
            }
            currentFragment?.let { hide(it) }
            newFragment?.let { show(newFragment) }
            commitNow()
        }
    }
}