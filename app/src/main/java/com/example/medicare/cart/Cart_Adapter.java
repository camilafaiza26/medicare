package com.example.medicare.cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.medicare.R;
import com.google.android.material.textfield.TextInputEditText;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Cart_Adapter extends RecyclerView.Adapter<Cart_Adapter.ListViewHolder> {

    private ArrayList<Cart> listCard;
    public Cart_Adapter(ArrayList<Cart> list) {
        this.listCard = list;
      }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_cart, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

        Cart cart = listCard.get(position);
        String url = "https://medicareapii.herokuapp.com/";

        String urlImage =  cart.getImage();
        Glide.with(holder.itemView.getContext())
                .load(url+urlImage)
                .into(holder.imgFotoObat);
        holder.txtNamaObat.setText(cart.getNama_obat());
        holder.txtKatC.setText(cart.getKategori());
        holder.jumlahObat.setText(String.valueOf(cart.getJumlah_obat()));
        holder.txtHargaSatuan.setText(String.valueOf(formatRupiah.format(cart.getHarga_obat())));

    }

    @Override
    public int getItemCount() {
        return listCard.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder  {

        TextView txtNamaObat;
        TextView txtHargaSatuan;
        TextView txtKatC;
        TextInputEditText jumlahObat;
        ImageButton plusC, minC;
        ImageView imgFotoObat;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoObat= itemView.findViewById(R.id.img_foto_obatC);
            txtNamaObat = itemView.findViewById(R.id.txtnamaobatC);
            jumlahObat = itemView.findViewById(R.id.edtJumlahObatC);
            txtKatC= itemView.findViewById(R.id.txtKatC);
            txtHargaSatuan = itemView.findViewById(R.id.txtHargaSatuan);
            plusC= itemView.findViewById(R.id.plusC);
            minC= itemView.findViewById(R.id.minC);
        }
    }
}
