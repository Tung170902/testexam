package com.example.testexam.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testexam.R;
import com.example.testexam.database.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<User> userList;

    public UserAdapter(Activity activity, List<User> userList) {
        this.activity = activity;
        this.userList = userList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = activity.getLayoutInflater().inflate(R.layout.item_user,parent,false);
        ProductHoder hoder = new ProductHoder(itemview);
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProductHoder hoder = (ProductHoder) holder;
        User model = userList.get(position);
        hoder.tvId.setText(model.id);
        hoder.tvName.setText(model.username);
        hoder.tvGender.setText(model.gender);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ProductHoder extends RecyclerView.ViewHolder{
        TextView tvId;
        TextView tvName;
        TextView tvGender;

        public ProductHoder (@NonNull View itemview){
            super(itemview);
            tvId = itemview.findViewById(R.id.tvID);
            tvName = itemview.findViewById(R.id.tvUserName);
            tvGender = itemview.findViewById(R.id.tvGender);
        }

    }

}
