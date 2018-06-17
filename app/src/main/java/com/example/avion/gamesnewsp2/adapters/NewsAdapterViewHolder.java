package com.example.avion.gamesnewsp2.adapters;



import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.avion.gamesnewsp2.acitivities.MainActivity;
import com.example.avion.gamesnewsp2.acitivities.MainActivity.*;

import com.example.avion.gamesnewsp2.R;
import com.example.avion.gamesnewsp2.classes.News;
import com.example.avion.gamesnewsp2.fragments.FragmentContainer;

import java.util.ArrayList;

class NewsAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener /*implements View.OnClickListener*/{

    TextView title;
    ImageView images;
    TextView game;
    ArrayList<News> lista_completa;
    Context context;


    public NewsAdapterViewHolder(View itemView, ArrayList<News> lista_completa, Context context) {
        super(itemView);
        this.lista_completa = lista_completa;
        this.context = context;

        //codigo para hacer clicable el cardview
        itemView.setOnClickListener(this);


        game = (TextView) itemView.findViewById(R.id.news_game);
        title = (TextView) itemView.findViewById(R.id.news_title);
        images = (ImageView) itemView.findViewById(R.id.news_image);



    }

    public void onClick(View v) {
       // Toast.makeText(context,"Noticia añadida a favoritos", Toast.LENGTH_SHORT).show();
        int position = getAdapterPosition();
        News news = this.lista_completa.get(position);
       // favorite_news.add(this.lista_completa.get(position));
        //al dar click setear variables globales con los  valores recogidos
        //------------generals---------------
        MainActivity.gameStk = news.getGame();
        MainActivity.imagenStk = news.getCoverImage();
        MainActivity.desciptionStk = news.getDescription();
        MainActivity.bodyStk = news.getBody();
        System.out.println(MainActivity.bodyStk);

        FragmentTransaction fr = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
        fr.addToBackStack(null);
        fr.replace(R.id.fragment_padre,new FragmentContainer());

        fr.commit();



    }
}
