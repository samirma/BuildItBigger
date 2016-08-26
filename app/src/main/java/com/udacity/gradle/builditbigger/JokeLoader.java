package com.udacity.gradle.builditbigger;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;

import com.udacity.provider.JokeProvider;
import com.udacity.provider.JokeProviderFactory;

/**
 * Created by samir on 8/25/16.
 */

@TargetApi(Build.VERSION_CODES.CUPCAKE)
public class JokeLoader extends AsyncTask<Void, Void, String> {


    @Override
    protected String doInBackground(Void... params) {
        final JokeProvider jokeProvider = JokeProviderFactory.getJokeProvider();
        return null;
    }
}
