package com.example.pickacar.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.pickacar.HelperClasses.FeaturedAdapter;
import com.example.pickacar.HelperClasses.FeaturedHelperClass;
import com.example.pickacar.HelperClasses.MostViewedAdapter;
import com.example.pickacar.HelperClasses.MostViewedHelperClass;
import com.example.pickacar.R;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainDashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView featuredRecycler, mostViewedRecycler;


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // enable full screen
        setContentView(R.layout.activity_main_dashboard);


        // Hooks
        mostViewedRecycler = findViewById(R.id.mostViewedRecycler);
        featuredRecycler = findViewById(R.id.featured_recycler);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.tool_bar);


        // Tool bar
        setSupportActionBar(toolbar);

        // navigation DrawerMenu

        // Hide or show the items
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(false); // Make the logout initially invisible
        menu.findItem(R.id.nav_profile).setVisible(false); // Make the profile initially invisible

        navigationView.bringToFront(); // Make the drawer clickable
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        // Clickable navigation
        navigationView.setNavigationItemSelectedListener(this);


        navigationView.setCheckedItem(R.id.nav_home); // by default select the home item of the navigation drawer


        // Recycler View
        featuredRecycler();
        mostViewedRecycler();

    }

    private void mostViewedRecycler() {

        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<MostViewedHelperClass> mostViewedCars = new ArrayList<>();
        mostViewedCars.add(new MostViewedHelperClass(R.drawable.mitsubishi_outlander, "Toyota Swift", "uhuigktrrlyktou67uk67il67ul"));
        mostViewedCars.add(new MostViewedHelperClass(R.drawable.mitsubishi_outlander, "Toyota Swift", "uhuigktrrlyktou67uk67il67ul"));
        mostViewedCars.add(new MostViewedHelperClass(R.drawable.mitsubishi_outlander, "Toyota Swift", "uhuigktrrlyktou67uk67il67ul"));
        mostViewedCars.add(new MostViewedHelperClass(R.drawable.mitsubishi_outlander, "Toyota Swift", "uhuigktrrlyktou67uk67il67ul"));
        adapter = new MostViewedAdapter(mostViewedCars);
        mostViewedRecycler.setAdapter(adapter);
    }


    private void featuredRecycler() {


        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<FeaturedHelperClass> featuredCars = new ArrayList<>();
        featuredCars.add(new FeaturedHelperClass(R.drawable.mitsubishi_outlander, "Toyota Swift", "uhuigktrrlyktou67uk67il67ul"));
        featuredCars.add(new FeaturedHelperClass(R.drawable.mitsubishi_lancer, "Toyota Swift", "uhuigktrrlyktou67uk67il67ul"));
        featuredCars.add(new FeaturedHelperClass(R.drawable.mitsubishi_montero, "Toyota Swift", "uhuigktrrlyktou67uk67il67ul"));
        featuredCars.add(new FeaturedHelperClass(R.drawable.montero_sport, "Toyota Swift", "uhuigktrrlyktou67uk67il67ul"));
        adapter = new FeaturedAdapter(featuredCars);
        featuredRecycler.setAdapter(adapter);


    }

    // To prevent closing app after click back button

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        // Get the menu item
        switch (item.getItemId()) {
            case R.id.nav_home:
                break;
            case R.id.nav_profile:
                Intent intent = new Intent(MainDashboardActivity.this, UserProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show(); // Add toast notification when click share
                break;
            case R.id.nav_login:
//                Intent intent2 = new Intent(MainDashboardActivity.this, LoginActivity.class);
//                startActivity(intent2);
                Toast.makeText(this, "Logged In", Toast.LENGTH_SHORT).show(); // Add toast notification when click login
                Menu menu = navigationView.getMenu();
                menu.findItem(R.id.nav_logout).setVisible(true); // Make the logout initially visible
                menu.findItem(R.id.nav_profile).setVisible(true); // Make the profile initially visible
                break;
            case R.id.nav_logout:
                Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show(); // Add toast notification when click logout
                Menu menu2 = navigationView.getMenu();
                menu2.findItem(R.id.nav_login).setVisible(true); // Make the login  visible after logout
                menu2.findItem(R.id.nav_logout).setVisible(false); // Make the logout  invisible after logout
                menu2.findItem(R.id.nav_profile).setVisible(false); // Make the profile invisible after logout
                break;


        }

        drawerLayout.closeDrawer(GravityCompat.START); // To close the drawer when one item is selected
        return true;
    }


}