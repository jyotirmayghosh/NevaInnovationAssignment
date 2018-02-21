package com.example.jyotirmay.nevainnovationassignment;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.jyotirmay.nevainnovationassignment.com.example.jyotirmay.nevainnovationassignment.networkhandler.Adapter;
import com.example.jyotirmay.nevainnovationassignment.com.example.jyotirmay.nevainnovationassignment.networkhandler.BackgroundTask;
import com.example.jyotirmay.nevainnovationassignment.com.example.jyotirmay.nevainnovationassignment.networkhandler.DataBean;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<DataBean> dataBeans;
    TextView textView, msgTextView;
    private static ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        recyclerView=findViewById(R.id.recyclerView);
        textView=findViewById(R.id.msg);
        textView.setText(BackgroundTask.message);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        BackgroundTask task=new BackgroundTask(UserActivity.this);
        dataBeans=task.getUserDetail();

        Adapter adapter=new Adapter(dataBeans);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(UserActivity.this));
    }

    public static void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    public static void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
