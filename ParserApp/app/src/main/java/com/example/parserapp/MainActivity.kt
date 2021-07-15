package com.example.parserapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.io.IOException
import javax.xml.parsers.DocumentBuilderFactory

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val parseJson: Button = findViewById(R.id.btnParseJson)
        val parseXml: Button = findViewById(R.id.btnParseXml)
        val dataType: TextView = findViewById(R.id.data_type)
        val city: TextView = findViewById(R.id.city_name)
        val latitude: TextView = findViewById(R.id.latitude)
        val longitude: TextView = findViewById(R.id.longitude)
        val temp: TextView = findViewById(R.id.temperature)
        val humidity: TextView = findViewById(R.id.humidity)

        parseJson.setOnClickListener {
            dataType.text = "Data Type : Json"
            val obj = JSONObject(readJSon()!!)
            city.text = "City Name : ${obj.getString("City Name")}"
            latitude.text = "City Name : ${obj.getString("Latitude")}"
            longitude.text = "City Name : ${obj.getString("Longitude")}"
            temp.text = "City Name : ${obj.getString("Temperature")}"
            humidity.text = "City Name : ${obj.getString("Humidity")}"

        }

        parseXml.setOnClickListener {
            dataType.text = "Data Type : XML"
            try {
                val iStream = assets.open("xmlData.xml")
                val builderFactory = DocumentBuilderFactory.newInstance()
                val docBuilder = builderFactory.newDocumentBuilder()
                val doc = docBuilder.parse(iStream)
                city.text = "City Name : " + doc.getElementsByTagName("City_Name").item(0).firstChild.nodeValue
                latitude.text = "Latitude : " + doc.getElementsByTagName("Latitude").item(0).firstChild.nodeValue
                longitude.text = "Longitude : " + doc.getElementsByTagName("Longitude").item(0).firstChild.nodeValue
                temp.text = "Temperature : " + doc.getElementsByTagName("Temperature").item(0).firstChild.nodeValue
                humidity.text = "Humidity : " + doc.getElementsByTagName("Humidity").item(0).firstChild.nodeValue
            }
            catch (ex: IOException) {

            }
        }

    }

    private fun readJSon(): String? {
        val json: String
        try {
            val inputStream = assets.open("jsonData.json")
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            return null
        }
        return json
    }
}