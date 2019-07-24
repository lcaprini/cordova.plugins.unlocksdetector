package cordova.plugins;

import android.app.Activity;
import android.content.*;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

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
