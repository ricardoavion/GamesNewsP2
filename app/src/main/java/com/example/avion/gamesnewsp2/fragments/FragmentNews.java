package com.example.avion.gamesnewsp2.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.avion.gamesnewsp2.R;
import com.example.avion.gamesnewsp2.adapters.NewsAdapter;
import com.example.avion.gamesnewsp2.classes.*;
import com.example.avion.gamesnewsp2.interfaces.RetrofitService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.example.avion.gamesnewsp2.acitivities.MainActivity.players_list;



public class FragmentNews extends Fragment {
    RecyclerView recyclerView;
    ArrayList<News> news_list = new ArrayList<>();


    private static String token;
    public static final String BASE_URL = "https://gamenewsuca.herokuapp.com";


    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Authorization","Bearer " + token)
                    .build();
            return chain.proceed(newRequest);
        }
    }).build();

    Retrofit.Builder buider = new Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit = buider.build();
    RetrofitService retrofitService = retrofit.create(RetrofitService.class);


    public FragmentNews() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_news, container, false);
        getToken();
        return view;
    }



    private void getToken(){

        Login login = new Login("00024614","00024614"); //aca se deberia llenar con campos en RES
        Call<Login> call = retrofitService.getToken(login);
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if(response.isSuccessful()){
                    token = response.body().getToken();
                    Toast.makeText(getContext(),"El token es: "+response.body().getToken(),Toast.LENGTH_SHORT).show();

                    getNews();
                }
                else{
                    Toast.makeText(getContext(),"Fallo al agarrar token",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(getContext(),"Fallo de conexion",Toast.LENGTH_SHORT).show();
            }
        });

    }//getToken


    private void getNews(){
        Call<List<News>> call = retrofitService.getNews("title","game","_id","body", "date",
                "coverImage", "description");
        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                Toast.makeText(getContext(),"Conexion exitosa",Toast.LENGTH_SHORT).show();
                for(int i = 0; i < response.body().size(); i++) {

                    String id = response.body().get(i).getId();
                    String imagen = response.body().get(i).getCoverImage();
                    String body = response.body().get(i).getBody();
                    String date = response.body().get(i).getCreatedDate();
                    String description = response.body().get(i).getDescription();
                    String titulo = response.body().get(i).getTitle();
                    String game = response.body().get(i).getGame();
                    news_list.add(new News(id,titulo,body,game,date,imagen,description));//arreglo para noticia


                }

                getPlayers();
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                Toast.makeText(getContext(),"fallo de recoleccion de datos",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getPlayers(){
        Call<List<Players>> call = retrofitService.getPlayers("avatar","id","name",
                "biografia","game");
        call.enqueue(new Callback<List<Players>>() {
            @Override
            public void onResponse(Call<List<Players>> call, Response<List<Players>> response) {
                Toast.makeText(getContext(),"Exito extrayendo players",Toast.LENGTH_SHORT).show();
                for(int i = 0; i < response.body().size(); i++) {
                    String avatar = response.body().get(i).getAvatar();
                    String id = response.body().get(i).getId();
                    String name = response.body().get(i).getName();
                    String biografia = response.body().get(i).getBiografia();
                    String game = response.body().get(i).getGame();
                    players_list.add(new Players(avatar,id,name,biografia,game));//arreglo para players

                    CreandoCardViews();
                }

            }

            @Override
            public void onFailure(Call<List<Players>> call, Throwable t) {
                Toast.makeText(getContext(),"fallo extraccion de players",Toast.LENGTH_SHORT).show();
            }
        });

    }//get players
    private void CreandoCardViews(){
        //=========codigo para CardView de news=============
        recyclerView = (RecyclerView)getView().findViewById(R.id.recycler_news);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        NewsAdapter newsAdapter = new NewsAdapter(getContext(),news_list);
        recyclerView.setAdapter(newsAdapter);

    }


}
