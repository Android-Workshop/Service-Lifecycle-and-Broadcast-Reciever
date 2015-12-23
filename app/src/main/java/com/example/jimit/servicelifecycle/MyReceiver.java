package com.example.jimit.servicelifecycle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = MyReceiver.class.getSimpleName();

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: ");
        Toast.makeText(context.getApplicationContext(), "My Receiver acknowledged", Toast.LENGTH_SHORT).show();
    }
}
