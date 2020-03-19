package com.example.pickacar.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.pickacar.R;

public class UserProfileActivity extends AppCompatActivity {

    Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // enable full screen
        setContentView(R.layout.activity_user_profile);


        updateBtn = findViewById(R.id.profile_update);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileActivity.this, DeleteUserProfileActivity.class);
                startActivity(intent);
            }
        });
    }



}
