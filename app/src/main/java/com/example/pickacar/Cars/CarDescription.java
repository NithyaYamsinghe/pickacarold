package com.example.pickacar.Cars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pickacar.R;
import com.example.pickacar.Reviews.ReviewsList;

public class CarDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_description);
    }

    public void showReviews(View view) {
        Intent intent = new Intent(getApplicationContext(), ReviewsList.class);
        startActivity(intent);
    }
}
