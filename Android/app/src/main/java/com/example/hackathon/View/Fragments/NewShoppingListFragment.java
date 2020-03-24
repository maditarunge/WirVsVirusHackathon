package com.example.hackathon.View.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hackathon.R;


public class NewShoppingListFragment extends Fragment {

    private View rootView = null;

    public NewShoppingListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_new_shopping_list, container, false);


        Log.i("CREATED!", "Fragment is created");
        return rootView;
    }
}
