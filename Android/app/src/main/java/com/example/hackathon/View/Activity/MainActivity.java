package com.example.hackathon.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.hackathon.R;
import com.example.hackathon.View.Fragments.GoShoppingFragment;
import com.example.hackathon.View.Fragments.HomeFragment;
import com.example.hackathon.View.Fragments.ProfileFragment;
import com.example.hackathon.View.Fragments.SettingsFragment;
import com.example.hackathon.View.Fragments.ShoppingListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

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

    public MainActivity()
    {
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
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

//    @Override
//    public void onSaveInstanceState(Bundle savedInstanceState) {
//        super.onSaveInstanceState(savedInstanceState);
//    }
//
//    @Override
//    public void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//    }

}