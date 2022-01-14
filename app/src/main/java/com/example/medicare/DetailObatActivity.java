package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.RequestOptions;
import com.example.medicare.cart.Cart;
import com.example.medicare.cart.Cart_Adapter;
import com.example.medicare.kategoriobat.Kategori_Obat;
import com.example.medicare.kategoriobat.model.Obat_Model;
import com.example.medicare.treatment_covid.Treatment_Covid;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class DetailObatActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton kurang, tambah;
    TextInputLayout lytJumlah;
    TextInputEditText edtJumlah ;
    RelativeLayout relativeLayout;
    Integer harga_obat;
    TextView totalHarga;
    Button toKeranjang;
    ImageButton backtoK;
    private ArrayList<Cart> list;
    private String namaObat,kategori, satuan_obat;
    private String url, urlImage;
    private String fixurlImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_obat);
        kurang = findViewById(R.id.kurang);
        kurang.bringToFront();
        kurang.setOnClickListener(this);
        tambah = findViewById(R.id.tambah);
        tambah.bringToFront();
        tambah.setOnClickListener(this);
        lytJumlah = findViewById(R.id.jumlahObatDLyt);
        lytJumlah.bringToFront();
        totalHarga=(TextView)findViewById(R.id.txtTotalHarga);
        edtJumlah = findViewById(R.id.edtJumlahObatD);
        String counter = "0";
        edtJumlah.setText(counter);
        toKeranjang = findViewById(R.id.btnToKeranjang);
        toKeranjang.setOnClickListener(this);
        backtoK = findViewById(R.id.backToKat);
        backtoK.setOnClickListener(this);

        Intent intent = getIntent();
        Obat_Model obat_model = intent.getParcelableExtra("pilih");
        assert obat_model  != null;
        namaObat = obat_model.getNama_obat();
        kategori = obat_model.getKategori();
        harga_obat = obat_model.getHarga_obat();

        satuan_obat = obat_model.getSatuan_obat();
        String indikasi_umum = obat_model.getIndikasi_umum();
        String   perhatian = obat_model.getPerhatian();
        String frekuensi = obat_model.getFrekuensi();
        String komposisi = obat_model.getKomposisi();
        url = "https://medicareapii.herokuapp.com/";
        urlImage = obat_model.getImage();
        fixurlImage  = url + urlImage;
        ImageView imageView =  findViewById(R.id.imageObat);

        Glide.with(this)
                .load(url + urlImage)
                .into(imageView);
        TextView txtnamaObat = findViewById(R.id.txtNamaObat);
        txtnamaObat.setText(namaObat);
        TextView satuanobt = findViewById(R.id.txtSatuanObat);
        satuanobt.setText(satuan_obat);
        TextView txtharga = findViewById(R.id.txtHargaObat);
        String hrg = String.valueOf(harga_obat);

        txtharga.setText(formatRupiah(Double.parseDouble(hrg)));
        TextView txtIndikasiUmum = findViewById(R.id.txtIndikasi);
        txtIndikasiUmum.setText(indikasi_umum);
        TextView txtPerhatian= findViewById(R.id.txtPerhatian);
        txtPerhatian.setText(perhatian);
        TextView txtFrekuensi = findViewById(R.id.txtFrekuensi);
        txtFrekuensi.setText(frekuensi);
        TextView txtKomposisi = findViewById(R.id.txtKomposisi);
        txtKomposisi.setText(komposisi);

        relativeLayout = findViewById(R.id.toKeranjang);
        relativeLayout.animate().alpha(0).start();



    }
    private String formatRupiah(Double number){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(number);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.kurang:
                    Integer jumlah = 0;
                    jumlah = Integer.parseInt(edtJumlah.getText().toString());
                    if(jumlah==1){
                        relativeLayout.animate().alpha(0).translationY(200).setDuration(600).setStartDelay(100).start();
                        edtJumlah.setText("0");

                    }
                    else if (jumlah<1){
                        edtJumlah.setText("0");

                    }
                    else {
                        jumlah--;
                        edtJumlah.setText(jumlah.toString());
                        Integer th = harga_obat*jumlah;
                        totalHarga.setText(formatRupiah(Double.parseDouble(String.valueOf(th))));

                    }
                break;
            case R.id.tambah:

                Integer jumlahT = 0;
                jumlahT = Integer.parseInt(edtJumlah.getText().toString());
                jumlahT++;
                relativeLayout.animate().alpha(1).translationY(-1).setDuration(600).setStartDelay(100).start();
                edtJumlah.setText(jumlahT.toString());
                Integer th = harga_obat*jumlahT;
                totalHarga.setText(formatRupiah(Double.parseDouble(String.valueOf(th))));
                addToCart();
                break;


            case R.id.btnToKeranjang:
                Intent intent = new Intent(DetailObatActivity.this, CartActivity.class);
                startActivity(intent);

                break;
            case R.id.backToKat:
                Intent a = new Intent(DetailObatActivity.this, KategoriObatActivity.class);
                startActivity(a);

                break;

        }

    }

    private void addToCart() {
        list = new ArrayList<>();
        Cart cart = new Cart(
                fixurlImage,
                namaObat,
                kategori,
                harga_obat,
                satuan_obat,
                1
        );
        list.add(cart);

    }
}