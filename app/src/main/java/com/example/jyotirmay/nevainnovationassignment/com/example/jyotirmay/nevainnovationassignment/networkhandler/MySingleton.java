package com.example.jyotirmay.nevainnovationassignment.com.example.jyotirmay.nevainnovationassignment.networkhandler;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Jyotirmay on 06-Feb-18.
 */

public class MySingleton {

    private RequestQueue requestQueue;
    private static MySingleton mySingleton;
    public static Context contx;

    private MySingleton(Context context)
    {
        contx=context;
        requestQueue=getRequestQueue();
    }

    public static synchronized MySingleton getInstance(Context context)
    {
        if (mySingleton==null)
        {
            mySingleton=new MySingleton(context);
        }
        return mySingleton;
    }

    public RequestQueue getRequestQueue()
    {
        if (requestQueue==null)
        {
            requestQueue= Volley.newRequestQueue(contx.getApplicationContext());
        }
        return requestQueue;
    }


    public <T>void addRequest(Request<T> request)
    {
        requestQueue.add(request);
    }
}
