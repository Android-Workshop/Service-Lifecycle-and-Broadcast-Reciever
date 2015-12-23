package com.example.jimit.servicelifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = (Button) findViewById(R.id.btn_start);
        Button btnStop = (Button) findViewById(R.id.btn_stop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startService(new Intent(MainActivity.this, MyIntentService.class));
                Intent intent = new Intent(MainActivity.this, MyReceiver.class);
                intent.setAction("com.example.jimit.servicelifecycle.MY_RECEIVER");
                sendBroadcast(intent);
            }
        });


        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                stopService(new Intent(MainActivity.this, MyIntentService.class));
            }
        });
    }
}
