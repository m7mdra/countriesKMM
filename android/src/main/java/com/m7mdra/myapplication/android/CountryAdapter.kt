package com.m7mdra.myapplication.android

import android.content.Context
import android.graphics.drawable.PictureDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestBuilder
import com.github.twocoffeesoneteam.glidetovectoryou.GlideApp
import com.m7mdra.myapplication.network.model.Country


class CountryAdapter(
    private val context: Context,
    private val list: List<Country>,
    private val onClick: (Country) -> Unit = {}
) :
    RecyclerView.Adapter<CountryViewHolder>() {
    private val requestBuilder: RequestBuilder<PictureDrawable> by lazy{
        GlideApp.with(context)
            .`as`(PictureDrawable::class.java)
            .listener(SvgSoftwareLayerSetter())

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_country, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = list[position]
        requestBuilder.load(country.flag).into(holder.flagImageView);

        holder.nameTextView.text = country.name
        holder.nativeNameText.text = country.nativeName
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
