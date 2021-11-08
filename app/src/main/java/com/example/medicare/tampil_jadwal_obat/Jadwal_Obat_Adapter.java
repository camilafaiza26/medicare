package com.example.medicare.tampil_jadwal_obat;
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
import com.example.medicare.riwayat_transaksi.Riwayat_Transaksi;
import com.example.medicare.riwayat_transaksi.Riwayat_Transaksi_Adapter;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Jadwal_Obat_Adapter extends RecyclerView.Adapter<Jadwal_Obat_Adapter.ListViewHolder>{

    private final ArrayList<Jadwal_Obat> listJadwalObat;

    public Jadwal_Obat_Adapter(ArrayList<Jadwal_Obat> list) {
        this.listJadwalObat = list;
    }

    @NonNull
    @Override
    public Jadwal_Obat_Adapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_jadwal_obat, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Jadwal_Obat_Adapter.ListViewHolder holder, int position) {

        Jadwal_Obat jadwal_obat = listJadwalObat.get(position);
        holder.txtNamaObat.setText(jadwal_obat.getNamaObat());
        holder.txtStatusJadwal.setText(jadwal_obat.getStatusJadwal());
        holder.txtJadwalObat.setText(jadwal_obat.getJadwalObat());
    }

    @Override
    public int getItemCount() {
        return listJadwalObat.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder  {

        TextView txtNamaObat;
        TextView txtStatusJadwal;
        TextView txtJadwalObat;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNamaObat = itemView.findViewById(R.id.txt_nama_obat);
            txtStatusJadwal = itemView.findViewById(R.id.txt_status_jadwal);
            txtJadwalObat= itemView.findViewById(R.id.txt_waktu_obat);
        }
    }

}
