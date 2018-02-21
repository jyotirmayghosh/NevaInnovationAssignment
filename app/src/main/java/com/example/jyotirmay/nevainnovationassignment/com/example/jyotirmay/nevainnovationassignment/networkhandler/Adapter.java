package com.example.jyotirmay.nevainnovationassignment.com.example.jyotirmay.nevainnovationassignment.networkhandler;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jyotirmay.nevainnovationassignment.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Jyotirmay on 06-Feb-18.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{

    ArrayList<DataBean> dataBeanArrayList=new ArrayList<>();

    public Adapter(ArrayList<DataBean> dataBeanArrayList)
    {
        this.dataBeanArrayList=dataBeanArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View listItemView=inflater.inflate(R.layout.user_profile_item,parent,false);
        MyViewHolder viewHolder =new MyViewHolder(listItemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DataBean bean=dataBeanArrayList.get(position);
        holder.nameTextView.setText(String.valueOf(bean.getName()));
        holder.skillsTextView.setText(String.valueOf(bean.getSkills()));
        holder.profileImageView.setImageURI(Uri.parse(bean.getImage()));
    }

    @Override
    public int getItemCount() {
        return dataBeanArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView, skillsTextView;
        CircleImageView profileImageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            nameTextView=itemView.findViewById(R.id.tvName);
            skillsTextView=itemView.findViewById(R.id.tvSkills);
            profileImageView=itemView.findViewById(R.id.imgProfile);
        }
    }
}
