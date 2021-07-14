package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Matcher
import java.util.regex.Pattern


class SignUpActivity : AppCompatActivity() {

    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var signUp: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()

        username = findViewById(R.id.editTextUsername)
        password = findViewById(R.id.editTextPassword)
        signUp = findViewById(R.id.btnSignUp)

        signUp.setOnClickListener {


            if (isValidPassword(password.text.toString())) {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                val bundle = Bundle()
                bundle.putString("username", username.text.toString()) //key,value pair
                bundle.putString("password", password.text.toString())
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid!", Toast.LENGTH_SHORT).show()

            }
        }


    }//onCreate

    private fun isValidPassword(password: String?): Boolean {

        val pwdPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}\$"
        val pattern: Pattern = Pattern.compile(pwdPattern)
        val matcher: Matcher = pattern.matcher(password!!)
        return matcher.matches()


    }
}//SignUpActivity
