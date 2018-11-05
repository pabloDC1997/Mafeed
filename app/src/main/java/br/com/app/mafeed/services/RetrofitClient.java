package br.com.app.mafeed.services;

import android.content.Context;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pablo on 17/05/2017.
 */

public abstract class RetrofitClient {

    public static Retrofit getClient(String baseUrl) {
     Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.i("INFO: ", "Initialized retrofit instance on base: " + retrofit.baseUrl());
        return retrofit;
    }

    private Retrofit getClient(String baseUrl) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
//                    .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(
//                            new Persister(new AnnotationStrategy() // important part!
//                            )
                    .baseUrl(baseUrl)
                    .build();
        }
        return retrofit;
    }
}

