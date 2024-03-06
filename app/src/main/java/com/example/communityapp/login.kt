package com.example.communityapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val btn = findViewById<Button>(R.id.btn)

        btn.setOnClickListener { view: View ->
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username and password cannot be empty", Toast.LENGTH_SHORT).show()
            } else if (username != "a" || password != "1") {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            } else {
                val next = Intent(this, MainActivity::class.java)
                startActivity(next)
            }
        }
    }
}