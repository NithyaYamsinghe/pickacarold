package com.example.pickacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setTitle("Dashboard");
    }

    public void showCarList(View view) {
        Intent intent = new Intent(getApplicationContext(), SelectCar.class);
        startActivity(intent);
    }
}
