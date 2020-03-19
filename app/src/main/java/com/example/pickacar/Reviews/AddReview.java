package com.example.pickacar.Reviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pickacar.R;

public class AddReview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);
    }

    public void showUserReviews(View view) {
        Intent intent = new Intent(getApplicationContext(), UserReviews.class);
        startActivity(intent);
    }
}
