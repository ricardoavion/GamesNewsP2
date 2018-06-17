package com.example.avion.gamesnewsp2.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.avion.gamesnewsp2.R;
import com.example.avion.gamesnewsp2.acitivities.MainActivity;
import com.example.avion.gamesnewsp2.adapters.PlayersAdapter;
import com.example.avion.gamesnewsp2.classes.Players;

import java.util.ArrayList;


public class TopPlayers extends Fragment {


    RecyclerView recyclerView;
    ArrayList<Players> listaAux = new ArrayList<>();

    public TopPlayers() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_top_players, container, false);

        filtrado();
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_players);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        PlayersAdapter playersAdapter = new PlayersAdapter(getContext(),listaAux);//modifique esto
        recyclerView.setAdapter(playersAdapter);


        return view;
    }//oncreateview

    private void filtrado(){
        for(int i = 0; i < MainActivity.players_list.size(); i++){
            if(MainActivity.players_list.get(i).getGame().equals(MainActivity.gameStk)){
                listaAux.add(MainActivity.players_list.get(i));
            }
        }
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
