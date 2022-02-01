package com.example.currencyconverterapp.ApiPackage;

import com.example.currencyconverterapp.Model.CurrencyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {
    @GET("/api/v1/convert")
    Call<CurrencyResponse> getCurrencyValue(
            @Query("amount") String amount,
            @Query("from") String from,
            @Query("to") String to
    );
}
