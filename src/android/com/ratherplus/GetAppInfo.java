package com.ratherplus;

import java.io.ByteArrayOutputStream;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Bitmap;
import android.util.Base64;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;


public class GetAppInfo extends CordovaPlugin {
  private static final String TAG = "GetAppInfo";

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Initializing GetAppInfo");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    String packageName = args.getString(0);

    if (action.equals("getAppIcon")) {
      this.getAppIcon(packageName, callbackContext);
    } else if (action.equals("getAppLabel")) {
      this.getAppLabel(packageName, callbackContext);
    }
    return true;
  }

  private void getAppIcon(String packageName, CallbackContext callbackContext) {
    final PackageManager packageManager = this.cordova.getActivity().getPackageManager();

    try {
      Drawable icon = packageManager.getApplicationIcon(packageName);

      Bitmap iconBitmap = ((BitmapDrawable) icon).getBitmap();
      ByteArrayOutputStream stream = new ByteArrayOutputStream();
      iconBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
      final String iconBase64 = Base64.encodeToString(stream.toByteArray(), Base64.DEFAULT);

      callbackContext.success("data:image/png;base64," + iconBase64);
    } catch (final NameNotFoundException e) {
      callbackContext.error("Cannot get app icon");
    }
  }

  private void getAppLabel(String packageName, CallbackContext callbackContext) {
    final PackageManager packageManager = this.cordova.getActivity().getPackageManager();

    try {
      final ApplicationInfo appInfo = packageManager.getApplicationInfo(packageName, 0);
      final String appLabel = packageManager.getApplicationLabel(appInfo).toString();
      callbackContext.success(appLabel);
    } catch (final NameNotFoundException e) {
      callbackContext.error("Cannot get app label");
    }
  }
}
