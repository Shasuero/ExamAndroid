package com.apj.apjexam.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.apj.apjexam.R;
import com.apj.apjexam.adapter.QueryListAdapter;
import com.apj.apjexam.bean.QueryItemBean;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;

import java.util.ArrayList;
import java.util.List;

public class QueryActivity extends BaseActivity {
    private ListView lvList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        initView();
        initData();
    }

    private void initView() {
        lvList = (ListView) findViewById(R.id.lv_data);
    }

    private void initData() {
        AVQuery<AVObject> query = new AVQuery<>("Test");
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                List<QueryItemBean> queryList = new ArrayList<QueryItemBean>();

                for (AVObject obj : list) {
                    QueryItemBean item = new QueryItemBean();
                    item.setValue1(obj.getString("key1"));
                    item.setValue2(obj.getString("key2"));
                    queryList.add(item);
                }

                lvList.setAdapter(new QueryListAdapter(QueryActivity.this, queryList));
            }
        });
    }
}
