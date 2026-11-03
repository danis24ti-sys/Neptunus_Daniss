package com.example.neptunus_daniss

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.neptunus_daniss.databinding.ActivityBaseBinding
import com.example.neptunus_daniss.home.HomeFragment
import com.example.neptunus_daniss.message.MessageFragment
import com.example.neptunus_daniss.more.MoreFragment

class   BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }

        binding.bottomNavView.setOnItemSelectedListener { item ->
            val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
            when (item.itemId) {
                R.id.home -> {
                    if (currentFragment !is HomeFragment) replaceFragment(HomeFragment())
                }
                R.id.message -> {
                    if (currentFragment !is MessageFragment) replaceFragment(MessageFragment())
                }
                R.id.more -> {
                    if (currentFragment !is MoreFragment) replaceFragment(MoreFragment())
                }
                else -> return@setOnItemSelectedListener false
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
