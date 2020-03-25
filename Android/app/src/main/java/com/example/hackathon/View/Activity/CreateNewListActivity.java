package com.example.hackathon.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hackathon.R;

public class CreateNewListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_list);

        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        Button btnNewEntry = (Button)findViewById(R.id.button_new_entry);
        Button btnCancel = (Button)findViewById(R.id.button_cancel);
        Button btnSave = (Button)findViewById(R.id.button_save);

        btnNewEntry.setOnClickListener(newEntryListener);
        btnCancel.setOnClickListener(closeListener);
        btnSave.setOnClickListener(saveListener);
    }

    private Button.OnClickListener newEntryListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            newEntry();
        }
    };

    private Button.OnClickListener closeListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            close();
        }
    };

    private Button.OnClickListener saveListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            save();
        }
    };

    public void newEntry()
    {
        Intent intent = new Intent(this, NewEntryActivity.class);
        startActivity(intent);
    }

    public void close()
    {
        finish();
    }

    public void save()
    {
        //save();
        finish();
    }
}
