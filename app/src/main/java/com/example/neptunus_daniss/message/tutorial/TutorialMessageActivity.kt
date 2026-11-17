package com.example.neptunus_daniss.message.tutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.neptunus_daniss.databinding.ActivityTutorialMessageBinding

class TutorialMessageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTutorialMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentsList = listOf(
            Tutorial1Fragment(),
            Tutorial2Fragment(),
            Tutorial3Fragment()
        )
        binding.tutorialMessageViewPager.adapter =
            TutorialFragmentAdapter(this, fragmentsList)
        binding.dotIndicator.attachTo(binding.tutorialMessageViewPager)
    }
}
