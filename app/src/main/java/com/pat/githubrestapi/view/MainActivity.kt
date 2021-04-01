package com.pat.githubrestapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pat.githubrestapi.GitHubInterfaceImpl
import com.pat.githubrestapi.R
import com.pat.githubrestapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}