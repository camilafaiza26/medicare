package com.example.medicare.tenagamedis;

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


public class Tenaga_Medis_Adapter extends RecyclerView.Adapter<Tenaga_Medis_Adapter.ListViewHolder> {

    private ArrayList<Tenaga_Medis> listTenagaMedis;

    public Tenaga_Medis_Adapter(ArrayList<Tenaga_Medis> list) {
        this.listTenagaMedis = list;
    }

    @NonNull
    @Override
    public Tenaga_Medis_Adapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_tenaga_medis, viewGroup, false);
        return new Tenaga_Medis_Adapter.ListViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Tenaga_Medis_Adapter.ListViewHolder holder, int position) {

        Tenaga_Medis tenaga_medis = listTenagaMedis.get(position);
        holder.txtnamaRS.setText(tenaga_medis.getNamaRS());
        holder.txtalamatRS.setText(tenaga_medis.getAlamatRS());
         holder.fotoRS.setImageResource(tenaga_medis.getFotoRumahSakit());
    }

    @Override
    public int getItemCount() {
        return listTenagaMedis.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder  {

        TextView txtnamaRS;
        ImageView fotoRS;
        TextView txtalamatRS;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtnamaRS = itemView.findViewById(R.id.txtnamaRS);
            fotoRS = itemView.findViewById(R.id.fotoRS);
            txtalamatRS= itemView.findViewById(R.id.txt_alamatRS);
        }
    }

}
