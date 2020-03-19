package com.example.pickacar.User;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pickacar.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    Button callSignUp, login_btn;
    TextInputLayout username, password;
    TextView headingText, subHeadingText;
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // enable full screen
        setContentView(R.layout.activity_login);


        // Hooks
        callSignUp = findViewById(R.id.signUp_screen);
        image = findViewById(R.id.login_image);
        username = findViewById(R.id.username_field);
        password = findViewById(R.id.password_field);
        headingText = findViewById(R.id.login_heading);
        subHeadingText = findViewById(R.id.login_subheading);
        login_btn = findViewById(R.id.signIn_button);


        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainDashboardActivity.class);
                Pair[] pairs = new Pair[7];

                pairs[0] = new Pair<View, String>(image, "logo_image");
                pairs[1] = new Pair<View, String>(headingText, "logo_text");
                pairs[2] = new Pair<View, String>(subHeadingText, "logo_subText");
                pairs[3] = new Pair<View, String>(username, "username_trans");
                pairs[4] = new Pair<View, String>(password, "password_trans");
                pairs[5] = new Pair<View, String>(login_btn, "signIn_btn_trans");
                pairs[6] = new Pair<View, String>(callSignUp, "already_signIn_trans");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, pairs);
                    startActivity(intent, options.toBundle());
                }


            }
        });

    }


    private Boolean validateUsername() {
        String val = username.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        if (val.isEmpty()) {
            username.setError("Field cannot be empty");
            return false;
        } else if (val.length() >= 15) {
            username.setError("Username too long");
            return false;
        } else if (!val.matches(noWhiteSpace)) {
            username.setError("White Spaces are not allowed");
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = password.getEditText().getText().toString();
        String passwordVal = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (val.isEmpty()) {
            password.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(passwordVal)) {
            password.setError("Password is too weak");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }


    //This function will execute when user click on Register Button
    public void loginUser(View view) {

        if (!validatePassword() | !validateUsername()) {
            return;
        }

        login_btn = findViewById(R.id.signIn_button);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainDashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}
