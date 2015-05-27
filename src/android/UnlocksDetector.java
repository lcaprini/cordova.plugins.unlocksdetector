package it.lcaprini.cordova.plugins;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.*;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.util.Base64;
import android.view.Gravity;
import android.widget.Toast;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import it.lcaprini.cordova.plugins.Root;

public class UnlocksDetector extends CordovaPlugin {

  private static final String ACTION_CHECK_ROOT = "isRooted";
  private static final int ACTIVITY_CODE_SENDVIAEMAIL = 2;
  private CallbackContext _callbackContext;
  private String pasteMessage;
  private Root rootCheckObj;

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    this._callbackContext = callbackContext; // only used for onActivityResult
    this.pasteMessage = null;
    String result = "test";
    boolean resultStatus = false;
    rootCheckObj = new Root();
    
    if (ACTION_CHECK_ROOT.equals(action)) {
    	//callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
    	System.out.println("########## " + rootCheckObj.isDeviceRooted());
    	callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, rootCheckObj.isDeviceRooted()));
    	resultStatus = true;
    } else {
    	callbackContext.error("unlocksDetector." + action + " is not a supported function. Did you mean '" + ACTION_CHECK_ROOT + "'?");
    }
    return resultStatus;
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    if (ACTIVITY_CODE_SENDVIAEMAIL == requestCode) {
      super.onActivityResult(requestCode, resultCode, intent);
      _callbackContext.success();
    } else {
      _callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, resultCode == Activity.RESULT_OK));
    }
  }
}
