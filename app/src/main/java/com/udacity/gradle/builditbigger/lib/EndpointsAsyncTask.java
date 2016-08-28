package com.udacity.gradle.builditbigger.lib;

import android.os.AsyncTask;
import android.util.Log;

import com.example.samir.myapplication.backend.udacityApi.UdacityApi;
import com.example.samir.myapplication.backend.udacityApi.model.JokeModel;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static UdacityApi myApiService = null;

    private EndpointsAsyncTaskDelegate delegate;

    public EndpointsAsyncTask(EndpointsAsyncTaskDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected String doInBackground(Void... params) {

        String jokeString = null;

        if(myApiService == null) {  // Only do this once
            UdacityApi.Builder builder = new UdacityApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                // options for running against local devappserver
                // - 10.0.2.2 is localhost's IP address in Android emulator
                // - turn off compression when running against local devappserver
                .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            final UdacityApi.Joke joke = myApiService.joke();
            final JokeModel execute = joke.execute();
            final String data = execute.getData();
            return data;
        } catch (IOException e) {
            Log.e(EndpointsAsyncTask.class.getSimpleName(), e.getMessage(), e);
        }

        return jokeString;

    }


    @Override
    protected void onPostExecute(String result) {
        delegate.setJoke(result);
    }
}
