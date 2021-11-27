package com.test.alphatestproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GifModel {

    private Data data;

    public GifModel(Data data) {
        this.data = data;
    }

    public GifModel() {
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}

