package com.example.jonathan.apprunmonitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jonathan.apprunmonitor.utils.ActivityUtils;
import com.example.jonathan.apprunmonitor.utils.ConstUtils;

import static com.example.jonathan.apprunmonitor.utils.ConstUtils.APP_TAG;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = APP_TAG + MainActivity.class.getSimpleName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.d(TAG, "onCreate");

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ActivityUtils.checkAppRunningPeriodically(this, ConstUtils.CHECK_APP_RUNNING_SLEEP_MILLIS,
        ConstUtils.CHECK_APP_RUNNING_MAX_TRIALS, ConstUtils.TARGET_PACKAGE_NAME);

    Log.v(TAG, "onCreate: end");
  }
}
