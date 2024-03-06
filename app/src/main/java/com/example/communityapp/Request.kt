package com.example.communityapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class Request : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request)

        val requestButton: Button = findViewById(R.id.buttonRequest)
        requestButton.setOnClickListener {

            val foodItem = findViewById<TextInputEditText>(R.id.editTextFoodItem)
            val quantity = findViewById<TextInputEditText>(R.id.editTextQuantity)

            val intent = Intent()
            intent.putExtra("foodItem", foodItem.text.toString())
            intent.putExtra("quantity", quantity.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
