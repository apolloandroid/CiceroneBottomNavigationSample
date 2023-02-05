# CiceroneBottomNavigationSample

The application is an example of implementing in-app navigation with [BottomNavigationView](https://developer.android.com/reference/com/google/android/material/bottomnavigation/BottomNavigationView) using [Cicerone library](https://github.com/terrakok/Cicerone).

## Features
  * Keeping the fragments backstack inside each navigation tab when switching to other tabs and returning back, as well as when minimizing the application.
  
    ![Common](https://user-images.githubusercontent.com/62345510/216829561-e9633c8b-1eb6-472c-a7c0-b09250b31bd7.gif)
  * Implementation of the system back button following popular applications (YouTube, HeadHunter, etc.) according to the following algorithm:
    * Opened a fragment that is not the first within the tab. Pressing the back button returns to the previous fragment within this tab.
    * Opened the first fragment within a tab that is not the first. Pressing the back button returns to the first tab.
    * Opened the first fragment within the first tab. Pressing the back button closes the application.
    
    ![Back pressing](https://user-images.githubusercontent.com/62345510/216829589-28374ad7-ccba-4b5f-a138-c5b3906fbe0a.gif)
  * Reselecting a tab opens the first fragment within that tab.
  
    ![Reselecting](https://user-images.githubusercontent.com/62345510/216829598-e19a02f1-3121-49b3-b8fc-580d6983d3fe.gif)
  * Adding and removing a tab after a specific action. For example, after user login/logout.
  
    ![Adding tab](https://user-images.githubusercontent.com/62345510/216829606-2fa41522-ab54-4bc7-9ff8-1a71276aedb8.gif)

## Technologies
  * Kotlin
  * MVVM
  * Cicerone
  * Hilt
  * DataStore

---  
Feel free to write me about any bugs if you find them.

Inspired by [official Cicerone sample](https://github.com/terrakok/Cicerone/tree/master/sample).
