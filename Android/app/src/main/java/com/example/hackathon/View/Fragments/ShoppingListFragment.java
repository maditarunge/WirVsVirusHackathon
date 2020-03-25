package com.example.hackathon.View.Fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.hackathon.Consts;
import com.example.hackathon.R;
import com.example.hackathon.View.Activity.CreateNewListActivity;
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

        Button btnNewList = (Button)rootView.findViewById(R.id.button_new_list);
        btnNewList.setOnClickListener(newListListener);

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

    private void newList()
    {
        Intent intent = new Intent(getActivity(), CreateNewListActivity.class);
        startActivity(intent);
    }

    private Button.OnClickListener newListListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            newList();
        }
    };
}
