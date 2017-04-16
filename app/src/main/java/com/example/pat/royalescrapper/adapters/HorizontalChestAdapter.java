package com.example.pat.royalescrapper.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pat.royalescrapper.R;
import com.example.pat.royalescrapper.model.Chest;

import java.util.List;

/**
 * Created by Pat on 16/04/2017.
 */

public class HorizontalChestAdapter extends RecyclerView.Adapter<HorizontalChestAdapter.MyViewHolder> {

    private List<Chest> horizontalList;
    private Context context;

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView chestimage;
        TextView chestposition;

        MyViewHolder(View view) {
            super(view);
            chestimage = (ImageView) view.findViewById(R.id.chestimage);
            chestposition = (TextView) view.findViewById(R.id.chestposition);
        }
    }


    public HorizontalChestAdapter(Context context, List<Chest> horizontalList) {
        this.context = context;
        this.horizontalList = horizontalList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chest_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Glide.with(context)
                .load("http://statsroyale.com/images/chests/"
                        .concat(horizontalList.get(position).getName().replace(" Chest", ""))
                        .concat(".png"))
                .centerCrop()
                .crossFade()
                .into(holder.chestimage);

        String signedChest = String.valueOf(horizontalList.get(position).getPosition());
        if (!signedChest.equals("0")&&!signedChest.startsWith("-")) {
            signedChest = "+".concat(signedChest);
        }
        holder.chestposition.setText(signedChest);
    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }
}