package kg.geekstudio.kitsutest

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.geekstudio.kitsutest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}