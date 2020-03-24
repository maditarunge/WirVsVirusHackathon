package com.example.hackathon.View.Fragments;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hackathon.R;


public class SettingsFragment extends Fragment {

    private View rootView = null;

    public SettingsFragment() {
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        ShapeDrawable sd = new ShapeDrawable(new OvalShape());
        sd.setIntrinsicHeight(100);
        sd.setIntrinsicWidth(100);
        sd.getPaint().setColor(getResources().getColor(R.color.colorDarcBlue));
        ImageView iv = (ImageView) rootView.findViewById(R.id.ivProfile);
        iv.setBackground(sd);

        Log.i("CREATED!", "Fragment is created");
        return rootView;
    }
}
