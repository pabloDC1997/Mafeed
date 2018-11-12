package br.com.app.mafeed.business.services.rss;


import br.com.app.mafeed.business.model.RSSObject;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RSSApi {

    @GET("/rss/g1/")
    Call<RSSObject> getRSSContent();

}
