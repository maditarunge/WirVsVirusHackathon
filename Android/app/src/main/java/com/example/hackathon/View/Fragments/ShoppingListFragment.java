package com.example.hackathon.View.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hackathon.Consts;
import com.example.hackathon.R;
import com.example.hackathon.View.ListAdapter.ShoppingListListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShoppingListFragment extends Fragment {

    private View rootView = null;

    public ShoppingListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_shopping_list, container, false);

        ListView listview = (ListView) rootView.findViewById(R.id.lvShoppingList);
        try {
            List<Map<String, Object>> objects = prepareDemoList();
            listview.setAdapter(new ShoppingListListAdapter(getContext(), objects));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i("CREATED!", "Fragment is created");
        return rootView;
    }

    private List<Map<String, Object>> prepareDemoList()
    {
        List<Map<String, Object>> objects = new ArrayList<>();

        Map<String, Object> map01 = new HashMap<>();
        map01.put(Consts.Indexer.title, "LIDL Einkauf");
        map01.put(Consts.Indexer.user, Consts.TestData.username);
        objects.add(map01);

        Map<String, Object> map02 = new HashMap<>();
        map02.put(Consts.Indexer.title, "ALDI Einkauf");
        map02.put(Consts.Indexer.user, Consts.TestData.username);
        objects.add(map02);

        return objects;
    }
}
