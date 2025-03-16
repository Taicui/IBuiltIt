package com.example.ibuiltit

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BuildActivity : AppCompatActivity() {

    private lateinit var rvInventory: RecyclerView
    private lateinit var tvPage: TextView
    private var page = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_build)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        rvInventory = findViewById(R.id.rvInventory)
        tvPage = findViewById(R.id.tvPage);
        rvInventory.adapter = InventoryAdapter(this, 8)
        rvInventory.setHasFixedSize(true);
        rvInventory.layoutManager = GridLayoutManager (this, 2)

        var buttonN: Button = findViewById(R.id.buttonN)
        buttonN.setOnClickListener {
            page++
            tvPage.setText("Page: "+page.toString())
        }
        var buttonP: Button = findViewById(R.id.buttonP)
        buttonP.setOnClickListener {
            if(page>1) {
                page--
                tvPage.setText("Page: "+page.toString())
            }
        }






    }
}