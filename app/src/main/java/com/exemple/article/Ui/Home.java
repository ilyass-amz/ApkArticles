package com.exemple.article.Ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.exemple.article.Adapters.ArticleAdapter;
import com.exemple.article.Model.Article;
import com.exemple.article.Helpers.GsonHelper;
import com.exemple.article.Helpers.VolleyHelper;
import com.exemple.article.R;

import java.util.List;

public class Home extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArticleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        loadData();
    }
    private void loadData(){
        String url="https://jsonplaceholder.typicode.com/posts";
        StringRequest request=new StringRequest(Request.Method.GET,url,
                response->{
                    List<Article> articles= GsonHelper.parseJson(response);
                    adapter=new ArticleAdapter(articles);
                    recyclerView.setAdapter(adapter);
                },
                error->{
                    Toast.makeText(this,"Erreur réseau",Toast.LENGTH_SHORT).show();
                }
                );
        VolleyHelper.getInstance(this).addToRequestQueue(request);
    }
}