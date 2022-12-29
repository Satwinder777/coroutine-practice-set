package com.example.coroutinescope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var textView1: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var count = 0
        textView = findViewById(R.id.textView)
        textView1 = findViewById(R.id.textView2)

        val button = findViewById<Button>(R.id.button2)
        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {

            textView.text = count++.toString()
        }
        button.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch{
                newFunctionCoro()
            }
        }
    }

    private suspend fun newFunctionCoro() {
                var n = 200
            for (i in 1..n)
            {
                withContext(Dispatchers.Main) {
                textView1.text = "$i% downloading.."

                    if (i==n){
                        textView1.text = "Completed!"
                    }
            }

            delay(100)
        }

    }

}