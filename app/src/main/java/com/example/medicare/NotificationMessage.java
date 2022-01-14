package com.example.medicare;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NotificationMessage extends AppCompatActivity {
    TextView textView;
    TextView textView2;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_message);
        textView = findViewById(R.id.tv_message);
        textView2 = findViewById(R.id.tv_message2);
        textView3 = findViewById(R.id.tv_message3);
        Bundle bundle = getIntent().getExtras();
        textView.setText(bundle.getString("message"));
        textView2.setText(bundle.getString("message2"));
        textView3.setText(bundle.getString("message3"));

    }
}