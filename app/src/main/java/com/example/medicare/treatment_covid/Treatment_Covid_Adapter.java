package com.example.medicare.treatment_covid;

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

public class Treatment_Covid_Adapter extends RecyclerView.Adapter<Treatment_Covid_Adapter.ListViewHolder> {
    private ArrayList<Treatment_Covid> listTreatmentCovid;

    public Treatment_Covid_Adapter(ArrayList<Treatment_Covid> list) {
        this.listTreatmentCovid = list;
    }

    @NonNull
    @Override
    public Treatment_Covid_Adapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_treatment_covid, viewGroup, false);
        return new Treatment_Covid_Adapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

        Treatment_Covid treatmentcovid = listTreatmentCovid.get(position);
        Glide.with(holder.itemView.getContext())
                .load(treatmentcovid.getFotoTreatment())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgFotoTreatment);
        holder.txtJudulTreatment.setText(treatmentcovid.getJudulTreatment());
        holder.txtUpdate.setText(treatmentcovid.getUpdate());
        holder.txtCuplikan.setText(treatmentcovid.getCuplikan());

    }

    @Override
    public int getItemCount() {
        return listTreatmentCovid.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView txtJudulTreatment;
        TextView txtUpdate;
        TextView txtCuplikan;
        ImageView imgFotoTreatment;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtJudulTreatment = itemView.findViewById(R.id.txt_judul_treatment);
            txtUpdate = itemView.findViewById(R.id.txt_update);
            txtCuplikan = itemView.findViewById(R.id.txt_cuplikan);
            imgFotoTreatment = itemView.findViewById(R.id.img_foto_treatment);


        }
    }
}
