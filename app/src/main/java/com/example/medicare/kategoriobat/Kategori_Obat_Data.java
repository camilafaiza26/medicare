//package com.example.medicare.kategoriobat;
//
//import android.widget.Toast;
//
//import com.example.medicare.API.ApiClient;
//import com.example.medicare.R;
//import com.example.medicare.RegisterActivity;
//import com.example.medicare.register.ApiInterface;
//import com.example.medicare.register.model.Register;
//import com.example.medicare.tenagamedis.Tenaga_Medis;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class Kategori_Obat_Data {
//
//    private static ObatInterface obatInterface;
//
//    public static ArrayList<Kategori_Obat> getListData() {
//
//        obatInterface = ApiClient.getClient().create(ObatInterface.class);
//        Call<List<Kategori_Obat>> call = obatInterface.getObat();
//        call.enqueue(new Callback<List<Kategori_Obat>>() {
//            @Override
//            public void onResponse(Call<List<Kategori_Obat>> call, Response<List<Kategori_Obat>> response) {
//                List<Kategori_Obat> rs = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<List<Kategori_Obat>> call, Throwable t) {
//
//            }
//        });
//
//
//
//
//        ArrayList<Kategori_Obat> list = new ArrayList<>();
//        for (int position = 0; position < namaobat.length; position++) {
//            Kategori_Obat kategori_obat= new Kategori_Obat();
//            kategori_obat.setNamaObat(namaobat[position]);
//            kategori_obat.setSatuanObat(ket[position]);
//            kategori_obat.setHargaObat(harga[position]);
//            kategori_obat.setImage(fotoobat[position]);
//            list.add(kategori_obat);
//        }
//        return list;
//    }
//}
