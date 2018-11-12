package br.com.app.mafeed.business.services;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Pablo on 17/05/2017.
 */

public abstract class RetrofitClient {

    protected Retrofit retrofit;
    protected String baseURL;
    private OkHttpClient.Builder client;

    public RetrofitClient(String baseUrl) {
        buildOkHttpClient();
        this.baseURL = baseUrl;
        this.retrofit = getClient(baseUrl);
    }

    private Retrofit getClient(String baseUrl) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(new Persister(new AnnotationStrategy())))
                    .client(client.build())
                    .baseUrl(baseUrl)
                    .build();
        }
        return retrofit;
    }

    private void buildOkHttpClient() {
        client = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(loggingInterceptor);
    }
}

