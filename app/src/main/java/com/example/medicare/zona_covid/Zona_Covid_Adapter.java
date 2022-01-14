package com.example.medicare.zona_covid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicare.R;

import java.util.ArrayList;

public class Zona_Covid_Adapter extends RecyclerView.Adapter<Zona_Covid_Adapter.ListViewHolder> {
    private ArrayList<Zona_Covid> listZonaCovid;
    public Zona_Covid_Adapter(ArrayList<Zona_Covid> list) {
        this.listZonaCovid = list;
    }


    @NonNull
    @Override
    public Zona_Covid_Adapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_zona_covid, viewGroup, false);
        return new Zona_Covid_Adapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Zona_Covid_Adapter.ListViewHolder holder, int position) {

        Zona_Covid zona_covid = listZonaCovid.get(position);
        holder.txtKodeProvinsi.setText(zona_covid.getKodeProvinsi());
        holder.txtProvinsi.setText(zona_covid.getProvinsi());
        holder.txtPositif.setText(String.valueOf(zona_covid.getPositif()) + "orang");
        holder.txtNegatif.setText(String.valueOf(zona_covid.getNegatif()) + "orang");
        holder.txtMeninggal.setText(String.valueOf(zona_covid.getMeninggal()) + "orang");
    }

    @Override
    public int getItemCount() {
        return listZonaCovid.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder  {

        TextView txtKodeProvinsi;
        TextView txtProvinsi;
        TextView txtPositif;
        TextView txtNegatif;
        TextView txtMeninggal;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtKodeProvinsi = itemView.findViewById(R.id.kode_prov);
            txtProvinsi = itemView.findViewById(R.id.prov);
            txtPositif= itemView.findViewById(R.id.positif);
            txtNegatif= itemView.findViewById(R.id.negatif);
            txtMeninggal= itemView.findViewById(R.id.meninggal);
        }
    }
}