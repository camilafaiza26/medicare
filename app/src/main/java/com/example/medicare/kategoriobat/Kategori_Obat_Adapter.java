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
import com.example.medicare.kategoriobat.model.Obat_Model;
import com.example.medicare.treatment_covid.Treatment_Covid_Adapter;


import java.util.ArrayList;

public class Kategori_Obat_Adapter extends RecyclerView.Adapter<Kategori_Obat_Adapter.ListViewHolder> {
    private ArrayList<Obat_Model> listKategoriObat;
    private OnClickListener mOnClickListener;

    public Kategori_Obat_Adapter(ArrayList<Obat_Model> list, OnClickListener onClickListener) {

        this.listKategoriObat = list;
        this.mOnClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_kategori_obat, viewGroup, false);
        return new ListViewHolder(view, mOnClickListener);
    }
    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

        String url = "https://medicareapii.herokuapp.com/";

        Obat_Model obat_model = listKategoriObat.get(position);
        holder.name_obat.setText(obat_model.getNama_obat());
        holder.ket.setText(obat_model.getSatuan_obat());
        holder.harga.setText(String.valueOf(obat_model.getHarga_obat()));
        String urlImage =  obat_model.getImage();
        Glide.with(holder.itemView.getContext())
                .load(url+urlImage)
                .into(holder.obat);
    }

    @Override
    public int getItemCount() {
        return listKategoriObat.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        OnClickListener onClickListener;
        TextView  name_obat;
        TextView  ket;
        ImageView obat;
        TextView harga;

        public ListViewHolder(@NonNull View itemView, OnClickListener onClickListener) {
            super(itemView);
            name_obat = itemView.findViewById(R.id.name_obat);
            obat = itemView.findViewById(R.id.obat);
            ket= itemView.findViewById(R.id.ket);
            harga= itemView.findViewById(R.id.harga);
            this.onClickListener = onClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClickListener(getAdapterPosition());
        }
    }
    public interface OnClickListener {
        void onClick(View view);

        void onClickListener(int position);
    }
}
