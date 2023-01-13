package com.example.manstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    //Declare variables
    private boolean showPassword = false;
    private boolean showConfirmPassword = false;
    TextView lblSignIn;
    Button btnSignUp;
    EditText txtPassword;
    EditText txtConfirmPassword;
    EditText txtPhone;
    ImageView imgHidePassword;
    ImageView imgHideConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //References to View
        lblSignIn = (TextView) findViewById(R.id.lblSignIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtConfirmPassword = (EditText) findViewById(R.id.txtConfirmPassword);
        txtPhone =  (EditText) findViewById(R.id.txtPhone);
        imgHidePassword = (ImageView) findViewById(R.id.imgHidePassword);
        imgHideConfirmPassword = (ImageView) findViewById(R.id.imgHideConfirmPassword);

        lblSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
        imgHidePassword.setOnClickListener(this);
        imgHideConfirmPassword.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.lblSignIn:
//                Toast.makeText(getApplicationContext(), "Actoin work!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
                break;
            case R.id.btnSignUp:
                final String mobile = txtPhone.getText().toString();
                Intent intent = new Intent(SignUpActivity.this, OTPVerificationActivity.class);
                intent.putExtra("mobile", mobile);
                startActivity(intent);
                break;
            case R.id.imgHidePassword:
                Toast.makeText(getApplicationContext(), "Action imgHidePassword", Toast.LENGTH_LONG).show();
                if (showPassword){
                    showPassword = false;
                    txtPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    imgHidePassword.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                } else {
                    showPassword = true;
                    txtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    imgHidePassword.setImageResource(R.drawable.ic_baseline_visibility_24);
                }
                txtPassword.setSelection(txtPassword.length());
                break;
            case R.id.imgHideConfirmPassword:
                Toast.makeText(getApplicationContext(), "Action imgHideConfirmPassword", Toast.LENGTH_LONG).show();
                if (showConfirmPassword){
                    showConfirmPassword = false;
                    txtConfirmPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    imgHideConfirmPassword.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                } else {
                    showConfirmPassword = true;
                    txtConfirmPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    imgHideConfirmPassword.setImageResource(R.drawable.ic_baseline_visibility_24);
                }
                txtConfirmPassword.setSelection(txtConfirmPassword.length());
                break;
        }
    }
}