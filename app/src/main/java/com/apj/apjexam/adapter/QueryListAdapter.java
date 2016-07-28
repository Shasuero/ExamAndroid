package com.apj.apjexam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.apj.apjexam.R;
import com.apj.apjexam.bean.QueryItemBean;

import java.util.List;

public class QueryListAdapter extends BaseAdapter {
    private List<QueryItemBean> mDataList;
    private LayoutInflater mInflater;
    private class ViewHolder{
        TextView value1;
        TextView value2;
    }

    public QueryListAdapter(Context context, List<QueryItemBean> list) {
        this.mDataList = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            view = mInflater.inflate(R.layout.activity_query_item, viewGroup, false);
            holder.value1 = (TextView) view.findViewById(R.id.tv_value1);
            holder.value2 = (TextView) view.findViewById(R.id.tv_value2);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        QueryItemBean item = mDataList.get(i);
        holder.value1.setText(item.getValue1());
        holder.value2.setText(item.getValue2());

        return view;
    }
}
