/*
 * Course Code: MAD302
 * Assignment Number: 2
 * Name: Jennyfer Rajubhai Parmar
 * Student ID: A00201240
 * Date of Submission: 2026-04-21
 *
 * Description:
 * This activity receives product data from MainActivity using Intent
 * and displays the product's name, price, and description.
 */

package com.example.assignment_2nevinjames

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment_2nevinjames.databinding.DetailActivityBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: DetailActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DetailActivityBinding.inflate(layoutInflater) // initialize binding
        setContentView(binding.root) // set layout

        displayData() // call method to display data
    }

    private fun displayData() {
        val productName = intent.getStringExtra("name") // get product name
        val productPrice = intent.getDoubleExtra("price", 0.0) // get product price
        val productDesc = intent.getStringExtra("description") // get product description

        // validation before setting values
        binding.productNameTextView.text = productName?.ifEmpty { "N/A" } ?: "N/A"
        binding.productPriceTextView.text = "$%.2f".format(if (productPrice >= 0) productPrice else 0.0)
        binding.productDescriptionTextView.text = productDesc?.ifEmpty { "No description" } ?: "No description"
    }
}