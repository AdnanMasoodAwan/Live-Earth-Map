package com.example.live_earth_map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class BaseAdapter extends android.widget.BaseAdapter
{
    Context context;
    String ListIcons[];
    int Icons[];
    LayoutInflater layoutInflater;

    public BaseAdapter(Context context, String[] listIcons, int[] icons) {
        this.context = context;
        ListIcons = listIcons;
        Icons = icons;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return ListIcons.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        view = layoutInflater.inflate(R.layout.activity_custom_list_view,null);
        TextView text=(TextView) view.findViewById(R.id.T);
        ImageView imageView=(ImageView) view.findViewById(R.id.I);
        text.setText(ListIcons[i]);
        imageView.setImageResource(Icons[i]);
        return view;
    }
}
