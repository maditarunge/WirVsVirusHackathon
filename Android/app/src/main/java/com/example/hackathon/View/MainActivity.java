package com.example.hackathon.View;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hackathon.View.Fragments.GoShoppingFragment;
import com.example.hackathon.View.Fragments.HomeFragment;
import com.example.hackathon.R;
import com.example.hackathon.View.Fragments.ProfileFragment;
import com.example.hackathon.View.Fragments.SettingsFragment;
import com.example.hackathon.View.Fragments.ShoppingListFragment;

public class MainActivity extends AppCompatActivity {

    private static FragmentManager fragmentManager;
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

    public MainActivity()
    {
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragment(new HomeFragment());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public static void showFragment(Fragment fragment)
    {
        fragmentManager
                .beginTransaction()
                .replace(R.id.parentFragmentContainer, fragment)
                .commit();
    }

}
