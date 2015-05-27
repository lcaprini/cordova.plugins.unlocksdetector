package it.lcaprini.cordova.plugins;

import java.io.File;
import it.lcaprini.cordova.plugins.ExecShell.SHELL_CMD;

/** @author Kevin Kowalewski */
/** @author Jimmy Liao */
/** @author Luca Caprini */
public class Root {

    private static String LOG_TAG = Root.class.getName();

    public boolean isDeviceRooted() {
        return checkRootMethod1() || checkRootMethod2() || checkRootMethod3();
    }

    public boolean checkRootMethod1() {
        String buildTags = android.os.Build.TAGS;
        return buildTags != null && buildTags.contains("test-keys");
    }

    public boolean checkRootMethod2() {
        try {
            File file = new File("/system/app/Superuser.apk");
            return file.exists();
        } catch (Exception e){ 
        	return false;
        }
    }

    public boolean checkRootMethod3() {
        return new ExecShell().executeCommand(SHELL_CMD.check_su_binary)!=null;
    }
}   


