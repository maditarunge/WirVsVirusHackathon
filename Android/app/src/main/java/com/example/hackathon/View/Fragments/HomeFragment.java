package com.example.hackathon.View.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.hackathon.R;
import com.example.hackathon.View.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private View rootView = null;

    private static View.OnClickListener mOnGoShoppingClickListenener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity.showFragment(new GoShoppingFragment());
        }
    };

    private View.OnClickListener mOnShoppingListClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity.showFragment(new ShoppingListFragment());
        }
    };

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ImageButton ibGoShopping = (ImageButton)rootView.findViewById(R.id.ibGoShopping);
        ibGoShopping.setOnClickListener(mOnGoShoppingClickListenener);
        ImageButton ibAddShoppingList = (ImageButton)rootView.findViewById(R.id.ibAddList);
        ibAddShoppingList.setOnClickListener(mOnShoppingListClickListener);


        Log.i("CREATED!", "Fragment is created");
        return rootView;
    }

}
