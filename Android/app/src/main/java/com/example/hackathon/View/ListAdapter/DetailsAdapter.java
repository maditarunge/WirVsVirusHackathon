package com.example.hackathon.View.ListAdapter;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.hackathon.R;

import java.util.List;
import java.util.Map;

public class DetailsAdapter extends BaseAdapter {

    Context context;
    List<Pair<String, Boolean>> data;
    private static LayoutInflater inflater = null;

    public DetailsAdapter(Context context, List<Pair<String, Boolean>> data) {
        // TODO Auto-generated constructor stub
        this.context = context;
//        for(Map.Entry<String, Boolean> entry : data.entrySet())
//        {
//            this.data = new Pa
//        }
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.list_item_details, null);

        Switch swDetail = (Switch)vi.findViewById(R.id.swDetail);
        swDetail.setText(data.get(position).first);
        swDetail.setChecked(data.get(position).second);
        swDetail.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                data.set(position, new Pair<String, Boolean>(data.get(position).first, isChecked));
            }
        });

        return vi;
    }



}
