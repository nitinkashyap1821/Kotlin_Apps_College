package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var logIn: Button
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        username = findViewById(R.id.editTextUsername)
        password = findViewById(R.id.editTextPassword)
        logIn = findViewById(R.id.btnLogIn)

        val bundle = intent.extras

        val name = bundle?.getString("username")
        val pwd = bundle?.getString("password")


        logIn.setOnClickListener {
            print("$name,$pwd")
            if (name == username.text.toString() && pwd == password.text.toString()){
                val intent = Intent(this,HomeActivity::class.java)
                startActivity(intent)
            }else{
                count++
                if(count>=3){
                    logIn.isEnabled = false
                }
            }
        }
    }
}