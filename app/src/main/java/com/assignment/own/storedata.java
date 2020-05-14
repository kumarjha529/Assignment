package com.assignment.own;

import com.google.gson.annotations.SerializedName;

public class storedata {

    //private String url;
    private String id;

    private String repository_url;
    private String state;

    public storedata(String id, String repository_url, String state) {
        this.id = id;
        this.repository_url = repository_url;
        this.state = state;

    }

    public String getId() {
        return id;
    }

    public String getRepository_url() {
        return repository_url;
    }

    public String getState() {
        return state;
    }
}
