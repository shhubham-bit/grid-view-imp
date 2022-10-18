package com.trainee.appinventiv.gridtask1.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trainee.appinventiv.gridtask1.R
import com.trainee.appinventiv.gridtask1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}