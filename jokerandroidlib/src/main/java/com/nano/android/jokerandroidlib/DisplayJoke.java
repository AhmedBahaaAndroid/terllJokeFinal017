package com.nano.android.jokerandroidlib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayJoke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        TextView textview = (TextView) findViewById(R.id.joke_text);

        String JokeResult = null;
        Intent intent = getIntent();
        JokeResult = intent.getStringExtra("JOKE");

        if (JokeResult != null) {
            textview.setText(JokeResult);
        } else {
            textview.setText("couldn't find the joke!");
        }
    }
}
