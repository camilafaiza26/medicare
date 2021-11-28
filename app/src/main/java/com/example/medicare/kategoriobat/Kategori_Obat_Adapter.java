package com.example.medicare.kategoriobat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.medicare.R;


import java.util.ArrayList;

public class Kategori_Obat_Adapter extends RecyclerView.Adapter<Kategori_Obat_Adapter.ListViewHolder> {
    private ArrayList<Kategori_Obat> listKategoriObat;

    public Kategori_Obat_Adapter(ArrayList<Kategori_Obat> list) {
        this.listKategoriObat = list;
    }

    @NonNull
    @Override
    public Kategori_Obat_Adapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_kategori_obat, viewGroup, false);
        return new Kategori_Obat_Adapter.ListViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Kategori_Obat_Adapter.ListViewHolder holder, int position) {

        Kategori_Obat kategori_obat = listKategoriObat.get(position);
        holder.name_obat.setText(kategori_obat.getNamaobat());
        holder.ket.setText(kategori_obat.getKet());
        holder.harga.setText(kategori_obat.getHarga());
        holder.obat.setImageResource(kategori_obat.getFotoobat());
    }

    @Override
    public int getItemCount() {
        return listKategoriObat.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder  {

        TextView  name_obat;
        TextView  ket;
        ImageView obat;
        TextView harga;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            name_obat = itemView.findViewById(R.id.name_obat);
            obat = itemView.findViewById(R.id.obat);
            ket= itemView.findViewById(R.id.ket);
            harga= itemView.findViewById(R.id.harga);
        }
    }
}
