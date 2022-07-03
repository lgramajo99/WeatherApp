package com.example.weatherapplite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<String> names;

    CustomAdapter(Context context, int layout, ArrayList<String> names){
        this.context = context;
        this.layout = layout;
        this.names = names;
    }




    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int i) {
        return this.names.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        itemView = layoutInflater.inflate(R.layout.list_item, null);
        String currentName = names.get(i);

        TextView textView = itemView.findViewById(R.id.TextItemLista);
        textView.setText(currentName);

        return itemView;
    }
}
