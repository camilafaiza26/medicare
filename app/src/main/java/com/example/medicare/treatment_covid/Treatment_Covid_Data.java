package com.example.medicare.treatment_covid;

import com.example.medicare.R;
import com.example.medicare.riwayat_transaksi.Riwayat_Transaksi;

import java.util.ArrayList;

public class Treatment_Covid_Data {
    //Fake RegisterData
    private static String[] judulTreatment = {
            "Ini obat terapi covid gejala ringan sampai berat versi ..",
            "Pertama kalinya, ini obat untuk pengobatan covid....",
            "Pengobatan covid-19",
    };

    private static String[] update = {
            "17 hours ago",
            "two days ago",
            "12 hours ago",

    };
    private static String[] cuplikan = {
            "Jokowi menyampaikan terapi obat yang bisa digunakan oleh pasien Covid-19 untuk tanpa gejala hingga ringan.",
            "Untuk pertama kalinya ditemukan obat yang bisa digunakan untuk pengobatan covid",
            "Dokter dan ilmuwan hingga kini masih berusaha memahami gambaran lengkap virus corona.",
    };
    private static String[] description ={
            "Jakarta, CNBC Indonesia - Indonesia sedang gelut dengan kenaikan infeksi Covid-19 yang tinggi. Banyak rumah sakit yang tidak lagi menerima pasien karena kapasitas penuh. Presiden Joko Widodo (Jokowi) berusaha membantu menyelesaikan masalah ini.\n" +
                    "Melalui akun Instagram resminya, Jokowi mengungkapkan tidak semua mereka yang terkonfirmasi positif Covid-19 harus masuk rumah sakit. Beberapa masih bisa melakukan isolasi mandiri (isoman). Berikut kriteria bagi mereka yang harus mendapatkan perawatan di rumah sakit:\n" +
                    "\n" +
                    "1. Pasien Covid tanpa gejala\n" +
                    "\n" +
                    "Gejala: frekuensi nafas 12-20 kali per menit saturasi di atas 94%. Tidak perlu dirawat di rumah sakit. Isolasi mandiri di rumah atau fasilitas isolasi pemerintah.\n" +
                    "\n" +
                    "Terapi menggunakan vitamin C, vitamin D, dan vitamin Zinc (seng) dengan lama perawatan 10 hari isolasi sejak pengambilan spesimen diagnosis konfirmasi.\n" +
                    "\n" +
                    "2. Pasien Ringan\n" +
                    "\n" +
                    "Gejala: demam, batuk (umumnya batuk kering), kelelahan ringan, anoreksia, sakit kepala, kehilangan indra penciuman, malgia dan nyeri tulang, nyeri tenggorokan, diare, pilek dan bersin, mual, muntah, nyeri perut hingga kemerahan pada kulit. Frekuensi nafas 12-20 kali per menit dan saturasi di atas 94%.\n" +
                    "\n" +
                    "Pasien ini tidak perlu dirawat di rumah sakit. Isolasi mandiri di rumah atau fasilitas isolasi pemerintah.\n" +
                    "\n" +
                    "Terapi pengobatan menggunakan oseltamivir atau favipiravir, Asitromisin, vitamin C, vitamin D, dan Zinc. Isolasi selama 10 hari sejak timbul gejala dan minimal 3 hari bebas gejala.",
            "Bisnis.com, JAKARTA - The Medicines and Healthcare Products Regulatory Agency (MHRA) Inggris telah memberikan persetujuan untuk pengobatan antibodi monoklonal pertama untuk pencegahan dan pengobatan COVID-19 di Inggris. Menindaklanjuti dari tinjauan menyeluruh terhadap bukti yang dilakukan oleh MHRA, dan rekomendasi oleh Komisi Pengobatan Manusia (CHM), badan penasihat ilmiah ahli independen pemerintah, MHRA telah menyetujui Ronapreve sebagai produk kombinasi antibodi monoklonal pertama yang diindikasikan untuk digunakan dalam pencegahan dan pengobatan infeksi COVID-19 akut untuk Inggris. Dikembangkan oleh Regeneron/Roche, obat ini diberikan baik melalui suntikan atau infus dan bekerja pada lapisan sistem pernapasan di mana ia mengikat erat pada virus corona dan mencegahnya mendapatkan akses ke sel-sel sistem pernapasan. RegisterData uji klinis yang dinilai oleh tim ilmuwan dan dokter MHRA yang berdedikasi telah menunjukkan bahwa Ronapreve dapat digunakan untuk mencegah infeksi, meningkatkan resolusi gejala infeksi COVID-19 akut, dan dapat mengurangi kemungkinan dirawat di rumah sakit karena COVID-19.\n" +
                    "\n" +
                    "Artikel ini telah tayang di Bisnis.com dengan judul \"Pertama Kalinya, Ini Obat untuk Pengobatan Covid-19 yang Disetujui Inggris \", Klik selengkapnya di sini: https://lifestyle.bisnis.com/read/20210822/106/1432433/pertama-kalinya-ini-obat-untuk-pengobatan-covid-19-yang-disetujui-inggris.\n" +
                    "Author: Mia Chitra Dinisari\n" +
                    "Editor : Mia Chitra Dinisari\n" +
                    "\n" +
                    "Download aplikasi Bisnis.com terbaru untuk akses lebih cepat dan nyaman di sini:\n" +
                    "Android: http://bit.ly/AppsBisniscomPS\n" +
                    "iOS: http://bit.ly/AppsBisniscomIOS",
            "Ketika Melissa Heightman membuka klinik pasca-Covid-19 pertama di Inggris pada Mei 2020, ia mengira sebagian besar waktunya akan dihabiskan untuk membantu para pasien pulih dari efek samping setelah berminggu-minggu dipasangi alat bantu pernapasan di rumah sakit.\n" +
                    "\n" +
                    "Bagi sebagian besar pasien ini, ia memperkirakan jalan menuju pemulihan total akan cepat.\n" +
                    "\n" +
                    "\"Pada awal pandemi, kami tidak tahu akan seperti apa gejala jangka panjang sisa infeksi Covid  kata Heightman, seorang konsultan spesialis pernapasan.\n" +
                    "\n" +
                    "\"Kami pikir itu akan seperti flu, semuanya akan hilang begitu saja, dan pasien akan baik-baik saja \n" +
                    "\n" +
                    "Ia tak menyangka bila setahun kemudian, sepertiga pasien yang datang ke kliniknya di University College London Hospital (UCLH) masih tidak sehat, dan sebagian besarnya belum dapat bekerja.\n" +
                    "\n" +
                    "Lebih dari setengahnya tidak pernah dirawat di rumah sakit karena Covid-19.\n" +
                    "\n" +
                    "Tak lama setelah kliniknya dibuka, Heightman mulai menerima telepon dari dokter-dokter setempat yang bingung karena tiba-tiba didatangi banyak pasien - seringkali berusia relatif muda dan tanpa kondisi kesehatan bawaan - yang mengalami gejala kronis.\n" +
                    "\n" +
                    "Cerita mereka semua mengikuti pola yang sama, dimulai dengan infeksi yang tampaknya ringan, sebelum kumpulan penyakit yang aneh mulai muncul.\n" +
                    "\n" +
                    "Alih-alih mereda, gejala-gejala ini terus berlanjut selama berminggu-minggu dan bahkan berbulan-bulan setelah virus seharusnya sudah meninggalkan tubuh mereka.\n" +
                    "\n" +
                    "Itu teka-teki yang tidak disangka-sangka oleh dunia medis. Pasien-pasien ini awalnya terabaikan kata Heightman.\n" +
                    "\n" +
                    "Sebagian besar rumah sakit awalnya tidak dapat memeriksa mereka, karena tidak memiliki anggaran untuk membuka klinik khusus pasca-Covid. Tetapi mereka sekarang menjadi fokus utama kami."
    };
    private static int[] fotoTreatment= {
            R.drawable.tr1,
            R.drawable.tr2,
            R.drawable.tr3
    };
    private static String penerbit[] = {
      "CNN Indonesia",
      "Kompas",
      "Kompas"
    };

    public static ArrayList<Treatment_Covid> getListData() {
        ArrayList<Treatment_Covid> list = new ArrayList<>();
        for (int position = 0; position < judulTreatment.length; position++) {
            Treatment_Covid treatmentcovid= new Treatment_Covid();
            treatmentcovid.setJudulTreatment(judulTreatment[position]);
            treatmentcovid.setUpdate(update[position]);
            treatmentcovid.setCuplikan(cuplikan[position]);
            treatmentcovid.setFotoTreatment(fotoTreatment[position]);
            treatmentcovid.setDescription(description[position]);
            treatmentcovid.setPenerbit(penerbit[position]);
            list.add(treatmentcovid);
        }
        return list;
    }
}
