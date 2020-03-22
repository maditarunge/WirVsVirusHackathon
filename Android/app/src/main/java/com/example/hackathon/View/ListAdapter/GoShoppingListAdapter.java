package com.example.hackathon.View.ListAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.hackathon.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class GoShoppingListAdapter extends BaseAdapter {

    Context context;
    List<Map<String, Object>> data;
    private static LayoutInflater inflater = null;
    private SimpleDateFormat dateFormatDate = new SimpleDateFormat("dd");
    private SimpleDateFormat dateFormatWeekday = new SimpleDateFormat("EEE");

    public GoShoppingListAdapter(Context context, List<Map<String, Object>> data) {
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
            vi = inflater.inflate(R.layout.list_item_go_shopping, null);

        String title = data.get(position).get("title").toString();
        String user = data.get(position).get("user").toString();
        Date date = (Date)data.get(position).get("date");

        TextView tvTitle = (TextView)vi.findViewById(R.id.tvTitle);
        TextView tvUser = (TextView)vi.findViewById(R.id.tvUser);
        TextView tvDate = (TextView)vi.findViewById(R.id.tvDate);
        TextView tvWeekday = (TextView)vi.findViewById(R.id.tvWeekday);

        tvTitle.setText(title);
        tvUser.setText(user);
        tvDate.setText(dateFormatDate.format(date));
        tvWeekday.setText(dateFormatWeekday.format(date));

        return vi;
    }
}

