package com.example.avion.gamesnewsp2.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.avion.gamesnewsp2.classes.Players;

import java.util.ArrayList;

public class PlayersAdapter extends RecyclerView.Adapter {
    public PlayersAdapter(Context context, ArrayList<Players> listaAux) {
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
    }
}
