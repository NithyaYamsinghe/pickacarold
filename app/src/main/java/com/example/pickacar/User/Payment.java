package com.example.pickacar.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pickacar.R;

public class Payment extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
    }

    public void onClickPayment(View view) {
        Intent i = new Intent(this, PaymentHistory.class);
        startActivity(i);
    }

    public void onClickUpdate(View view) {
        Intent intent = new Intent(this, Trip.class);
        startActivity(intent);
    }
}
