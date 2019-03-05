package com.example.tim.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tim.R;

import java.util.ArrayList;
import java.util.List;

import com.example.tim.Model.MenuModel;

import de.hdodenhof.circleimageview.CircleImageView;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    Context context;
    List<MenuModel> menuModels;
    public MenuAdapter(Context context, List<MenuModel> menuModels){
        this.context = context;
        this.menuModels = menuModels;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item,viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
    viewHolder.onBind(menuModels.get(i));
    }

    @Override
    public int getItemCount() {
        return menuModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        CircleImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            image = itemView.findViewById(R.id.image);
        }
        public void onBind(MenuModel menu){
            tvName.setText(menu.getName());
            Glide.with(context).load(menu.getImage()).into(image);
        }
    }

}
