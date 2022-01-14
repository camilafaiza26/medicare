package com.example.medicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.medicare.cart.Cart;
import com.example.medicare.cart.Cart_Adapter;
import com.example.medicare.treatment_covid.Treatment_Covid;
import com.example.medicare.treatment_covid.Treatment_Covid_Adapter;
import com.example.medicare.treatment_covid.Treatment_Covid_Data;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rvCart;
    private ArrayList<Cart> list = new ArrayList<>();
    Button toCheckOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        rvCart = findViewById(R.id.rv_cart);
        rvCart.setHasFixedSize(true);

        toCheckOut = findViewById(R.id.toCheckOut);
        toCheckOut.setOnClickListener(this);

        list = new ArrayList<>();
        Cart cart = new Cart(
              "H",
                "H","H",1,"a",
                1
        );
        list.add(cart);
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvCart.setLayoutManager(new LinearLayoutManager(this));
        Cart_Adapter cart_adapter = new Cart_Adapter(list);
        rvCart.setAdapter(cart_adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toCheckOut:
                Intent toCheckOut = new Intent(CartActivity.this, Checkout.class);
                startActivity(toCheckOut);
                break;
        }
    }
}