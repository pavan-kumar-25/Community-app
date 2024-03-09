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

        val pickupButton = findViewById<Button>(R.id.pickup)
        pickupButton.setOnClickListener {
            val fragment = PopupWindow.newInstance("param1", "param2")
            fragment.show(supportFragmentManager, fragment.tag)
        }

    }
}