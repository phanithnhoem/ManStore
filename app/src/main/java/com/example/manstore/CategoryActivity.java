package com.example.manstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener {

    TextView categName;
    ImageView imgBack;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        String categoryName = getIntent().getStringExtra("CategoryName");
        categName = (TextView) findViewById(R.id.lblCategoryTitle);
        categName.setText(categoryName);

        imgBack = (ImageView) findViewById(R.id.imgBack);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);

        imgBack.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgBack:
                Intent intent = new Intent(CategoryActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn1:
                Intent intent1 = new Intent(CategoryActivity.this, ProductDetailActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn2:
                Intent intent2 = new Intent(CategoryActivity.this, ProductDetailActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn3:
                Intent intent3 = new Intent(CategoryActivity.this, ProductDetailActivity.class);
                startActivity(intent3);
                break;
            case R.id.btn4:
                Intent intent4 = new Intent(CategoryActivity.this, ProductDetailActivity.class);
                startActivity(intent4);
                break;
            case R.id.btn5:
                Intent intent5 = new Intent(CategoryActivity.this, ProductDetailActivity.class);
                startActivity(intent5);
                break;
            case R.id.btn6:
                Intent intent6 = new Intent(CategoryActivity.this, ProductDetailActivity.class);
                startActivity(intent6);
                break;
            case R.id.btn7:
                Intent intent7 = new Intent(CategoryActivity.this, ProductDetailActivity.class);
                startActivity(intent7);
                break;
            case R.id.btn8:
                Intent intent8 = new Intent(CategoryActivity.this, ProductDetailActivity.class);
                startActivity(intent8);
                break;
        }

    }
}