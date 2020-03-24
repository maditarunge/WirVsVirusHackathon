package com.example.hackathon.View.Fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.hackathon.View.Activity.MapsActivity;
import com.example.hackathon.R;
import com.example.hackathon.View.MainActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class HomeFragment extends Fragment implements OnMapReadyCallback {

    private View rootView = null;
    private MapView mapView = null;
    private GoogleMap gmap;

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

        mapView = (MapView)rootView.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

//        Intent firstpage= new Intent(getActivity(),MapsActivity.class);
//        getActivity().startActivity(firstpage);

        Log.i("CREATED!", "Fragment is created");
        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng me = new LatLng(50.7737129,6.1100725);
        gmap = googleMap;
        gmap.getUiSettings().setZoomControlsEnabled(true);
        gmap.addMarker(new MarkerOptions().position(me));
        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(me, 10));
    }
}
