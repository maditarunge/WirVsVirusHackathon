package com.example.hackathon.View.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hackathon.R;
import com.example.hackathon.View.Others.DatePickerFragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CreateNewTourActivity extends AppCompatActivity implements DatePickerFragment.DatePickerResult{

    private SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd. MMMM yyyy", Locale.GERMANY);
    private Date date;
//    DateTimeFormatter formatter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_tour);
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        TextView tvDate = findViewById(R.id.tv_date);
        tvDate.setOnClickListener(onClickListenerDate);

        date = new Date();
        tvDate.setText(dateFormat.format(date));

        Button btnCancel = (Button)findViewById(R.id.button_cancel);
        Button btnSave = (Button)findViewById(R.id.button_save);

        btnCancel.setOnClickListener(closeListener);
        btnSave.setOnClickListener(saveListener);
    }

    View.OnClickListener onClickListenerDate = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            doDialogDatePicker();
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

    public void close()
    {
        finish();
    }

    public void save()
    {
        //save();
        finish();
    }


    @Override
    public void onDatePickerResult(Boolean canceled, int year, int month, int day) {
        TextView tvDate = findViewById(R.id.tv_date);
        if (!canceled)
        {
            date = new Date(year - 1900, month, day);
            tvDate.setText(dateFormat.format(date));
        }

    }

    public void doDialogDatePicker() {

        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.setOnDatePickerResultListener(this);
//        newFragment.setOnDatePickerResultListener((DatePickerFragment.DatePickerResult) shownFragment);
        newFragment.show(getFragmentManager(), "datePicker");
    }

//    public LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
//        return Instant.ofEpochMilli(dateToConvert.getTime())
//                .atZone(ZoneId.systemDefault())
//                .toLocalDate();
//    }
}
