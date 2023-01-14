package com.example.ciceronebottomnavigationsample.presentation.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.ciceronebottomnavigationsample.presentation.BackPressable
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.androidx.AppNavigator

abstract class RootFragment : Fragment(), BackPressable {

    protected abstract val viewModel: RootViewModel
    protected abstract val fragmentContainerId: Int

    open val navigator: Navigator by lazy {
        AppNavigator(requireActivity(), fragmentContainerId, childFragmentManager)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (childFragmentManager.findFragmentById(fragmentContainerId) == null) {
            viewModel.setFirstScreen()
        }
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
        val fragment = childFragmentManager.findFragmentById(fragmentContainerId)
        return fragment != null &&
                (fragment as? BackPressable)?.onBackPressed() == true
    }
}