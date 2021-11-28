package com.example.medicare.beritacovid;

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

public class Berita_Covid_Adapter extends RecyclerView.Adapter<Berita_Covid_Adapter.ListViewHolder> {
    private ArrayList<Berita_Covid> listBeritaCovid;

    public Berita_Covid_Adapter(ArrayList<Berita_Covid> list) {
        this.listBeritaCovid = list;
    }
    @NonNull
    @Override
    public Berita_Covid_Adapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_berita_covid, viewGroup, false);
        return new Berita_Covid_Adapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Berita_Covid_Adapter.ListViewHolder holder, int position) {

        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

        Berita_Covid beritacovid = listBeritaCovid.get(position);
        Glide.with(holder.itemView.getContext())
                .load(beritacovid.getFotoBerita())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgFotoBerita);
        holder.txtJudulBerita.setText(beritacovid.getJudulBerita());
        holder.txtWaktu.setText(beritacovid.getWaktu());
        holder.txtSumber.setText(beritacovid.getSumber());

    }

    @Override
    public int getItemCount() {
        return listBeritaCovid.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder  {

        TextView txtJudulBerita;
        TextView txtWaktu;
        TextView txtSumber;
        ImageView imgFotoBerita;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtJudulBerita = itemView.findViewById(R.id.textView2);
            txtWaktu = itemView.findViewById(R.id.textView13);
            txtSumber= itemView.findViewById(R.id.textView14);
            imgFotoBerita= itemView.findViewById(R.id.imageView8);


        }
    }
}
