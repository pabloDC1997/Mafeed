package br.com.app.mafeed.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.widget.Toast;

import br.com.app.mafeed.R;

/**
 * Created by Pablo on 24/01/2017.
 */

public class ActivityUtils {

    public static void showSnackbarMessage(Activity activity, String message){
        Snackbar.make(activity.findViewById(android.R.id.content),message, Snackbar.LENGTH_LONG).show();
    }
    public static void showErrorToast(Activity activity, String errorMsg){
        errorMsg = errorMsg == null ? activity.getString(R.string.unexpected_error) : errorMsg;
        Toast.makeText(activity, errorMsg, Toast.LENGTH_LONG).show();
        Log.e(activity.getClass().getName(), errorMsg);
    }

    public static void showErrorToast(Activity activity, Throwable e){
        if (e.getCause() != null)
            showErrorToast(activity,e.getCause().toString());
        else if (e.getMessage() != null)
            showErrorToast(activity,e.getMessage());
        else
            showErrorToast(activity, activity.getString(R.string.unexpected_error));
    }
}
