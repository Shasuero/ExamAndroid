package com.apj.apjexam.activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.apj.apjexam.R;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    private class ViewHolder{
        Button btnAdd;
        Button btnDelete;
        Button btnUpdate;
        Button btnQuery;
    }

    private ViewHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
    }

    private void initEvent() {
        holder.btnAdd.setOnClickListener(this);
        holder.btnDelete.setOnClickListener(this);
        holder.btnUpdate.setOnClickListener(this);
        holder.btnQuery.setOnClickListener(this);
    }

    private void initView() {
        holder = new ViewHolder();
        holder.btnAdd = (Button)findViewById(R.id.btn_add);
        holder.btnDelete = (Button) findViewById(R.id.btn_delete);
        holder.btnUpdate = (Button) findViewById(R.id.btn_update);
        holder.btnQuery = (Button) findViewById(R.id.btn_query);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add:
                startActivity(new Intent(this, AddActivity.class));
                break;
            case R.id.btn_delete:
                startActivity(new Intent(this, DeleteActivity.class));
                break;
            case R.id.btn_update:
                break;
            case R.id.btn_query:
                startActivity(new Intent(this, QueryActivity.class));
                break;
        }
    }
}
