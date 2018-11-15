package br.com.app.mafeed.business.services.rss;


import br.com.app.mafeed.business.model.RSSObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RSSApi {

    @GET
    Call<RSSObject> getRSSContent(@Url String url);

}
