package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var zero: TextView
    private lateinit var one: TextView
    private lateinit var two: TextView
    private lateinit var three: TextView
    private lateinit var four: TextView
    private lateinit var five: TextView
    private lateinit var six: TextView
    private lateinit var seven: TextView
    private lateinit var eight: TextView
    private lateinit var nine: TextView
    private lateinit var dot: TextView
    private lateinit var addition: TextView
    private lateinit var subtraction: TextView
    private lateinit var multiplication: TextView
    private lateinit var division: TextView
    private lateinit var mod: TextView
    private lateinit var equals: TextView
    private lateinit var clear: TextView
    private lateinit var del: TextView
    private lateinit var result: TextView
    private lateinit var expression: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zero = findViewById(R.id.tvZero)
        one = findViewById(R.id.tvOne)
        two = findViewById(R.id.tvTwo)
        three = findViewById(R.id.tvThree)
        four = findViewById(R.id.tvFour)
        five = findViewById(R.id.tvFive)
        six = findViewById(R.id.tvSix)
        seven = findViewById(R.id.tvSeven)
        eight = findViewById(R.id.tvEight)
        nine = findViewById(R.id.tvNine)
        dot = findViewById(R.id.tvDot)

        clear = findViewById(R.id.tvClear)
        del = findViewById(R.id.tvDel)

        addition = findViewById(R.id.tvPlus)
        subtraction = findViewById(R.id.tvMinus)
        division = findViewById(R.id.tvDiv)
        multiplication = findViewById(R.id.tvMul)
        mod = findViewById(R.id.tvMod)
        equals = findViewById(R.id.tvEqual)


        result = findViewById(R.id.tvResult)
        expression = findViewById(R.id.tvExpression)

        zero.setOnClickListener {
            pressButton("0", true)
        }

        one.setOnClickListener {
            pressButton("1", true)
        }

        two.setOnClickListener {
            pressButton("2", true)
        }

        three.setOnClickListener {
            pressButton("3", true)
        }

        four.setOnClickListener {
            pressButton("4", true)
        }

        five.setOnClickListener {
            pressButton("5", true)
        }

        six.setOnClickListener {
            pressButton("6", true)
        }

        seven.setOnClickListener {
            pressButton("7", true)
        }

        eight.setOnClickListener {
            pressButton("8", true)
        }

        nine.setOnClickListener {
            pressButton("9", true)
        }

        dot.setOnClickListener {
            pressButton(".", true)
        }

        addition.setOnClickListener {
            pressButton("+", false)
        }

        subtraction.setOnClickListener {
            pressButton("-", false)
        }

        multiplication.setOnClickListener {
            pressButton("*", false)
        }

        division.setOnClickListener {
            pressButton("/", false)
        }

        mod.setOnClickListener {
            pressButton("%", false)
        }

        clear.setOnClickListener {
            result.text = ""
            expression.text = ""
        }
        del.setOnClickListener {
            val string = expression.text.toString()
            if (string.isNotEmpty()) {
                expression.text = string.substring(0, string.length - 1)
            }
            result.text = ""
        }
        equals.setOnClickListener {
           try {
               val expression = ExpressionBuilder(expression.text.toString()).build()
               val expResult = expression.evaluate()
               val longResult = expResult.toLong()
               if (expResult == longResult.toDouble()) {
                   result.text = longResult.toString()
               } else {
                   result.text = expResult.toString()
               }
           } catch (e:Exception){
               Log.d("Exception","message:"+e.message)
           }
        }
    }

    private fun pressButton(string: String, canClear: Boolean) {

        if(result.text.isNotEmpty()){
            result.text = ""
        }

        if (canClear) {
            result.text = ""
            expression.append(string)
        } else {
            expression.append(result.text)
            expression.append(string)
            result.text = ""
        }
    }
}