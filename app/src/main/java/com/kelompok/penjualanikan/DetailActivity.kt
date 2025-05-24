package com.kelompok.penjualanikan

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val nama = intent.getStringExtra("ikanNama")
        val harga = intent.getIntExtra("ikanHarga", 0)
        val deskripsi = intent.getStringExtra("ikanDeskripsi")

        findViewById<TextView>(R.id.txtNamaDetail).text = nama
        findViewById<TextView>(R.id.txtHargaDetail).text = "Rp $harga"
        findViewById<TextView>(R.id.txtDeskripsiDetail).text = deskripsi
    }
}