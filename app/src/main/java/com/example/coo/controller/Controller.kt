package com.example.coo.controller

class Controller (private val callback: Callback) {
    fun bandingke(angka: Int, angka2: Int){
        val result = angka + angka2
        callback.tampilkanHasil(result.toString())

    }
}