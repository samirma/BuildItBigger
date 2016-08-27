package com.udacity.jokerproviderandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE = "joke";

    TextView joke;
    private String jokeText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        joke = (TextView) findViewById(R.id.joke);

        if (savedInstanceState != null) {

            jokeText = savedInstanceState.getString(JOKE);

        } else {
            jokeText = getIntent().getExtras().getString(JOKE);
        }

        joke.setText(jokeText);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(JOKE, jokeText);
    }

}
