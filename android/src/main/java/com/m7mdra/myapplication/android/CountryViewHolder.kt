package com.m7mdra.myapplication.android

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class CountryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val nameTextView = view.findViewById<TextView>(R.id.nameTextView)
    val nativeNameText = view.findViewById<TextView>(R.id.nativeNameTextView)
    val flagImageView = view.findViewById<ShapeableImageView>(R.id.flagImageView)
}