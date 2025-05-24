package com.kelompok.penjualanikan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var ikanList: List<Ikan>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        ikanList = listOf(
            Ikan("Ikan Nila", 20000, "Ikan segar dan lezat", R.drawable.ic_launcher_foreground),
            Ikan("Ikan Mujair", 18000, "Ikan cocok digoreng", R.drawable.ic_launcher_foreground),
            Ikan("Ikan Lele", 15000, "Ikan lezat untuk pecel", R.drawable.ic_launcher_foreground)
        )

        recyclerView.adapter = IkanAdapter(ikanList) { ikan ->
            // Buka halaman detail ikan saat item diklik
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("ikanNama", ikan.nama)
            intent.putExtra("ikanHarga", ikan.harga)
            intent.putExtra("ikanDeskripsi", ikan.deskripsi)
            startActivity(intent)
        }
    }
}