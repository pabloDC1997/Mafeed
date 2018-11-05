package br.com.app.mafeed.app;

import android.app.Application;
import android.content.Context;

import br.com.app.mafeed.utils.TinyDB;

/**
 * Created by pablo.couto on 06/12/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static TinyDB getInstanceTinyDB(Context context) {
        return new TinyDB(context);
    }
}
