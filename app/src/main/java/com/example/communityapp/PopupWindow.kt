package com.example.communityapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PopupWindow : BottomSheetDialogFragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_popup_window, container, false)
        val submitButton = view.findViewById<Button>(R.id.btnsub)

        val nameEditText = view.findViewById<TextInputEditText>(R.id.nameEditText)
        val orderNumberEditText = view.findViewById<TextInputEditText>(R.id.orderNumberEditText)
        val pickupLocationEditText = view.findViewById<TextInputEditText>(R.id.pickupLocationEditText)
        val pickupTimeEditText = view.findViewById<TextInputEditText>(R.id.pickupTimeEditText)

        submitButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val orderNumber = orderNumberEditText.text.toString().trim()
            val pickupLocation = pickupLocationEditText.text.toString().trim()
            val pickupTime = pickupTimeEditText.text.toString().trim()

            // Check if any field is empty
            if (name.isEmpty() || orderNumber.isEmpty() || pickupLocation.isEmpty() || pickupTime.isEmpty()) {
                Snackbar.make(view, "Please fill all fields", Snackbar.LENGTH_SHORT).show()
            } else {
                // All fields are filled, proceed with pickup
                Snackbar.make(view, "Pickup done", Snackbar.LENGTH_SHORT).show()
                // Here you can perform any other actions related to pickup
            }
        }

        return view
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PopupWindow().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
