# CiceroneBottomNavigationSample

The application is an example of implementing in-app navigation with [BottomNavigationView](https://developer.android.com/reference/com/google/android/material/bottomnavigation/BottomNavigationView) using [Cicerone library](https://github.com/terrakok/Cicerone).

## Features
  * Keeping the fragments backstack inside each navigation tab when switching to other tabs and returning back, as well as when minimizing the application.
  * Implementation of the system back button following popular applications (YouTube, HeadHunter, etc.) according to the following algorithm:
    * Opened a fragment that is not the first within the tab. Pressing the back button returns to the previous fragment within this tab.
    * Opened the first fragment within a tab that is not the first. Pressing the back button returns to the first tab.
    * Opened the first fragment within the first tab. Pressing the back button closes the application.
  * Reselecting a tab opens the first fragment within that tab.
  * Adding and removing a tab after a specific action. For example, after user login/logout.

## Technologies
  * Kotlin
  * MVVM
  * Cicerone
  * Hilt
  * DataStore

---  
Inspired by [official Cicerone sample](https://github.com/terrakok/Cicerone/tree/master/sample).
