package com.example.currencyconverterapp.ApiPackage;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RetrofitClient {
    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
            .url("https://currency-converter11.p.rapidapi.com")
            .get()
            .addHeader("x-rapidapi-host", "currency-converter11.p.rapidapi.com")
            .addHeader("x-rapidapi-key", "cffacc82b5mshb998516fb836616p15826djsne71cb432e10d")
            .build();

    Response response = client.newCall(request).execute();

    public RetrofitClient() throws IOException {
    }
}
