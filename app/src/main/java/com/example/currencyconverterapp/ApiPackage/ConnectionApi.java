package com.example.currencyconverterapp.ApiPackage;

import com.example.currencyconverterapp.Model.CurrencyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConnectionApi {
    @GET("/api/v7/convert")
    Call<CurrencyResponse>getCurrencyValue(
      @Query("q") String from,
      @Query("apiKey") String apikey,
      @Query("compact") String compact
    );
}
