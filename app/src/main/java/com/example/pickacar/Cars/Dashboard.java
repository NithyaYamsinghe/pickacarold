package com.example.pickacar.Cars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pickacar.R;

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
