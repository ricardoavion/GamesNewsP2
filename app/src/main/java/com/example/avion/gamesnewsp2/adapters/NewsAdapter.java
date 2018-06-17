package com.example.avion.gamesnewsp2.adapters;



import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.avion.gamesnewsp2.R;
import com.example.avion.gamesnewsp2.classes.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapterViewHolder>{

    ArrayList<News> news_list;
    private Context context;

    public NewsAdapter (Context context, ArrayList<News> news_list){
        this.news_list = news_list;
        this.context = context;
    }


    @NonNull
    @Override
    public NewsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View news_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_news, parent, false);
        return new NewsAdapterViewHolder(news_view,news_list,context);
    }


    @Override
    public void onBindViewHolder(@NonNull NewsAdapterViewHolder holder, int position){
        holder.game.setText(news_list.get(position).getGame());
        holder.title.setText(news_list.get(position).getTitle());
        //holder.image.setImageURI();
        Picasso.with(context).load(news_list.get(position).getCoverImage()).into(holder.images);
    }

    @Override
    public int getItemCount() {
        return news_list.size();
    }


}
