package com.example.jonathan.apprunmonitor.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import java.util.List;

import static com.example.jonathan.apprunmonitor.utils.ConstantsUtils.APP_TAG;

public class ActivityManagerUtils {
  private static final String TAG = APP_TAG + ActivityManagerUtils.class.getSimpleName();

  public static boolean getAppRunningStatus(final Context context, final String packageName) {
    Log.d(TAG, "getAppRunningStatus: packageName=[" + packageName + "]");

    final ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

    final List<ActivityManager.RunningAppProcessInfo> procInfos = activityManager.getRunningAppProcesses();

    boolean isAppRunning = false;

    if (procInfos != null) {
      // !!! In Android 8, the list contains only the current app. Not good!
      Log.v(TAG, "getAppRunningStatus: procInfos.size=[" + procInfos.size() + "]");

      for (ActivityManager.RunningAppProcessInfo processInfo : procInfos) {
        Log.v(TAG, "getAppRunningStatus: processInfo.processName=[" + processInfo.processName + "]");

        if (processInfo.processName.equals(packageName)) {
          isAppRunning = true;
          break;
        }
      }
    } else {
      Log.w(TAG, "getAppRunningStatus: procInfos != null !");
    }

    Log.v(TAG, "getAppRunningStatus: isAppRunning=[" + isAppRunning + "]");

    return isAppRunning;
  }
}
