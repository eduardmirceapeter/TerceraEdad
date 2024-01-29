package com.example.terceraedad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    //SONIDO ALARMA (EN ESTE CASO MENSAJE)
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm! Wake up!", Toast.LENGTH_LONG).show();
    }
}
