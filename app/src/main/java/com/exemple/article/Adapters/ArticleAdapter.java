package com.exemple.article.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.exemple.article.Article;
import com.exemple.article.R;
import com.exemple.article.Ui.DetailsActivity;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private List<Article> articles;
    public  ArticleAdapter(List<Article> articles){
        this.articles=articles;
    }

    @Override
    public ArticleAdapter.ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_article,parent,false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ArticleAdapter.ArticleViewHolder holder, int position) {
    Article current=articles.get(position);
    holder.title.setText(current.getTitle());
    holder.body.setText(current.getBody());
    Glide.with(holder.itemView.getContext())
            .load(current.getImageUrl())
            .into(holder.image);

        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(v.getContext(), DetailsActivity.class);

            intent.putExtra("title", current.getTitle());
            intent.putExtra("body", current.getBody());
            intent.putExtra("image", current.getImageUrl());

            v.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
public static class ArticleViewHolder extends RecyclerView.ViewHolder{
        TextView title,body;
        ImageView image;
        public ArticleViewHolder(View itemView){
        super(itemView);
        title=itemView.findViewById(R.id.title);
        body=itemView.findViewById(R.id.body);
        image=itemView.findViewById(R.id.imgArticle);
        }
}
}
