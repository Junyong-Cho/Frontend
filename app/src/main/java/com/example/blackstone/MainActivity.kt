package com.example.blackstone

import HealthFragment
import HomeFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.blackstone.databinding.ActivityMainBinding
import com.example.blackstone.health.MotionCaptureFragment
import com.example.blackstone.ranking.RankingFragment
import com.example.blackstone.shopping.ShoppingFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        selectTab(R.id.menu_home)
        binding.bottomNavigationView.setOnItemSelectedListener {
            selectTab(it.itemId)
            true
        }
    }

    private fun selectTab(menuId: Int) {
        val fragment = when (menuId) {
            R.id.menu_home -> HomeFragment()
            R.id.menu_health -> HealthFragment()
            R.id.menu_ranking -> RankingFragment()
            R.id.menu_shopping -> MotionCaptureFragment()
            else -> HomeFragment()
        }

        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainerView.id, fragment)
            .commit()
    }
}