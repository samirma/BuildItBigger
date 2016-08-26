package com.example.samir.myapplication.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class JokeModel {

    private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}