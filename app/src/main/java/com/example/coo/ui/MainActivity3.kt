package com.example.coo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.coo.R
import com.example.coo.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        fun sendMessage(view: View) {
            val editText = findViewById<EditText>(R.id.editText1)
            val message = editText.text.toString()
            val intent = Intent(this@MainActivity3, MainActivity4::class.java).apply {
                putExtra("pesan", message)
            }
            startActivity(intent)
        }

        binding.imageView8.setOnClickListener(){
            val go= Intent(this@MainActivity3, MainActivity4::class.java)
            startActivity(go)
            finish()
        }
    }
}