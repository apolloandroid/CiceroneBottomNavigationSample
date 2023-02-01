package com.example.ciceronebottomnavigationsample.presentation.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.androidx.AppNavigator

/**
 * Base class for root fragment, which holds fragment back stack for each navigation tab
 */

abstract class RootFragment : Fragment(), BackPressable {

    protected abstract val viewModel: RootViewModel
    protected abstract val fragmentContainerId: Int

    protected val currentChildFragment: Fragment?
        get() = childFragmentManager.findFragmentById(fragmentContainerId)

    protected open val navigator: Navigator by lazy {
        AppNavigator(requireActivity(), fragmentContainerId, childFragmentManager)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (currentChildFragment == null) setFirstScreen()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume(navigator)
    }

    override fun onPause() {
        viewModel.onPause()
        super.onPause()
    }

    override fun onBackPressed(): Boolean {
        return currentChildFragment != null &&
                (currentChildFragment as? BackPressable)?.onBackPressed() == true
    }

    fun setFirstScreen() = viewModel.setFirstScreen()
}