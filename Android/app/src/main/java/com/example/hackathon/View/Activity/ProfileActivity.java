package com.example.hackathon.View.Activity;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.hackathon.R;
import com.example.hackathon.View.Fragments.AccountFragment;

public class ProfileActivity extends AppCompatActivity {

    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        fragmentManager = getSupportFragmentManager();

        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        showFragment(new AccountFragment());
    }

    public static void showFragment(Fragment fragment)
    {
        fragmentManager
                .beginTransaction()
                .replace(R.id.account_fragment_container, fragment)
                .commit();
    }
}
