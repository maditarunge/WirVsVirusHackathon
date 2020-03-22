package com.example.hackathon.View.ListAdapter;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.hackathon.R;
import java.util.List;
import java.util.Map;

public class ShoppingListListAdapter extends BaseAdapter {

    Context context;
    List<Map<String, Object>> data;
    private static LayoutInflater inflater = null;

    public ShoppingListListAdapter(Context context, List<Map<String, Object>> data) {
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

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.list_item_shopping_list, null);

        String title = data.get(position).get("title").toString();
        String user = data.get(position).get("user").toString();

        TextView tvTitle = (TextView)vi.findViewById(R.id.tvTitle);
        TextView tvUser = (TextView)vi.findViewById(R.id.tvUser);

        tvTitle.setText(title);
        tvUser.setText(user);

        ShapeDrawable sd = new ShapeDrawable(new OvalShape());
        sd.setIntrinsicHeight(100);
        sd.setIntrinsicWidth(100);
        sd.getPaint().setColor(vi.getResources().getColor(R.color.colorBlue));
        ImageView iv = (ImageView) vi.findViewById(R.id.ivIcon);
        iv.setBackground(sd);

        return vi;
    }

}
