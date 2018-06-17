package com.example.avion.gamesnewsp2.adapters;



public class FavoriteAdapter /* extends RecyclerView.Adapter<FavoriteAdapterViewHolder>*/  {/*

    ArrayList<News> news_list;
    private Context context;

    public FavoriteAdapter(Context context, ArrayList<News> news_list) {
        this.news_list = news_list;
        this.context = context;
    }

    @NonNull
    @Override
    public FavoriteAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View news_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_favorites, parent, false);
        return new FavoriteAdapterViewHolder(news_view,news_list,context);
    }

    @Override
    public void onBindViewHolder(FavoriteAdapterViewHolder holder, int position) {
        holder.game.setText(news_list.get(position).getGame());
        holder.title.setText(news_list.get(position).getTitle());
        //holder.image.setImageURI();
        Picasso.with(context).load(news_list.get(position).getCoverImage()).into(holder.images);

    }

    @Override
    public int getItemCount() {
        return news_list.size();
    }
    */
}
