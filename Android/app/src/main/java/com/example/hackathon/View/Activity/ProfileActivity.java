package com.example.hackathon.View.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.hackathon.R;
import com.example.hackathon.View.Fragments.AccountFragment;

public class ProfileActivity extends AppCompatActivity {

    private static FragmentManager fragmentManager;
    public static Status status = Status.UNKNOWN;

    private View.OnClickListener onClickListenerAdd = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO MR 2020-04-14 1034: add implementation
            finish();
        }
    };

    private View.OnClickListener onClickListenerChange = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO MR 2020-04-14 1034: add implementation
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        fragmentManager = getSupportFragmentManager();

        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        Button btnConfirm = findViewById(R.id.button_save);
        switch (status)
        {
            case UNKNOWN:
                btnConfirm.setText(getResources().getString(R.string.profile_unknown));
                break;
            case ADD:
                btnConfirm.setText(getResources().getString(R.string.profile_new));
                btnConfirm.setOnClickListener(onClickListenerAdd);
                break;
            case CHANGE:
                btnConfirm.setText(getResources().getString(R.string.profile_change));
                btnConfirm.setOnClickListener(onClickListenerChange);
                break;
        }

        showFragment(new AccountFragment());
    }

    public static void showFragment(Fragment fragment)
    {
        fragmentManager
                .beginTransaction()
                .replace(R.id.account_fragment_container, fragment)
                .commit();
    }

    public enum Status
    {
        UNKNOWN,
        CHANGE,
        ADD
    }
}
