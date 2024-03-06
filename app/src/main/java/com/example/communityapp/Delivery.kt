package com.example.communityapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Delivery : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_delivery)

        findViewById<Button>(R.id.pickup).setOnClickListener {
            val bottomSheetFragment = Fragment()
            bottomSheetFragment.show(supportFragmentManager, "BottomSheetFragment")
        }
    }
}