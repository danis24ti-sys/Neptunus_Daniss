package com.example.neptunus_daniss.home.pertemuan_6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.neptunus_daniss.R
import com.example.neptunus_daniss.databinding.ActivitySixthBinding

class SixthActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySixthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySixthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = getString(R.string.sixth_activity_title)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }

        if (savedInstanceState == null) {
            replaceFragment(SatuFragment())
        }

        binding.btnFragment1.setOnClickListener { replaceFragment(SatuFragment()) }
        binding.btnFragment2.setOnClickListener { replaceFragment(DuaFragment()) }
        binding.btnFragment3.setOnClickListener { replaceFragment(TigaFragment()) }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
