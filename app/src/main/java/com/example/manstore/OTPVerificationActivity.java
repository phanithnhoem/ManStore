package com.example.manstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OTPVerificationActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtOTPOne, txtOTPTwo, txtOTPThree, txtOTPFour;
    private TextView lblResendOTP;

    //True after 60 seconds
    private boolean resendEnabled = false;

    //Resend time in seconds
    private int resendTime = 60;

    private int selectedOTPPosition = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);

        final Button btnVerify = (Button) findViewById(R.id.btnVerify);
        final TextView otpMobile = (TextView) findViewById(R.id.otpMobile);

        //Getting mobile from sign up activity
        final String getMobile = getIntent().getStringExtra("mobile");

        //Setting mobile to Text View
        otpMobile.setText(getMobile);

        txtOTPOne = (EditText) findViewById(R.id.txtOTPOne);
        txtOTPTwo = (EditText) findViewById(R.id.txtOTPTwo);
        txtOTPThree = (EditText) findViewById(R.id.txtOTPThree);
        txtOTPFour = (EditText) findViewById(R.id.txtTOPFour);

        lblResendOTP = (TextView) findViewById(R.id.lblResendOTP);
        txtOTPOne.addTextChangedListener(textWatcher);
        txtOTPTwo.addTextChangedListener(textWatcher);
        txtOTPThree.addTextChangedListener(textWatcher);
        txtOTPFour.addTextChangedListener(textWatcher);

        btnVerify.setOnClickListener(this);

        //By default open keyboard at txtOTPOne
        showKeyBoard(txtOTPOne);

        //Start resend count down timer
        startCountDownTimer();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.lblResendOTP:
                if (resendEnabled){
                    //Handle resend code here

                    //start new resend count down timer
                    startCountDownTimer();
                }

                break;
            case R.id.btnVerify:
                final String generateOTP = txtOTPOne.getText().toString() + txtOTPTwo.getText().toString() + txtOTPThree.getText().toString() + txtOTPFour.getText().toString();
                if (generateOTP.length() == 4){
                    //Handle OTP Verification here

                }
                startActivity(new Intent(OTPVerificationActivity.this, MainActivity.class));
                break;
        }
    }

    private void showKeyBoard(EditText txtOTP){
        txtOTP.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(txtOTP, inputMethodManager.SHOW_IMPLICIT);
    }

    private void startCountDownTimer(){
        resendEnabled = false;
        lblResendOTP.setTextColor(Color.parseColor("#99000000"));

        new CountDownTimer(resendTime * 1000, 1000){

            @Override
            public void onTick(long l) {
                lblResendOTP.setText("Resend Code ("+(l/1000)+")");
            }

            @Override
            public void onFinish() {
                resendEnabled = true;
                lblResendOTP.setText("Resend Code");
                lblResendOTP.setTextColor(getResources().getColor(R.color.primaryColor));
            }
        }.start();
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.length() > 0){
                if(selectedOTPPosition == 0){
                    selectedOTPPosition =1;
                    showKeyBoard(txtOTPTwo);
                }else if(selectedOTPPosition == 1){
                    selectedOTPPosition =2;
                    showKeyBoard(txtOTPThree);
                }else if (selectedOTPPosition == 2){
                    selectedOTPPosition =3;
                    showKeyBoard(txtOTPFour);
                }
            }

        }
    };

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(keyCode == event.KEYCODE_DEL){
            if (selectedOTPPosition == 3){
                selectedOTPPosition = 2;
                showKeyBoard(txtOTPThree);
            } else if (selectedOTPPosition == 2){
                selectedOTPPosition = 1;
                showKeyBoard(txtOTPTwo);
            }else if (selectedOTPPosition == 1){
                selectedOTPPosition = 1;
                showKeyBoard(txtOTPOne);
            }
            return true;
        } else {
            return super.onKeyUp(keyCode, event);
        }
    }
}