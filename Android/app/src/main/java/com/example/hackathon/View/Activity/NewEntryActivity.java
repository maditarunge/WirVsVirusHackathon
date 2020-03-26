package com.example.hackathon.View.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;

import com.example.hackathon.R;
import com.example.hackathon.View.ListAdapter.DetailsAdapter;
import com.example.hackathon.View.ListAdapter.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewEntryActivity extends AppCompatActivity {

    private String item;
    private List<Pair<String, Boolean>> details = new ArrayList<>();

    public NewEntryActivity() {

    }

    public NewEntryActivity(String item, List<Pair<String, Boolean>> details)
    {
        this.item = item;
        this.details = details;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);

        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        Button btnCancel = (Button)findViewById(R.id.button_cancel);
        Button btnSave = (Button)findViewById(R.id.button_save);

        btnCancel.setOnClickListener(closeListener);
        btnSave.setOnClickListener(saveListener);

        setList(details);
    }

    public void setList(List<Pair<String, Boolean>> list)
    {
        ListView listview = (ListView) findViewById(R.id.lvDetails);
        listview.setAdapter(new DetailsAdapter(this, list));
    }

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

    public void close()
    {
        finish();
    }

    public void save()
    {
        //save();
        finish();
    }

//    public void select()
//    {
//
//    }
}
