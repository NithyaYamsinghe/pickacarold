package com.example.pickacar.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pickacar.R;

public class PaymentHistory extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_history);
    }

    public void onClickDetails(View view) {
        Intent i = new Intent(this, Journey.class);
        startActivity(i);
    }
}
