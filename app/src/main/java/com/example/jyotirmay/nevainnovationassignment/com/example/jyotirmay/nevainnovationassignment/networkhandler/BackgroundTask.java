package com.example.jyotirmay.nevainnovationassignment.com.example.jyotirmay.nevainnovationassignment.networkhandler;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jyotirmay.nevainnovationassignment.UserActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Jyotirmay on 06-Feb-18.
 */

public class BackgroundTask {

    Context context;
    ArrayList<DataBean> dataBeanArrayList=new ArrayList<>();
    String server_url="https://test-api.nevaventures.com/";
    public static String message="";

    public BackgroundTask(Context context)
    {
        this.context=context;
    }

    public ArrayList<DataBean> getUserDetail()
    {
        UserActivity.showpDialog();
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, server_url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray jsonArray=null;
                        try {
                            jsonArray=response.getJSONArray("data");
                            for (int i=0; i<jsonArray.length();i++)
                            {
                                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                                DataBean bean=new DataBean();
                                if (jsonObject.has("name")) {
                                    bean.setName(jsonObject.getString("name"));
                                    bean.setSkills(jsonObject.getString("skills"));
                                    bean.setImage(jsonObject.getString("image"));
                                }
                                dataBeanArrayList.add(bean);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        UserActivity.hidepDialog();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError e) {
                message=e.getMessage();
                e.printStackTrace();
                UserActivity.hidepDialog();
            }
        });
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleton.getInstance(context).addRequest(jsonObjectRequest);
        return dataBeanArrayList;
    }
}
