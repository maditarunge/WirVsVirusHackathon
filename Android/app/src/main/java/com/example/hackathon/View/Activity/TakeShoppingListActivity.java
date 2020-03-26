package com.example.hackathon.View.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hackathon.R;
import com.example.hackathon.View.MainActivity;

public class TakeShoppingListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_shopping_list);

        Button btnCancel = (Button)findViewById(R.id.button_cancel);
        Button btnTake = (Button)findViewById(R.id.button_take);

        btnCancel.setOnClickListener(closeListener);
        btnTake.setOnClickListener(takeListener);
    }

    private Button.OnClickListener closeListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            close();
        }
    };

    private Button.OnClickListener takeListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            take();
        }
    };

    public void close()
    {
        finish();
    }

    public void take()
    {
        //save();
        finish();
    }
}
