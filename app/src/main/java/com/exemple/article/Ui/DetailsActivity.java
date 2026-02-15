package com.exemple.article.Ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.exemple.article.R;

public class DetailsActivity extends AppCompatActivity {

    ImageView detailImg;
    TextView detailTitle, detailBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        detailImg = findViewById(R.id.detailImg);
        detailTitle = findViewById(R.id.detailTitle);
        detailBody = findViewById(R.id.detailBody);

        Intent intent = getIntent();

        detailTitle.setText(intent.getStringExtra("title"));
        detailBody.setText(intent.getStringExtra("body"));

        String imageUrl = intent.getStringExtra("image");

        Glide.with(this)
                .load(imageUrl)
                .into(detailImg);
    }
}