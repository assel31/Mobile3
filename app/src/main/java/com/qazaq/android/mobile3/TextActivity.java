package com.qazaq.android.mobile3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TextActivity extends AppCompatActivity {

    private String title;
    private String content;
    private TextView titleView;
    private TextView contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        title = getIntent().getExtras().getString("title");
        content = getIntent().getExtras().getString("content");

        titleView = (TextView) findViewById(R.id.titleTextView);
        contentView = (TextView) findViewById(R.id.contentTextView);

        titleView.setText(title);
        contentView.setText(content);

    }
}
