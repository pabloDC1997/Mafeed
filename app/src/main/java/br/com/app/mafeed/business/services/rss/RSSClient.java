package br.com.app.mafeed.business.services.rss;

import android.content.Context;
import android.util.Log;

import br.com.app.mafeed.business.model.RSSObject;
import br.com.app.mafeed.business.services.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RSSClient extends RetrofitClient {

    private Context context;

    public RSSClient(Context context) {
        super("http://pox.globo.com");
        this.context = context;
    }

    public void getRSS(final RSSCallback callback){
        callback.onPreExecute();
        retrofit.create(RSSApi.class)
                .getRSSContent()
                .enqueue(new Callback<RSSObject>() {
                    @Override
                    public void onResponse(Call<RSSObject> call, Response<RSSObject> response) {
                        if (response.isSuccessful()){
                            callback.onSuccess(response.body());
                        } else {
                            callback.onError();
                        }
                    }

                    @Override
                    public void onFailure(Call<RSSObject> call, Throwable t) {
                        Log.e(RSSClient.class.getName(), t.getCause().getMessage());
                        callback.onError();
                    }
                });
    }

    public interface RSSCallback {
        void onPreExecute();
        void onError();
        void onSuccess(RSSObject rss);
    }
}
