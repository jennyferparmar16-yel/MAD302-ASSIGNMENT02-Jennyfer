/*
 * Course Code: MAD302
 * Assignment Number: 2
 * Name: Jennyfer Rajubhai Parmar
 * Student ID: A00201240
 * Date of Submission: 2026-04-21
 *
 * Description:
 * Data class representing a product with name, price, and description.
 */

package com.example.assignment_2nevinjames

data class Product(
    val name: String, // product name (should not be empty)
    val price: Double, // product price (should be >= 0)
    val description: String // product description
)