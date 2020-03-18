package com.example.pickacar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectCar extends AppCompatActivity {


    ListView carsList;

    int[] carImages = {
            R.drawable.allion,
            R.drawable.axela_3,
            R.drawable.corolla_121,
            R.drawable.corolla_141,
            R.drawable.fielder_141,
            R.drawable.mitsubishi_lancer,
            R.drawable.mitsubishi_montero,
            R.drawable.mitsubishi_outlander,
            R.drawable.montero_sport,
            R.drawable.nissan_nv200,
            R.drawable.premio,
            R.drawable.sportage,
            R.drawable.suzuki_vitara,
            R.drawable.tiida_latio,
            R.drawable.toyota_corolla_axio,
            R.drawable.vitz_yaris,
            R.drawable.viva_elite,
            R.drawable.wagon_r,
            R.drawable.x_trial,
            R.drawable.ford_fiesta,
            R.drawable.mazda_2
    };

    String[] brandNames = {
            "Allion",
            "Alexa 3",
            "Corolla 121",
            "Corolla 141",
            "Fielder 141",
            "Mitsubishi Lancer",
            "Mitsubishi Montero",
            "Mitsubishi Outlander",
            "Montero Sport",
            "Nissan NV 200",
            "Premio",
            "Sportage",
            "Suzuki Vitara",
            "Tiida Latio",
            "Toyota Corolla Axio",
            "Vitz Yaris",
            "Viva Elite",
            "Wagon R",
            "X Trial",
            "Ford Fiesta",
            "Mazda 2"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_car);
        setTitle("Select A Car");


        carsList = findViewById(R.id.cars_list);

        CustomAdaptor customAdaptor = new CustomAdaptor();
        carsList.setAdapter(customAdaptor);

        carsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), CarDescription.class);
                startActivity(intent);
            }
        });


    }

    class CustomAdaptor extends BaseAdapter {

        @Override
        public int getCount() {
            return carImages.length;
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
            View view = getLayoutInflater().inflate(R.layout.custom_car, null);
            ImageView car = view.findViewById(R.id.car);
            TextView names = view.findViewById(R.id.brand_name);

            car.setImageResource(carImages[position]);
            names.setText(brandNames[position]);

            return view;
        }
    }

}
