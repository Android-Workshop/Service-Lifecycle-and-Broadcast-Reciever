package com.example.jimit.servicelifecycle;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 */
public class MyIntentService extends IntentService {
    private static final String TAG = MyIntentService.class.getSimpleName();

    public MyIntentService() {
        super("MyIntentService");
        Log.d(TAG, "MyIntentService: constructor called");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent: started");
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
            Log.i(TAG, "IntentService running");
        }
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: called");
        super.onDestroy();
    }
}
