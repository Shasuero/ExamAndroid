package com.apj.apjexam.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.apj.apjexam.R;
import com.apj.apjexam.bean.QueryItemBean;

import java.util.List;

public class QueryListAdapter extends KBaseAdapter<QueryItemBean> {
    private class ViewHolder{
        TextView etValue1;
        TextView etValue2;
    }

    public QueryListAdapter(Context context, List<QueryItemBean> mDataList) {
        super(context, mDataList);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            view = mInflater.inflate(R.layout.activity_query_item, viewGroup, false);
            holder.etValue1 = (TextView) view.findViewById(R.id.tv_value1);
            holder.etValue2 = (TextView) view.findViewById(R.id.tv_value2);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        QueryItemBean item = mDataList.get(i);
        holder.etValue1.setText(item.getValue1());
        holder.etValue2.setText(item.getValue2());


        return view;
    }
}
