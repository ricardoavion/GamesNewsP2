package com.example.avion.gamesnewsp2.fragments;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.avion.gamesnewsp2.R;
import com.example.avion.gamesnewsp2.acitivities.MainActivity;
import com.squareup.picasso.Picasso;



public class Generals extends Fragment {
    TextView idTv,titleTv,bodyTv,dateTv,descriptionTv,gameTv;
    ImageView imagenV;
    String imagen;

    public Generals() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_generals,container,false);
        //llenando con datos de bundle de viewHolder
        gameTv = (TextView)view.findViewById(R.id.fragment_game);
        descriptionTv = (TextView)view.findViewById(R.id.fragment_description);
        bodyTv = (TextView)view.findViewById(R.id.fragment_body);
        imagenV = (ImageView)view.findViewById(R.id.fragment_image);

        gameTv.setText(MainActivity.gameStk);
        descriptionTv.setText(MainActivity.desciptionStk);
        bodyTv.setText(MainActivity.bodyStk);
        imagen = MainActivity.imagenStk;
        Picasso.with(getContext()).load(imagen).into(imagenV);

        return view;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
