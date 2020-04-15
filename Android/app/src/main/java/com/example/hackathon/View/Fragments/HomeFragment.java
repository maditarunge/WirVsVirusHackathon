package com.example.hackathon.View.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.hackathon.R;
import com.example.hackathon.View.Activity.MainActivity;


public class HomeFragment extends Fragment /*implements OnMapReadyCallback*/ {

    private View rootView = null;

    private static View.OnClickListener mOnGoShoppingClickListenener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            View view = MainActivity.getNavView().findViewById(R.id.navigation_goShopping);
            view.performClick();
        }
    };

    private View.OnClickListener mOnShoppingListClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            View view = MainActivity.getNavView().findViewById(R.id.navigation_shoppingList);
            view.performClick();
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

        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        childFragTrans.replace(R.id.mapFrame, new MapsFragment()).commit();
        Log.i("CREATED!", "Fragment is created");
        return rootView;
    }
}
