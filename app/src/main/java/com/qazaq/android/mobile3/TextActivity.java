package com.qazaq.android.mobile3;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class TextActivity extends AppCompatActivity {

    CollapsingToolbarLayout titleView;
    TextView contentView;
    ImageView textImageView;

    String title;
    String content;
    String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Typeface fontHeading = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/heading.otf");
        Typeface fontMain = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/main.ttf");

        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");
        image = getIntent().getStringExtra("image");

        titleView = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        titleView.setExpandedTitleTypeface(fontHeading);
        titleView.setCollapsedTitleTypeface(fontHeading);
        titleView.setTitle(title);

        contentView = (TextView) findViewById(R.id.contentTextView);
        contentView.setText(content);
        contentView.setTypeface(fontMain);

        textImageView = (ImageView) findViewById(R.id.textImageView);
        Glide.with(getApplicationContext()).load(image).centerCrop().into(textImageView);
    }
}
