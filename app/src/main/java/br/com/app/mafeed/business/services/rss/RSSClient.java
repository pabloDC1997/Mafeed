package br.com.app.mafeed.business.services.rss;

import android.app.Activity;
import android.content.Context;

import br.com.app.mafeed.R;
import br.com.app.mafeed.business.model.FeedURL;
import br.com.app.mafeed.business.model.RSSObject;
import br.com.app.mafeed.business.services.RetrofitClient;
import br.com.app.mafeed.utils.ActivityUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RSSClient {

    private Context context;

    public RSSClient(Context context) {
        this.context = context;
    }

    public void getRSS(FeedURL url, final RSSCallback callback){
        callback.onPreExecute();
        Retrofit retrofit = RetrofitClient.getClient(url.getBase());
        retrofit.create(RSSApi.class)
                .getRSSContent(url.getEndpoint())
                .enqueue(new Callback<RSSObject>() {
                    @Override
                    public void onResponse(Call<RSSObject> call, Response<RSSObject> response) {
                        if (response.isSuccessful()){
                            RSSObject rss = response.body();
                            if (rss == null ||rss.getChannel() == null){
                                callback.onError();
                                ActivityUtils.showErrorToast((Activity) context, context.getString(R.string.feed_not_found));
                            } else {
                                callback.onSuccess(rss);
                            }
                        } else {
                            callback.onError();
                            ActivityUtils.showErrorToast((Activity) context, response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<RSSObject> call, Throwable t) {
                        callback.onError();
                        ActivityUtils.showErrorToast((Activity) context, t);
                    }
                });
    }

    public interface RSSCallback {
        void onPreExecute();
        void onError();
        void onSuccess(RSSObject rss);
    }
}
