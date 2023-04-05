package uz.devapp.elonuz.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.devapp.elonuz.R
import uz.devapp.elonuz.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

        }
    }
}