package com.example.terceraedad;

import static android.content.Context.ALARM_SERVICE;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


public class FourthFragment extends Fragment {
    View view;
    private static final int ALARM_REQUEST_CODE = 123;
    private int selectedHour;
    private int selectedMinute;

    private Button btnSetAlarm;
    AlarmManager alarmManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //DECLARAMOS COMPONENTES
        view=inflater.inflate(R.layout.fragment_fourth, container, false);
        btnSetAlarm = view.findViewById(R.id.button);

        //SI EL BOTON SE PULSA QUE HAGA LA ACCION DEL METODO INDICADO
        btnSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });


        return view;
    }

    //AQUI SE RECOGE LA HORA Y EL MINUTO INTRODUCIDO
    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(requireContext(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        selectedHour = hourOfDay; //HORA
                        selectedMinute = minute; //MINTUO

                        setAlarm(selectedHour, selectedMinute); //Y SE LO PASAMOS AL METODO
                    }
                }, 12, 0, true); // Valores iniciales (12:00 PM)
        timePickerDialog.show();
    }

    //AQUI HACEMOS QUE A LA HORA PUESTA SUENE LA ALARMA MOSTRANDO UN MENSAJE
    private void setAlarm(int hour, int minute) {
        AlarmManager alarmManager = (AlarmManager) requireContext().getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(requireContext(), AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(requireContext(), ALARM_REQUEST_CODE, intent, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);

        long alarmTime = calendar.getTimeInMillis();


        alarmManager.set(AlarmManager.RTC_WAKEUP, alarmTime, pendingIntent);
    }
}