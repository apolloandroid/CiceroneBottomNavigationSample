package com.example.ciceronebottomnavigationsample.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.ciceronebottomnavigationsample.R
import com.example.ciceronebottomnavigationsample.databinding.ActivityMainBinding
import com.example.ciceronebottomnavigationsample.navigation.Screens
import com.example.ciceronebottomnavigationsample.navigation.NavigationTabTags
import com.example.ciceronebottomnavigationsample.presentation.BackPressable
import com.example.ciceronebottomnavigationsample.presentation.base.RootFragment
import com.example.ciceronebottomnavigationsample.presentation.collectOnLifecycle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private val currentFragment: Fragment?
        get() = supportFragmentManager.fragments.firstOrNull { it.isVisible }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBottomNavigation()
        subscribeOnViewModel()
    }

    override fun onBackPressed() {
        val currentFragmentBackPressedResult = (currentFragment as? BackPressable)?.onBackPressed()
        when {
            currentFragmentBackPressedResult == true -> return
            currentFragment?.tag == NavigationTabTags.TAG_A -> super.onBackPressed()
            else -> selectTab(NavigationTabTags.TAG_A)
        }
    }

    private fun setUpBottomNavigation() = binding.navigationView.apply {
        setOnItemSelectedListener { item ->
            getTabTag(item.itemId)?.let { tag -> selectTab(tag) }
            true
        }
        setOnItemReselectedListener { (currentFragment as? RootFragment)?.setFirstScreen() }
        selectedItemId = R.id.menuItemA
        this@MainActivity.selectTab(NavigationTabTags.TAG_A)
    }

    private fun subscribeOnViewModel() = collectOnLifecycle(viewModel.isAuthenticated) {
        binding.navigationView.menu.apply {
            findItem(R.id.menuItemD).isVisible = it
            if (!it) {
                binding.navigationView.selectedItemId = R.id.menuItemA
                deleteTab(NavigationTabTags.TAG_D)
                this@MainActivity.selectTab(NavigationTabTags.TAG_A)
            }
        }
    }

    private fun selectTab(tabTag: String) {
        val oldFragment = currentFragment
        val newFragment = supportFragmentManager.findFragmentByTag(tabTag)
        if (oldFragment != null && newFragment != null && oldFragment === newFragment) return
        else supportFragmentManager.beginTransaction().apply {
            if (newFragment == null) {
                val rootFragment = createRootFragment(tabTag)
                add(binding.layoutFragmentContainer.id, rootFragment, tabTag)
            }
            oldFragment?.let { hide(it) }
            newFragment?.let { show(it) }
        }.commitNow()
    }

    private fun getTabTag(tabId: Int): String? = when (tabId) {
        R.id.menuItemA -> NavigationTabTags.TAG_A
        R.id.menuItemB -> NavigationTabTags.TAG_B
        R.id.menuItemC -> NavigationTabTags.TAG_C
        R.id.menuItemD -> NavigationTabTags.TAG_D
        else -> null
    }

    private fun createRootFragment(tabTag: String): Fragment {
        val rootScreen = Screens.RootScreen(tabTag)
        return rootScreen.createFragment(supportFragmentManager.fragmentFactory)
    }

    private fun deleteTab(tabTag: String) = with(supportFragmentManager) {
        fragments.remove(findFragmentByTag(tabTag))
    }
}