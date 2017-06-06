package com.xpwallet.mobileshiriki.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.xpwallet.mobileshiriki.R;

import java.util.List;

public class SpinerAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<String> addItems;
    int selectedItemposition;

    public SpinerAdapter(Context context, List<String> addItems) {
        this.context = context;
        this.addItems = addItems;
    }

    public SpinerAdapter(Context context, List<String> addItems, int selectedItemposition) {
        this.context = context;
        this.addItems = addItems;
        if (selectedItemposition == -1) {
            addItems.remove(0);
            this.selectedItemposition = -1;
        } else {
            this.selectedItemposition = selectedItemposition;
        }
    }

    @Override
    public int getCount() {
        return addItems.size();
    }

    @Override
    public Object getItem(int location) {
        return addItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.spinnerlayout, null);
        }
        TextView spinerItem = (TextView) convertView.findViewById(R.id.spinnerItem);
        ImageView listCheck = (ImageView) convertView.findViewById(R.id.spinnerCheck);
        listCheck.setVisibility(View.INVISIBLE);
        if (position == selectedItemposition) {
            listCheck.setVisibility(View.VISIBLE);
        }
        spinerItem.setText(addItems.get(position));
        return convertView;
    }

    public void setSelectedItem(int position) {
        this.selectedItemposition = position;
    }

    public int getSelectedItem() {
        return selectedItemposition;
    }


}
