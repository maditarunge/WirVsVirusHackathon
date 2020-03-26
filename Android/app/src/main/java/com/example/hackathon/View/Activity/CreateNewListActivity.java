package com.example.hackathon.View.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hackathon.Consts;
import com.example.hackathon.R;
import com.example.hackathon.View.ListAdapter.GoShoppingListAdapter;
import com.example.hackathon.View.ListAdapter.ListAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        setList(prepareDemoList());

        ListView listView = (ListView) findViewById(R.id.lvList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), NewEntryActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setList(List<Pair<String, List<Pair<String, Boolean>>>> list)
    {
        ListView listview = (ListView) findViewById(R.id.lvList);
        listview.setAdapter(new ListAdapter(this, list));
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

    private List<Pair<String, List<Pair<String, Boolean>>>> prepareDemoList()
    {
        List<Pair<String, List<Pair<String, Boolean>>>> objects = new ArrayList<>();

        List<Pair<String, Boolean>> list01 = new ArrayList<>();
        list01.add(new Pair<String, Boolean>("Bio", true));
        list01.add(new Pair<String, Boolean>("Glutenfrei", false));
        objects.add(new Pair<String, List<Pair<String, Boolean>>>("Milch", list01));

        List<Pair<String, Boolean>> list02 = new ArrayList<>();
        list02.add(new Pair<String, Boolean>("Bio", false));
        list02.add(new Pair<String, Boolean>("Glutenfrei", true));
        objects.add(new Pair<String, List<Pair<String, Boolean>>>("Spaghetti", list02));

        return objects;
    }
}
