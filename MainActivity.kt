/*
 * Course Code: MAD302
 * Assignment Number: 2
 * Name: Jennyfer Rajubhai Parmar
 * Student ID: A00201240
 * Date of Submission: 2026-04-21
 *
 * Description:
 * This activity displays a list of products using a RecyclerView.
 * When a user selects a product, the app navigates to DetailActivity
 * and passes the selected product data using Intent.
 */

package com.example.assignment_2nevinjames

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment_2nevinjames.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater) // initialize binding
        setContentView(binding.root) // set layout

        val productList = listOf(
            Product("Matte Lipstick", 24.99, "Long-lasting matte finish lipstick"),
            Product("Liquid Foundation", 39.99, "Full coverage liquid foundation"),
            Product("Face Serum", 29.99, "Hydrating vitamin C serum"),
            Product("Mascara", 19.99, "Waterproof volumizing mascara"),
            Product("Blush Palette", 34.99, "Natural glow blush shades"),
            Product("Sunscreen SPF 50", 21.99, "Protects skin from harmful UV rays")
        )

        if (productList.isEmpty()) return // basic validation

        binding.recyclerProducts.layoutManager = LinearLayoutManager(this) // set layout manager

        binding.recyclerProducts.adapter = ProductAdapter(productList) { item -> // set adapter
            val intent = Intent(this, DetailActivity::class.java) // create intent

            intent.putExtra("name", item.name.ifEmpty { "N/A" }) // send name
            intent.putExtra("price", if (item.price >= 0) item.price else 0.0) // send price
            intent.putExtra("description", item.description.ifEmpty { "No description" }) // send description

            startActivity(intent) // navigate
        }
    }
}