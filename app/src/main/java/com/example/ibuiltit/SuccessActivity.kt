package com.example.ibuiltit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.ibuiltit.databinding.ActivitySuccessBinding

class SuccessActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener {
            val intent = Intent(this, DonationActivity::class.java)
            startActivity(intent)
        }
        var button4: Button = findViewById(R.id.button4)
        button4.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_success)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}