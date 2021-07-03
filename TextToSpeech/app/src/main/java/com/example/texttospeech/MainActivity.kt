package com.example.texttospeech

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mTTS: TextToSpeech
    private lateinit var mEditText: EditText
    private lateinit var mButtonSpeak: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mButtonSpeak = findViewById(R.id.button_speak)
        mEditText = findViewById(R.id.edit_text)

        mTTS = TextToSpeech(this, OnInitListener { status ->
            if (status == TextToSpeech.SUCCESS) {
                val result = mTTS.setLanguage(Locale.US)
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Toast.makeText(this@MainActivity, "Language Not Supported", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(this@MainActivity, "Initialization Failed", Toast.LENGTH_SHORT)
                    .show()
            }

        })
        mButtonSpeak.setOnClickListener {
            val text = mEditText.text.toString()
            mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null)
        }
    }
    override fun onDestroy() {
        mTTS.stop()
        mTTS.shutdown()
        super.onDestroy()
    }


}