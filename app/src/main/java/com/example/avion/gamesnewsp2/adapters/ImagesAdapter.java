package com.example.avion.gamesnewsp2.adapters;



import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.avion.gamesnewsp2.classes.News;

import java.util.ArrayList;

public class ImagesAdapter extends RecyclerView.Adapter {
    public ImagesAdapter(Context context, ArrayList<News> listaAux2) {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    } /*extends RecyclerView.Adapter<ImagesAdapterViewHolder>{


    ArrayList<News> news_lists;
    private Context context;

    public ImagesAdapter(Context context,ArrayList<News> news_lists) {
        this.news_lists = news_lists;
        this.context = context;
    }

    @NonNull
    @Override
    public ImagesAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View image_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_images,parent,false);
        return new ImagesAdapterViewHolder(image_view,news_lists,context);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesAdapterViewHolder holder, int position) {

        Picasso.with(context).load(news_lists.get(position).getCoverImage()).into(holder.imagenes);


    }

    @Override
    public int getItemCount() {
        return news_lists.size();
    }
    */
}
