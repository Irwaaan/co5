package com.example.coo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.coo.R
import com.example.coo.databinding.ActivityMain4Binding


class MainActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val message = intent.getStringExtra("pesan")
        val textView =findViewById<TextView>(R.id.textView3).apply {
            text = message
        }



        binding.vspemain.setOnClickListener {
            val go = Intent(this@MainActivity4, VsPemain::class.java)
            startActivity(go)
        }
        binding.vsbot.setOnClickListener {
            val go = Intent(this@MainActivity4, VsBot::class.java)
            startActivity(go)
        }


    }
}