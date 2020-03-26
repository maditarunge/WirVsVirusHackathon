package com.example.hackathon.View.ListAdapter;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.hackathon.R;

import java.util.List;
import java.util.Map;

public class ListAdapter extends BaseAdapter {

    Context context;
    List<Pair<String, List<Pair<String, Boolean>>>> data;
    private static LayoutInflater inflater = null;

    public ListAdapter(Context context, List<Pair<String, List<Pair<String, Boolean>>>> data) {
        // TODO Auto-generated constructor stub
        this.context = context;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.list_item_new_list, null);

        StringBuilder sbDetails = new StringBuilder();
        for (Pair<String, Boolean> entry : data.get(position).second)
        {
            sbDetails.append(entry.first);
            sbDetails.append(": ");
            sbDetails.append(entry.second ? "Ja, " : "Nein, ");
        }
        sbDetails.setLength(sbDetails.length() - 2);

        TextView tvItem = (TextView)vi.findViewById(R.id.tvItem);
        TextView tvDetails = (TextView)vi.findViewById(R.id.tvDetails);

        tvItem.setText(data.get(position).first);
        tvDetails.setText(sbDetails.toString());

        return vi;
    }

}
