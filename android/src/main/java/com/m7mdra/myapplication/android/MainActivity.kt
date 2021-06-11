package com.m7mdra.myapplication.android

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.m7mdra.myapplication.network.CountryApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private val mainScope = MainScope()
    private val countryApi by lazy {
        CountryApi()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        mainScope.launch {
            tv.text = "Loading..."
            kotlin.runCatching {
                countryApi.getAll()
            }.onSuccess {
                tv.text = "Loaded data of ${it.size} countries"

                Log.d("MEGA", "onCreate: got ${it.size} countries")
            }.onFailure {
                tv.text = "error"

            }
        }

    }
}
