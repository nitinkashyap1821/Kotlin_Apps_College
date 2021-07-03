package com.example.counter

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var counterValue: TextView
    private lateinit var startCounter: Button
    private lateinit var stopCounter: Button
    private lateinit var resetCounter: Button

    private val timer = MyCounter(10000000, 1000)
    var countervalue: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterValue = findViewById(R.id.counter_value)
        startCounter = findViewById(R.id.start_counter)
        stopCounter = findViewById(R.id.stop_counter)
        resetCounter = findViewById(R.id.reset_counter)


        startCounter.setOnClickListener {
            timer.start()
            startCounter.isEnabled = false
        }

        stopCounter.setOnClickListener {
            timer.cancel()
            startCounter.isEnabled = true
        }
        resetCounter.setOnClickListener {
            countervalue = 0
            counterValue.text = (countervalue).toString()
        }

    }

    inner class MyCounter(millisInFuture: Long, countDownInterval: Long) :
        CountDownTimer(millisInFuture, countDownInterval) {
        override fun onFinish() {}

        override fun onTick(millisUntilFinished: Long) {
            countervalue++
            counterValue.text = (countervalue).toString()


        }


    }

}