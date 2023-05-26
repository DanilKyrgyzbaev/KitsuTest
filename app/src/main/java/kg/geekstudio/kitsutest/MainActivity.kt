package kg.geekstudio.kitsutest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import kg.geekstudio.kitsutest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment).navController
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListener()
    }
    private fun setupListener() {
        val graph = navController.navInflater.inflate(R.navigation.nav_graph)
        graph.setStartDestination(R.id.homeFragment)

        navController.graph = graph
    }
}