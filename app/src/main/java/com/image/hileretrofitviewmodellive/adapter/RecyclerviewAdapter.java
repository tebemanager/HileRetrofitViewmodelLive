package com.image.hileretrofitviewmodellive.adapter;

import android.content.ClipData;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.image.hileretrofitviewmodellive.R;
import com.image.hileretrofitviewmodellive.module.ItemsItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charles Raj I on 26/09/21.
 *
 * @author Charles Raj I
 */
public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>{

    List<ItemsItem> itemList;

    public RecyclerviewAdapter() {
        itemList = new ArrayList<>();
    }

    public void setItemList(List<ItemsItem> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemsItem item = itemList.get(position);

        Glide.with(holder.imageView).load(item.getOwner().getAvatarUrl()).into(holder.imageView);
        holder.textView.setText(item.getName());
        holder.textView2.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return itemList==null?0: itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        TextView textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textview);
            textView2 = itemView.findViewById(R.id.textview2);
        }
    }
}
