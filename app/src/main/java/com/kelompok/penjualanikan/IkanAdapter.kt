package com.kelompok.penjualanikan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IkanAdapter(
    private val data: List<Ikan>,
    private val onClick: (Ikan) -> Unit
) : RecyclerView.Adapter<IkanAdapter.IkanViewHolder>() {

    inner class IkanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgIkan: ImageView = itemView.findViewById(R.id.imgIkan)
        val txtNama: TextView = itemView.findViewById(R.id.txtNama)
        val txtHarga: TextView = itemView.findViewById(R.id.txtHarga)

        fun bind(ikan: Ikan) {
            txtNama.text = ikan.nama
            txtHarga.text = "Rp ${ikan.harga}"
            imgIkan.setImageResource(ikan.gambar)
            itemView.setOnClickListener { onClick(ikan) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IkanViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ikan, parent, false)
        return IkanViewHolder(view)
    }

    override fun onBindViewHolder(holder: IkanViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
}