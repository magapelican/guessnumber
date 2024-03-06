package com.example.guessnumber

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editTextNumber)
        val textView = findViewById<TextView>(R.id.writeNumberText)

        var randomNumber = Random.nextInt(1, 10000)
        var counter = 0
        button.setOnClickListener {
            var userNumber = Integer.parseInt(editText.text.toString())
            val ans = compare(randomNumber, userNumber)
            ++counter
            if (ans.equals("В точку!")) {
                randomNumber = Random.nextInt(1, 10000)
                counter = 0
            }
            textView.text = ans + "\nПопытка #" + counter +
                    "\nВаше число - " + userNumber
        }

    }

    fun compare( randomNumber:Int, userNumber:Int):String {
        var ans : String
        if (randomNumber == userNumber)
            ans = "В точку!"
        else if (randomNumber > userNumber)
            ans = "Меньше!"
        else
            ans = "Больше"

        return ans
    }

}




