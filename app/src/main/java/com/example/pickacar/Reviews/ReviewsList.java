package com.example.pickacar.Reviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pickacar.R;

public class ReviewsList extends AppCompatActivity {

    ListView reviewsList;

    String[] usernames = {"yasmikash", "tayl0r", "dotAdseli", "hirupiyumika", "nithee000"};

    String[] dates = {
            "12 Jan 2019",
            "20 Jan 2019",
            "12 Mar 2020",
            "17 Mar 2020",
            "18 Mar 2020"
    };

    String[] reviews = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint.",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews_list);
        setTitle("Reviews");

        reviewsList = findViewById(R.id.reviews_list);

        CustomAdaptor customAdaptor = new CustomAdaptor();
        reviewsList.setAdapter(customAdaptor);

    }

    public void showAddReview(View view) {
        Intent intent = new Intent(getApplicationContext(), AddReview.class);
        startActivity(intent);
    }

    class CustomAdaptor extends BaseAdapter {

        @Override
        public int getCount() {
            return reviews.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.custom_car_list_layout, null);

            TextView viewUsername = view.findViewById(R.id.username);
            TextView viewDate = view.findViewById(R.id.date_text);
            TextView viewReview = view.findViewById(R.id.review_text);

            viewUsername.setText(usernames[position]);
            viewDate.setText(dates[position]);
            viewReview.setText(reviews[position]);

            return view;
        }
    }

}
