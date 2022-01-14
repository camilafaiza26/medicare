package com.example.medicare;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;
import android.util.Base64;
import com.example.medicare.API.ApiClient;
import com.example.medicare.profile.ApiInterfaceProfile;
import com.example.medicare.profile.model.Profile;
import com.example.medicare.register.ApiInterface;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.io.ByteArrayInputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfileActivity extends AppCompatActivity {

    ImageView imageView;
    Button tglLahir, saveButton;
    TextInputEditText emailEdt, nameEdt, phoneEdt , tinggiEdt, beratEdt, passwordEdt;
    TextInputLayout emailLyt, nameLyt, phoneLyt, passwordLyt;
    SessionManager sessionManager;
    RadioButton priaRbtn, wanitaRbtn;
    ApiInterfaceProfile apiInterfaceProfile;
    Bitmap imageBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        imageView = findViewById(R.id.imageView2);

        sessionManager = new SessionManager(EditProfileActivity.this);

        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }
        else{
            String auth = "Bearer "+ sessionManager.getUserDetail().get(SessionManager.TOKEN);
            getProfile(auth);
        }

        nameEdt = findViewById(R.id.namaEdt);
        emailEdt = findViewById(R.id.emailEdt);
        phoneEdt = findViewById(R.id.nohpEdt);
        passwordEdt = findViewById(R.id.passwordEdt);
        tinggiEdt = findViewById(R.id.tinggiEdt);
        beratEdt = findViewById(R.id.beratEdt);
        priaRbtn = findViewById(R.id.pria);
        wanitaRbtn = findViewById(R.id.wanita);

        nameLyt = findViewById(R.id.namaLyt);
        emailLyt = findViewById(R.id.emailLyt);
        passwordLyt = findViewById(R.id.passwordLyt);
        phoneLyt = findViewById(R.id.nohpLyt);
        tglLahir = findViewById(R.id.tanggalLahirEdt);

        //GET PROFILE



        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
        builder.setSelection(Calendar.getInstance().getTimeInMillis());

        final MaterialDatePicker materialDatePicker = builder.build();
        tglLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(),"DATE_PICKER");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                String date = materialDatePicker.getHeaderText();
                SimpleDateFormat spf = new SimpleDateFormat("dd MMM yyyy");
                Date newDate = null;
                try {
                    newDate = spf.parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                spf = new SimpleDateFormat("yyyy-MM-DD");
                String newDateString = spf.format(newDate);
                tglLahir.setText(newDateString);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent photoIntent = new Intent();
                photoIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
//                if(photoIntent.resolveActivity(getPackageManager()) =! null ) {
                startActivityForResult(photoIntent, 201803);
//                }
            }
        });



        //EDIT PROFILE
        saveButton = findViewById(R.id.save_button);

        saveButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                boolean isValid = true;
                if(nameEdt.getText().toString().isEmpty()){
                    nameLyt.setError("Nama harus diisi!");
                    isValid = false;
                }
                else {
                    nameLyt.setErrorEnabled(false);
                }
                if(emailEdt.getText().toString().isEmpty()){
                    emailLyt.setError("Email harus diisi!");
                    isValid = false;
                }
                else {
                    emailLyt.setErrorEnabled(false);
                }
                if(passwordEdt.getText().toString().isEmpty()){
                    passwordLyt.setError("Password Harus Diisi!");
                    isValid = false;
                }
                else {
                    passwordLyt.setErrorEnabled(false);
                }
                if(phoneEdt.getText().toString().isEmpty()){
                    phoneLyt.setError("No Hp harus diisi!");
                    isValid = false;
                }
                else if(passwordEdt.getText().toString().trim().length()<8 ){
                    passwordLyt.setError("Minimal 8 karakter!");
                    isValid = false;
                }
                else {
                    passwordLyt.setErrorEnabled(false);
                }

                String name = nameEdt.getText().toString();
                String email = emailEdt.getText().toString();
                String phone = phoneEdt.getText().toString();
                String password = passwordEdt.getText().toString();
                int tinggi;
                int berat;
                if(tinggiEdt.getText().toString().isEmpty()){
                    tinggi = 0;
                }
                else{
                    tinggi = Integer.parseInt(tinggiEdt.getText().toString());
                }

                if(beratEdt.getText().toString().isEmpty()){
                    berat = 0;
                }
                else{
                    berat = Integer.parseInt(beratEdt.getText().toString());
                }
                String tanggallahir  = tglLahir.getText().toString();
                String jeniskelamin = null;
                if(priaRbtn.isChecked()){
                    jeniskelamin="P";

                }
                else if(wanitaRbtn.isChecked()){
                    jeniskelamin = "W";
                }
                else{
                    jeniskelamin = null;
                }
                String auth = "Bearer "+ sessionManager.getUserDetail().get(SessionManager.TOKEN);

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                imageBitmap.compress(Bitmap.CompressFormat.JPEG, 75, byteArrayOutputStream);
                byte[] imageInByte = byteArrayOutputStream.toByteArray();
                String profile_picture = Base64.encodeToString(imageInByte, Base64.DEFAULT);

                Toast.makeText(EditProfileActivity.this, profile_picture, Toast.LENGTH_SHORT).show();

                if(isValid){
                    updateProfile(auth,name,email,phone,password,tanggallahir,tinggi,berat,jeniskelamin, profile_picture);
                }
            }
        });




    }

    private void getProfile(String auth) {
        apiInterfaceProfile = ApiClient.getClient().create(ApiInterfaceProfile.class);
        Call<Profile> call = apiInterfaceProfile.getProfile(auth);
        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (response.body() != null) {
                    Toast.makeText(EditProfileActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    nameEdt.setText(response.body().getData().getName());
                    emailEdt.setText(response.body().getData().getEmail());
                    phoneEdt.setText(response.body().getData().getPhone());

                    if(String.valueOf(response.body().getData().getTinggi()).equals(null)){
                        String tinggi = "0";
                        tinggiEdt.setText(tinggi);
                    }
                    else{
                        tinggiEdt.setText(String.valueOf(response.body().getData().getTinggi()));
                    }

                    if(String.valueOf(response.body().getData().getBerat()).equals(null)){
                        String berat = "0";
                        beratEdt.setText(berat);
                    }
                    else{
                        beratEdt.setText(String.valueOf(response.body().getData().getBerat()));
                    }
                    String jeniskelamin = response.body().getData().getJeniskelamin();

                    if(jeniskelamin.equals("P")){
                        priaRbtn.setChecked(true);
                    }
                    else if(jeniskelamin.equals("L")){
                        wanitaRbtn.setChecked(true);
                    }
                    else{
                        priaRbtn.setChecked(false);
                        wanitaRbtn.setChecked(false);
                    }
                    if(response.body().getData().getTanggallahir().equals(null)){
                        tglLahir.setText("Masukkan Tanggal");
                    }
                    else{
                        tglLahir.setText(response.body().getData().getTanggallahir());
                    }

                }
                else{
                    Toast.makeText(EditProfileActivity.this, "Gagal Dapat Data!", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                Toast.makeText(EditProfileActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void moveToLogin() {

            Intent toLogin = new Intent(EditProfileActivity.this, Onboarding.class);
            toLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(toLogin);
            finish();

    }

    private void updateProfile(String auth,String name, String email, String phone, String password, String tanggallahir, int tinggi, int berat, String jeniskelamin, String profile_picture) {



        apiInterfaceProfile = ApiClient.getClient().create(ApiInterfaceProfile.class);
        Call<Profile> call = apiInterfaceProfile.updateProfileResponse(auth, name,email,phone,password, tanggallahir, tinggi, berat, jeniskelamin, profile_picture);
        call.enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (response.body() != null) {

                    Toast.makeText(EditProfileActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EditProfileActivity.this, ProfileActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(EditProfileActivity.this, "Gagal Update, Cek Inputan Kembali!", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                Toast.makeText(EditProfileActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 201803 && resultCode == RESULT_OK ){
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}