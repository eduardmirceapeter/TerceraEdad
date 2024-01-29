package com.example.terceraedad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FirstFragment extends Fragment {
    View view;
    Button camara;
    Button llamar;
    Button alarma;
    Button evento;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_first, container, false);
        camara= view.findViewById(R.id.button2);
        llamar= view.findViewById(R.id.button3);
        alarma= view.findViewById(R.id.button4);
        evento= view.findViewById(R.id.button5);

        // Obtener NavController
        NavController navController = Navigation.findNavController(requireActivity(), R.id.navHost);

        //Cuando pulses el boton de la camara ira a la primera vista.
        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment());
            }
        });
        //Cuando pulses el boton de la llamar ira a la segunda vista.
        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(FirstFragmentDirections.actionFirstFragmentToThirdFragment());
            }
        });
        //Cuando pulses el boton de la alarma ira a la tercera vista.
        alarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(FirstFragmentDirections.actionFirstFragmentToFourthFragment());
            }
        });
        //Cuando pulses el boton de evento ira a la cuarta vista.
        evento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(FirstFragmentDirections.actionFirstFragmentToFifthFragment());
            }
        });


        return view;
    }
}