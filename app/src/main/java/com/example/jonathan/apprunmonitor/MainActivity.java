package com.example.jonathan.apprunmonitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jonathan.apprunmonitor.utils.ActivityManagerUtils;
import com.example.jonathan.apprunmonitor.utils.ConstantsUtils;

import static com.example.jonathan.apprunmonitor.utils.ConstantsUtils.APP_TAG;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = APP_TAG + MainActivity.class.getSimpleName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.d(TAG, "onCreate");

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ActivityManagerUtils.getAppRunningStatus(this, ConstantsUtils.TARGET_PACKAGE_NAME);

    Log.v(TAG, "onCreate: end");
  }
}
