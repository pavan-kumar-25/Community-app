package com.example.communityapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity2 : AppCompatActivity() {
    private val TAG = "MainActivity2"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val submitButton = findViewById<Button>(R.id.buttonSubmit)
        val backButton = findViewById<Button>(R.id.buttonback)
        val requestButton = findViewById<Button>(R.id.buttonRequest)

        submitButton.setOnClickListener {
            val name = findViewById<TextInputEditText>(R.id.editTextName).text.toString()
            val place = findViewById<TextInputEditText>(R.id.editTextPlace).text.toString()
            val foodItem = findViewById<TextInputEditText>(R.id.editTextFoodItem).text.toString()
            val quantity =
                findViewById<TextInputEditText>(R.id.editTextQuantity).text.toString().toIntOrNull()
                    ?: 0

            val intent = Intent()

//            if(Intent.get)

            intent.putExtra("name", name)
            intent.putExtra("place", place)
            intent.putExtra("foodItem", foodItem)
            intent.putExtra("quantity", quantity)
            setResult(RESULT_OK, intent)
            finish()
        }

        backButton.setOnClickListener {
            finish()
        }


        // Move this block outside of the backButton.setOnClickListener
        requestButton.setOnClickListener {
            val intent = Intent(this@MainActivity2, Request::class.java)
            startActivityForResult(intent, REQUEST_CODE_Request)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_Request && resultCode == RESULT_OK) {

            val foodItem = data?.getStringExtra("foodItem") ?: ""
            val quantity = data?.getIntExtra("quantity", 0) ?: 0

            Log.d(TAG, "onActivityResult: $foodItem, $quantity")

            val intent = Intent()
            intent.putExtra("foodItem", foodItem)
            intent.putExtra("quantity", quantity)
            intent.putExtra("type", "request")
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    companion object {
        private const val REQUEST_CODE_Request = 2
    }
}
