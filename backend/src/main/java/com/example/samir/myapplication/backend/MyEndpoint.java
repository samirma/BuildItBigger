/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.samir.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.provider.JokeProvider;
import com.udacity.provider.JokeProviderFactory;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "udacityApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.samir.example.com",
                ownerName = "backend.myapplication.samir.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "joke")
    public JokeModel getJoke() {

        final JokeProvider jokeProvider = JokeProviderFactory.getJokeProvider();

        JokeModel response = new JokeModel();

        response.setData(jokeProvider.getJoke());

        return response;
    }

}
