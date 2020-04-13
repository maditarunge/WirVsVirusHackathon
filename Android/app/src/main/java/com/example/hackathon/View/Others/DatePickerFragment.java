package com.example.hackathon.View.Others;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    public interface DatePickerResult {
        void onDatePickerResult(Boolean canceled, int year, int month, int day);
    }

    Boolean cancel = false;
    int year;
    int month;
    int day;

    DatePickerResult datePickerResult;

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        //setCancelable(false);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void setOnDatePickerResultListener(DatePickerResult call) {
        datePickerResult = call;
    }

    public void onCancel(DialogInterface dialog) {
//        Toast.makeText(getActivity(),"canceled", Toast.LENGTH_SHORT).show();
        cancel = true;
    }
    public void onDismiss(DialogInterface dialog) {
//        Toast.makeText(getActivity(),"dismissed, cancel "+cancel+" day "+day, Toast.LENGTH_SHORT).show();
        if (datePickerResult!=null)
            datePickerResult.onDatePickerResult(cancel, year, month, day);
    }

    public void onDateSet(DatePicker view, int y, int m, int d) {
        year = y; month = m; day = d;
//        Toast.makeText(getActivity(),"set day"+day, Toast.LENGTH_SHORT).show();
    }
}


