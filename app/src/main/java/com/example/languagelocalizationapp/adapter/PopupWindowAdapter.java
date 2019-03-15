package com.example.languagelocalizationapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.languagelocalizationapp.R;
import com.example.languagelocalizationapp.model.CountryModel;

import java.util.List;

/**
 * Created by geet-pc on 14/3/19.
 */

public class PopupWindowAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    List<CountryModel> itemList;
    Context ctx;

    public PopupWindowAdapter(Context context, List<CountryModel> items){
        this.ctx=context;
        layoutInflater=LayoutInflater.from(context);
        this.itemList=items;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public CountryModel getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.layout_menu, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.textTitle.setText(itemList.get(i).getTextTitle());

        if(i==0){
            viewHolder.viewLine.setVisibility(View.INVISIBLE);
        }else {
            viewHolder.viewLine.setVisibility(View.VISIBLE);
        }
        return view;
    }
     class ViewHolder{
        TextView textTitle;
        View viewLine;
        public ViewHolder(View view){
            textTitle=(TextView)view.findViewById(R.id.txtTitle);
            viewLine=(View) view.findViewById(R.id.viewLine);
        }
    }
}
