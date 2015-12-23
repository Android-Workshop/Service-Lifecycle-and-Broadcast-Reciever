package com.example.jimit.servicelifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = MyService.class.getSimpleName();

    public MyService() {
        Log.d(TAG, "MyService: Constructor called");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind:");
        return null;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate:");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");

        for (int i = 0; i < 3; i++) {
            long endTime = System.currentTimeMillis() + 10 * 1000;
            while (System.currentTimeMillis() < endTime) {
                synchronized (this) {
                    try {
                        wait(endTime - System.currentTimeMillis());
                    } catch (Exception e) {
                    }
                }
            }
            Log.i(TAG, "Service running");
        }

        return START_STICKY;
    }


}
