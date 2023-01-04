package com.example.ciceronebottomnavigationsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ciceronebottomnavigationsample.databinding.ActivityMainBinding
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

    private fun setUpNavigation() {
        binding.navigationView.apply {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menuItemA -> selectTab("A")
                    R.id.menuItemB -> selectTab("B")
                    R.id.menuItemC -> selectTab("C")
                }
                false
            }

            setOnItemReselectedListener { item ->
                when (item.itemId) {
                    R.id.menuItemA -> selectTab("A")
                    R.id.menuItemB -> selectTab("B")
                    R.id.menuItemC -> selectTab("C")
                }
            }
        }
    }

    private fun selectTab(title: String) {

    }
}

