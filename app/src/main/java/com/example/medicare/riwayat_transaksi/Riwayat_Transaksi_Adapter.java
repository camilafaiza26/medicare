package com.example.medicare.riwayat_transaksi;

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

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Riwayat_Transaksi_Adapter extends RecyclerView.Adapter<Riwayat_Transaksi_Adapter.ListViewHolder> {
    private ArrayList<Riwayat_Transaksi> listRiwayatTransaksi;

    public Riwayat_Transaksi_Adapter(ArrayList<Riwayat_Transaksi> list) {
        this.listRiwayatTransaksi = list;
      }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_riwayat_transaksi, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

       Riwayat_Transaksi riwayat_transaksi = listRiwayatTransaksi.get(position);
         Glide.with(holder.itemView.getContext())
       .load(riwayat_transaksi.getFotoObat())
       .apply(new RequestOptions().override(55, 55))
       .into(holder.imgFotoObat);
        holder.txtNamaObat.setText(riwayat_transaksi.getNamaObat());
        holder.txtJumlahObat.setText(String.valueOf(riwayat_transaksi.getJumlahObat()) + " item");
        holder.txtWaktuTransaksi.setText(riwayat_transaksi.getWaktuTransaksi());
        holder.txtStatusPembelian.setText(riwayat_transaksi.getStatusPembelian());
        holder.txtTotalHargaObat.setText(String.valueOf(formatRupiah.format(riwayat_transaksi.getTotalHargaObat())));

    }

    @Override
    public int getItemCount() {
        return listRiwayatTransaksi.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder  {

        TextView txtNamaObat;
        TextView txtJumlahObat;
        TextView txtTotalHargaObat;
        TextView txtStatusPembelian;
        TextView txtWaktuTransaksi;
        ImageView imgFotoObat;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNamaObat = itemView.findViewById(R.id.txt_nama_obat);
            txtJumlahObat = itemView.findViewById(R.id.txt_jumlah_obat);
            txtTotalHargaObat= itemView.findViewById(R.id.txt_total_harga_obat);
            txtStatusPembelian= itemView.findViewById(R.id.txt_status_pembelian);
            txtWaktuTransaksi= itemView.findViewById(R.id.txt_waktu_transaksi);
            imgFotoObat= itemView.findViewById(R.id.img_foto_obat);


        }
    }
}
