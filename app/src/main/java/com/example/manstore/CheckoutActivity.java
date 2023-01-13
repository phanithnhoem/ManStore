package com.example.manstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CheckoutActivity extends AppCompatActivity {

    Button btnProcessCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        btnProcessCheckout = findViewById(R.id.btnProcessCheckout);
        btnProcessCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Process Checkout Completed!!!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CheckoutActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}