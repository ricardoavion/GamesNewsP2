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
import com.example.avion.gamesnewsp2.adapters.ImagesAdapter;
import com.example.avion.gamesnewsp2.classes.News;
import java.util.ArrayList;



public class Images extends Fragment {
    RecyclerView recyclerView;
    ArrayList<News> listaAux2 = new ArrayList<>();


    public Images() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_images, container, false);

        filtrado();
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_images);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ImagesAdapter imagesAdapter  = new ImagesAdapter(getContext(),listaAux2);
        recyclerView.setAdapter(imagesAdapter);


        return view;
    }

    private void filtrado(){
        for(int i = 0; i < MainActivity.news_lists.size(); i++){
            if(MainActivity.news_lists.get(i).getGame().equals(MainActivity.gameStk)){
                listaAux2.add(MainActivity.news_lists.get(i));
            }//if
        }//for
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
