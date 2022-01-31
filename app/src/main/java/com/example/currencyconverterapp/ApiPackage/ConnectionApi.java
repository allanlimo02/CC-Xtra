package com.example.currencyconverterapp.ApiPackage;

import com.example.currencyconverterapp.Model.CurrencyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConnectionApi {
    @GET("/api/v1/convert")
    Call<CurrencyResponse>getCurrencyValue(
      @Query("from") String from,
      @Query("to") String to,
      @Query("amount") Double amount
    );
}
