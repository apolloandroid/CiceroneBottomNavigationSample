package com.example.ciceronebottomnavigationsample.presentation

/**
 * Implement this interface in your UI component ([Fragment] or [Activity])
 * for processing system back button.
 */
interface BackPressable {
    /**
     * @return true - the UI component handled the back button pressing itself.
     * The parent component (activity or parent fragment) does not require a supermethod call
     *
     * @return false - the UI component delegates the reverse processing to a higher component
     * */
    fun onBackPressed(): Boolean
}