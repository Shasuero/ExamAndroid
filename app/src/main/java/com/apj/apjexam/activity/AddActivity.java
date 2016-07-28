package com.apj.apjexam.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.apj.apjexam.R;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {
    private class ViewHolder {
        EditText value1;
        EditText value2;
        Button add;
    }

    private ViewHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        initView();
        initEvent();
    }

    private void initEvent() {
        holder.add.setOnClickListener(this);
    }

    private void initView() {
        holder = new ViewHolder();
        holder.value1 = (EditText) findViewById(R.id.et_value1);
        holder.value2 = (EditText) findViewById(R.id.et_value2);
        holder.add = (Button) findViewById(R.id.btn_add);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                String value1 = holder.value1.getText().toString();
                String value2 = holder.value2.getText().toString();

                AVObject object = new AVObject("Test");
                object.put("key1", value1);
                object.put("key2", value2);
                object.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(AVException e) {
                        if (null != e) {
                            Toast.makeText(AddActivity.this, "保存数据出错e:" + e, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(AddActivity.this, "保存数据成功", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
        }
    }
}
