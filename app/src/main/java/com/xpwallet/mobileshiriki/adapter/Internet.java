package com.xpwallet.mobileshiriki.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.xpwallet.mobileshiriki.R;
import com.xpwallet.mobileshiriki.model_class.BeanClass;

import java.util.ArrayList;

public class Internet extends ArrayAdapter<BeanClass> {

    private ArrayList<BeanClass> objects;
    private Activity activity;
    private TextView durationvalue;

    public Internet(Activity activity, int resourceId,
                    ArrayList<BeanClass> objects) {
        super(activity, resourceId, objects);
        this.objects = objects;
        this.activity = activity;
    }





    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater=(LayoutInflater) activity.getSystemService(  Context.LAYOUT_INFLATER_SERVICE );
        View row=inflater.inflate(R.layout.internet_adapter, parent, false);
        TextView label=(TextView)row.findViewById(R.id.duration_text);
        label.setText(objects.get(position).getDuration());

        if (position == 0) {//Special style for dropdown header
        }

        return row;
    }

}