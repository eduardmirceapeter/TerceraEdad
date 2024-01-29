package com.example.terceraedad;

import static androidx.core.content.ContextCompat.checkSelfPermission;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ThirdFragment extends Fragment {
    View view;
    FloatingActionButton button;
    EditText editText;
    static int PERMISSION_CODE=100;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //DECLARAMOS COMPONENTES
        view = inflater.inflate(R.layout.fragment_third, container, false);
        editText=view.findViewById(R.id.editTextPhone);
        button=view.findViewById(R.id.floatingActionButton2);

        //CUANDO EL BOTON SE PULSE HARA LA ACCION DE LLAMAR
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = editText.getText().toString(); //SE RECOGE EL NUMERO ESCRITO
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(phone)); //Y SE LE PASA A LA ACTIVIDAD

                //SI NO ESTA VACIO PHONE QUE HAGA LA ACCION DE LLAMAR
                if (!phone.isEmpty()) {
                    String dial = "tel:" + phone;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                }
            }
        });

        return view;
    }
}