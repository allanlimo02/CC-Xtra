package com.example.currencyconverterapp.ApiPackage;

import static com.example.currencyconverterapp.BuildConfig.x_rapidapi_key;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientClass {
    private static Retrofit retrofit = null;

    public static ConnectionApi getClient(){

        if (retrofit==null){
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request=chain
                                    .request()
                                    .newBuilder()
                                    .addHeader("x-rapidapi-host","currency-exchange.p.rapidapi.com")
                                    .addHeader("x-rapidapi-key",x_rapidapi_key)
                                    .build();

                            return chain.proceed(request);
                        }
                    }).build();
            retrofit=new Retrofit.Builder().baseUrl(PrimaryValues.baseUrl)
                    .client(okHttpClient).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ConnectionApi.class);
    };

}
