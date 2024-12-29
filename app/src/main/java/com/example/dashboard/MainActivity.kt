package com.example.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var items: ArrayList<ContactDomain>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the ArrayList with some sample data
        items = arrayListOf(
            ContactDomain("David", "user_1"),
            ContactDomain("Maria", "user_2"),
            ContactDomain("John", "user_3"),
            ContactDomain("Sara", "user_4"),
            ContactDomain("Rose", "user_5"),
        )

        // Initialize RecyclerView
        initRecyclerView()
    }

    private fun initRecyclerView() {
        // Find RecyclerView by ID
        recyclerView = findViewById(R.id.recyclerView)

        // Set layout manager for horizontal orientation
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Initialize the adapter with the items list
        contactAdapter = ContactAdapter(items)

        // Set adapter to RecyclerView
        recyclerView.adapter = contactAdapter
    }

}
