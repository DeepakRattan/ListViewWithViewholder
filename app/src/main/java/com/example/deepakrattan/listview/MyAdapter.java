package com.example.deepakrattan.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by deepak.rattan on 3/13/2017.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SingleRow> singleRowArrayList;
    private LayoutInflater inflater;

    public MyAdapter(Context context, ArrayList<SingleRow> singleRowArrayList) {
        this.context = context;
        this.singleRowArrayList = singleRowArrayList;
    }

    static class ViewHolder {
        TextView txtName;
        TextView txtDesc;
        ImageView imageView;
    }

    @Override
    public int getCount() {
        return singleRowArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return singleRowArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

   /* @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.single_row, viewGroup, false);

        //Finding all the views of single_row.xml
        TextView txtName = (TextView) view.findViewById(R.id.txtName);
        TextView txtDesc = (TextView) view.findViewById(R.id.txtDesc);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

        //Getting data from ArrayList
        SingleRow singleRow = singleRowArrayList.get(i);
        String name = singleRow.getName();
        String desc = singleRow.getDesc();
        int image = singleRow.getImage();

        //Setting data inside the views
        txtName.setText(name);
        txtDesc.setText(desc);
        imageView.setImageResource(image);

        return view;
    }*/


    //Here we are implementing the view-holder pattern

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.single_row,null);
            viewHolder = new ViewHolder();
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.txtDesc = (TextView) convertView.findViewById(R.id.txtDesc);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //Getting data from ArrayList
        SingleRow singleRow = singleRowArrayList.get(i);
        String name = singleRow.getName();
        String desc = singleRow.getDesc();
        int image = singleRow.getImage();

        //Setting data inside the views
        viewHolder.txtName.setText(name);
        viewHolder.txtDesc.setText(desc);
        viewHolder.imageView.setImageResource(image);

        return convertView;
    }
}
