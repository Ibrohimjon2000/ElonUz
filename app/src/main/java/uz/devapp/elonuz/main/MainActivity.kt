package uz.devapp.elonuz.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import uz.devapp.elonuz.auth.LoginActivity
import uz.devapp.elonuz.databinding.ActivityMainBinding
import uz.devapp.elonuz.main.add_ad.AddAdsActivity
import uz.devapp.elonuz.utils.PrefUtils

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = binding.fragmentContainerView.getFragment<NavHostFragment>()
        binding.bottomNavView.setupWithNavController(navHostFragment.navController)
    }
}