package com.example.hackathon.View.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hackathon.Consts;
import com.example.hackathon.R;
import com.example.hackathon.View.ListAdapter.GoShoppingListAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GoShoppingFragment extends Fragment {

    private View rootView = null;

    public GoShoppingFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_go_shopping, container, false);

        ListView listview = (ListView) rootView.findViewById(R.id.lvShopperList);
        try {
            List<Map<String, Object>> objects = prepareDemoList();
            listview.setAdapter(new GoShoppingListAdapter(getContext(), objects));
        } catch (Exception e) {
            e.printStackTrace();
        }


        Log.i("CREATED!", "Fragment is created");
        return rootView;
    }

    private List<Map<String, Object>> prepareDemoList()
    {
        List<Map<String, Object>> objects = new ArrayList<>();

        Date date01 = new Date(2020, 03, 24);
        Map<String, Object> map01 = new HashMap<>();
        map01.put(Consts.Indexer.title, "EDEKA Einkauf");
        map01.put(Consts.Indexer.user, Consts.TestData.username);
        map01.put(Consts.Indexer.date, date01);
        objects.add(map01);

        Date date02 = new Date(2020, 03, 28);
        Map<String, Object> map02 = new HashMap<>();
        map02.put(Consts.Indexer.title, "REWE Einkauf");
        map02.put(Consts.Indexer.user, Consts.TestData.username);
        map02.put(Consts.Indexer.date, date02);
        objects.add(map02);

        return objects;
    }
}
