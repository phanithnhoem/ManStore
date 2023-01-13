package com.example.manstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean hidePassword = false;

    EditText txtPassword;
    TextView lblSignUp;
    Button btnSignIn;
    ImageView imgHidePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        txtPassword = (EditText) findViewById(R.id.txtPassword);
        lblSignUp = (TextView) findViewById(R.id.lblSignUp);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        imgHidePassword = (ImageView) findViewById(R.id.imgHidePassword);

        lblSignUp.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
        imgHidePassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSignIn:
                Intent intentMain = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intentMain);
                break;
            case R.id.lblSignUp:
                Intent intentSignUp = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intentSignUp);
                break;
            case R.id.imgHidePassword:
                if (hidePassword){
                    hidePassword = false;
                    txtPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    imgHidePassword.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                } else {
                    hidePassword = true;
                    txtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    imgHidePassword.setImageResource(R.drawable.ic_baseline_visibility_24);
                }
                txtPassword.setSelection(txtPassword.length());
                break;
        }
    }
}