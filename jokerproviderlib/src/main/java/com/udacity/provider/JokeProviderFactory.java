package com.udacity.provider;

/**
 * Created by samir on 8/25/16.
 */

public class JokeProviderFactory {


    public static JokeProvider getJokeProvider() {
        return new JokeProviderGCE();
    }
}
