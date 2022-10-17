package com.example.coo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.coo.R
import com.example.coo.controller.Callback
import com.example.coo.controller.Controller
import com.example.coo.databinding.ActivityVsPemainBinding

class VsPemain : AppCompatActivity(), Callback {
    private lateinit var binding: ActivityVsPemainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVsPemainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnKiri = listOf(binding.batu1, binding.gunting1, binding.kertas1)
        val btnKanan = listOf(binding.batu2, binding.gunting2, binding.kertas2)

        val controller = Controller(this)
        var inputankamu = 0
        var inputanaku = 0




        btnKiri.forEach { imgView ->
            imgView.setOnClickListener {
                imgView.selected()

 //sore diperbaiki rehat:)               Toast.makeText(this, "Halo" , Toast.LENGTH_SHORT).show()
// buat random               btnKanan.random().selected()


                inputanaku = imgView.contentDescription.toString().toInt()
                if (inputankamu !=0) controller.bandingke(inputanaku, inputankamu)



            }
        }

//        binding.batu2.isEnabled = false
//        binding.gunting2.isEnabled = false
//        binding.kertas2.isEnabled = false
        btnKanan.forEach { imgView ->
            imgView.setOnClickListener {
                imgView.selected()

                inputankamu = imgView.contentDescription.toString().toInt()
                if (inputanaku !=0) controller.bandingke(inputanaku, inputankamu)

            }

        }

        binding.reset.setOnClickListener {
            btnKanan.forEach { it.unselected() }
            btnKiri.forEach { it.unselected() }
        }




    }


    fun ImageView.selected() {
        setBackgroundColor(R.drawable.bg_rounded)
        backgroundTintList = ContextCompat.getColorStateList(this@VsPemain, R.color.green)
    }

    fun ImageView.unselected() {
        setBackgroundColor(R.drawable.bg_rounded)
        backgroundTintList = ContextCompat.getColorStateList(this@VsPemain, R.color.white)
    }


    override fun tampilkanHasil(result: String) {
        binding.texthasil.text = result
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Dialog Cancleable")
        dialog.setMessage("dialog Bisa ditutup dengan klik luar")
        dialog.setCancelable(true)

        dialog.show()

    }



}