package com.example.communityapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var listViewRequests: ListView
    private lateinit var adapterRequests: ArrayAdapter<String>
    private lateinit var listViewFulfilled: ListView
    private lateinit var adapterFulfilled: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize ListView for user requests
        listViewRequests = findViewById(R.id.list_view_requests)
        val requestItemList = mutableListOf<String>()
        adapterRequests = ArrayAdapter(this, android.R.layout.simple_list_item_1, requestItemList)
        listViewRequests.adapter = adapterRequests

        // Initialize ListView for fulfilled requests
        listViewFulfilled = findViewById(R.id.list_view) // Corrected id here
        val fulfilledItemList = mutableListOf<String>()
        adapterFulfilled =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, fulfilledItemList)
        listViewFulfilled.adapter = adapterFulfilled

        val floatingButton: FloatingActionButton = findViewById(R.id.floating_button)
        floatingButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivityForResult(intent, REQUEST_CODE_MAIN_ACTIVITY_2)
        }

        val btnGoToDelivery: Button = findViewById(R.id.button)
        btnGoToDelivery.setOnClickListener {
            val intent = Intent(this, Delivery::class.java)
            startActivity(intent)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_MAIN_ACTIVITY_2 && resultCode == RESULT_OK) {

            if (data?.getStringExtra("type").equals("request")) {

                val foodItem = data?.getStringExtra("foodItem") ?: ""
                val quantity = data?.getIntExtra("quantity", 0) ?: 0

                val item = "$foodItem - $quantity" // Customize the format as needed
                adapterRequests.add(item)
                adapterRequests.notifyDataSetChanged()
            } else {
                val name = data?.getStringExtra("name") ?: ""
                val place = data?.getStringExtra("place") ?: ""
                val foodItem = data?.getStringExtra("foodItem") ?: ""
                val quantity = data?.getIntExtra("quantity", 0) ?: 0

                val item =
                    "$name - $place - $foodItem - $quantity" // Customize the format as needed
                adapterFulfilled.add(item)
                adapterFulfilled.notifyDataSetChanged()
            }

        }
    }

    fun addItemToRequestList(foodItem: String, quantity: Int) {
        val item = " $foodItem - $quantity"
        adapterRequests.add(item)
        adapterRequests.notifyDataSetChanged()
    }



    // Method to add fulfilled item to the ListView
    fun addItemToFulfilledList(name: String, place: String, foodItem: String, quantity: Int) {
        val item = "$name - $place - $foodItem - $quantity"
        adapterFulfilled.add(item)
        adapterFulfilled.notifyDataSetChanged()
    }

    companion object {
        private const val REQUEST_CODE_MAIN_ACTIVITY_2 = 1
    }
}

