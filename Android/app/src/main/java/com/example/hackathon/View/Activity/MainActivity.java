package com.example.hackathon.View.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.hackathon.Consts;
import com.example.hackathon.R;
import com.example.hackathon.View.Fragments.GoShoppingFragment;
import com.example.hackathon.View.Fragments.HomeFragment;
import com.example.hackathon.View.Fragments.ProfileFragment;
import com.example.hackathon.View.Fragments.SettingsFragment;
import com.example.hackathon.View.Fragments.ShoppingListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LocationListener {

    boolean isNetworkEnabled = false;
    boolean isGPSEnabled = false;

    LocationManager locationManager;
    Location location;

    // minTime: minimum time interval between location updates, in milliseconds
    static final long MIN_TIME = 3000;
    // minDistance: minimum distance between location updates, in meters
    static final long MIN_DISTANCE = 5;

    final int MY_PERMISSIONS_REQUEST_LOCATIONS = 1;

    private static FragmentManager fragmentManager;
    private static BottomNavigationView navView;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    showFragment(new HomeFragment());
                    return true;
                case R.id.navigation_goShopping:
                    showFragment(new GoShoppingFragment());
                    return true;
                case R.id.navigation_shoppingList:
                    showFragment(new ShoppingListFragment());
                    return true;
                case R.id.navigation_profile:
                    showFragment(new ProfileFragment());
                    return true;
                case R.id.navigation_settings:
                    showFragment(new SettingsFragment());
                    return true;
            }
            return false;
        }
    };

    public MainActivity() {
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        initLocation();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);
        showFragment(new HomeFragment());
        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public static void showFragment(Fragment fragment)
    {
        fragmentManager
                .beginTransaction()
                .replace(R.id.parentFragmentContainer, fragment)
                .commit();
    }

    public static BottomNavigationView getNavView()
    {
        return navView;
    }

    private void newList(View view)
    {
        Intent intent = new Intent(this, CreateNewListActivity.class);
        startActivity(intent);
    }

    public Location initLocation() {
        try {
            locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

            List<String> providers = locationManager.getProviders(true);

            isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

            if (isNetworkEnabled || isGPSEnabled) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                    Manifest.permission.ACCESS_COARSE_LOCATION},
                            MY_PERMISSIONS_REQUEST_LOCATIONS);
                    return null;
                }

            }
            requestLocation();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATIONS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    requestLocation();
                } else {
                }
                return;
            }
        }
    }

    private void requestLocation() {
        if (isNetworkEnabled) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    MIN_TIME,
                    MIN_DISTANCE, this);
            location = locationManager
                    .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        } else if (isGPSEnabled) {
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    MIN_TIME,
                    MIN_DISTANCE, this);
            location = locationManager
                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        Consts.location = location;
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

}