package com.apj.apjexam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class KBaseAdapter<T> extends BaseAdapter {
    protected List<T> mDataList;
    protected LayoutInflater mInflater;

    public KBaseAdapter(Context context, List<T> mDataList) {
        this.mInflater = LayoutInflater.from(context);
        this.mDataList = mDataList;
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return mDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
