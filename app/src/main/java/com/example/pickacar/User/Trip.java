package com.example.pickacar.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pickacar.R;
import com.example.pickacar.User.Payment;

public class Trip extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);
    }

    public void onClickTrip(View view) {
        Intent i = new Intent(this, Payment.class);
        startActivity(i);
    }
}
