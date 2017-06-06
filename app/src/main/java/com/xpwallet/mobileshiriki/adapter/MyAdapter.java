package com.xpwallet.mobileshiriki.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xpwallet.mobileshiriki.Common.DrawerMenu;
import com.xpwallet.mobileshiriki.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private List<DrawerMenu> drawerMenus;
    private String name;
    Context context;

    public MyAdapter(Context context, List<DrawerMenu> drItems, String name, String Email) {
        this.drawerMenus = drItems;
        this.name = name;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);

            ViewHolder vhItem = new ViewHolder(v, viewType);
            return vhItem;
        } else if (viewType == TYPE_HEADER) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header, parent, false);

            ViewHolder vhHeader = new ViewHolder(v, viewType);
            return vhHeader;
        }
        return null;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position == 1) {
            holder.layout.setBackgroundColor(context.getResources().getColor(R.color.skypeColor));
        }
        if (position == 2) {
            holder.layout.setBackgroundColor(context.getResources().getColor(R.color.menuGreen));
        }
        if (position == 3) {
            holder.layout.setBackgroundColor(context.getResources().getColor(R.color.menuBlue));
        }
        if (position == 4) {
            holder.layout.setBackgroundColor(context.getResources().getColor(R.color.menuOrange));
        }
        if (position == 5) {
            holder.layout.setBackgroundColor(context.getResources().getColor(R.color.menuYellow));
        }
        if (position == 6) {
            holder.layout.setBackgroundColor(context.getResources().getColor(R.color.menuRed));
        }
        if (position == 7) {
            holder.layout.setBackgroundColor(context.getResources().getColor(R.color.menuPurple));
        } if (position == 8) {
            holder.layout.setBackgroundColor(context.getResources().getColor(R.color.skypeColor));
        }
        if (position == 9) {
            holder.layout.setBackgroundColor(context.getResources().getColor(R.color.menuBlue));
        }

        if (holder.holder == 1) {
            DrawerMenu menu = drawerMenus.get(position - 1);
            holder.textView.setText(menu.getLabel());
            holder.imageView.setImageResource(menu.getImage());
        } else {
//            holder.Name.setText(name);
        }
    }


    @Override
    public int getItemCount() {
        return drawerMenus.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        int holder;
        TextView textView;
        ImageView imageView;
        LinearLayout layout;
        TextView Name;

        public ViewHolder(View itemView, int ViewType) {
            super(itemView);

            if (ViewType == TYPE_ITEM) {
                Typeface robotoBold = Typeface.createFromAsset(itemView.getResources().getAssets(), "robotoregular.ttf");
                textView = (TextView) itemView.findViewById(R.id.rowText);
                textView.setTypeface(robotoBold);
                imageView = (ImageView) itemView.findViewById(R.id.rowIcon);
                layout = (LinearLayout) itemView.findViewById(R.id.layout);
                holder = 1;
            } else {
                // Name = (TextView) itemView.findViewById(R.id.name);
                holder = 0;
            }
        }
    }

}
