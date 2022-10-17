package com.example.coo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.coo.R
import com.example.coo.controller.Callback
import com.example.coo.controller.Controller
import com.example.coo.databinding.ActivityVsBotBinding
import com.example.coo.databinding.ActivityVsPemainBinding

class VsBot : AppCompatActivity(), Callback {
    private lateinit var binding: ActivityVsBotBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVsBotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnKiri = listOf(binding.batu1, binding.gunting1, binding.kertas1)
        val btnKanan = listOf(binding.batu2, binding.gunting2, binding.kertas2)

        val controller = Controller(this)
        var inputankamu = 0
        var inputanaku = 0



        btnKiri.forEach { imgView ->
            imgView.setOnClickListener {
                imgView.selected()
                btnKanan.random().selected()


                inputanaku = imgView.contentDescription.toString().toInt()
                if (inputankamu !=0) controller.bandingke(inputanaku, inputankamu)
                val dialog = AlertDialog.Builder(this)
                dialog.setTitle("Dialog Cancleable")
                dialog.setMessage("dialog Bisa ditutup dengan klik luar")
                dialog.setCancelable(true)

                dialog.show()


            }
        }

        binding.batu2.isEnabled = false
        binding.gunting2.isEnabled = false
        binding.kertas2.isEnabled = false

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
        backgroundTintList = ContextCompat.getColorStateList(this@VsBot, R.color.green)
    }

    fun ImageView.unselected() {
        setBackgroundColor(R.drawable.bg_rounded)
        backgroundTintList = ContextCompat.getColorStateList(this@VsBot, R.color.white)
    }


    override fun tampilkanHasil(result: String) {
        binding.texthasil.text = result

    }

}