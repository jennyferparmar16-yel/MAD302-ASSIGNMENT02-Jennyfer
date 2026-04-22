/*
 * Course Code: MAD302
 * Assignment Number: 2
 * Name: Jennyfer Rajubhai Parmar
 * Student ID: A00201240
 * Date of Submission: 2026-04-21
 *
 * Description:
 * RecyclerView adapter that displays product list and handles item clicks.
 */

package com.example.assignment_2nevinjames

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    private val items: List<Product>, // list of products
    private val onClick: (Product) -> Unit // click listener
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(android.R.id.text1) // default text view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false) // inflate layout
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = items[position] // get product

        // validation before displaying
        holder.textView.text = product.name.ifEmpty { "Unnamed Product" }

        holder.itemView.setOnClickListener {
            onClick(product) // trigger click
        }
    }

    override fun getItemCount(): Int = items.size // return list size
}