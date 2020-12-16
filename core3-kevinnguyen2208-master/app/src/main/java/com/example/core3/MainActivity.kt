package com.example.core3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private val locations: MutableList<Data> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val main = findViewById<RecyclerView>(R.id.main)
        main.adapter = Adapter(locations)

        linearLayoutManager = LinearLayoutManager(this)
        main.layoutManager = linearLayoutManager
        main.setHasFixedSize(true)
        main.setItemViewCacheSize(100)
        registerForContextMenu(main)

        readFile()
    }

    fun readFile() {
        val read = resources.openRawResource(R.raw.au_locations).bufferedReader()
       read.forEachLine {
           val lineValues = it.split(",").toTypedArray()
           val suburb: String = lineValues[0]
           val latitude: Float = lineValues[1].toFloat()
           val longitude: Float = lineValues[2].toFloat()
           val city: String = lineValues[3]
           val location = Data(suburb, latitude, longitude, city)
           locations.add(location)
       }
    }
}