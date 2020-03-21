package com.example.hackathon.View.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hackathon.R;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {

    private View rootView = null;

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_profile, container, false);


        Log.i("CREATED!", "Fragment is created");
        return rootView;
    }
}
