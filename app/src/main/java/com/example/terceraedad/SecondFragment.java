package com.example.terceraedad;

import static android.app.Activity.RESULT_OK;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SecondFragment extends Fragment {

    View view;
    ImageView imageView;
    NavController navController;

    private static final int REQUEST_CODE = 22;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //DECLARAMOS COMPÒNENTES
        view = inflater.inflate(R.layout.fragment_second, container, false);
        imageView = view.findViewById(R.id.imageView3);

        //CUANDO LE DE A LA IMAGEN ESTA PASARA A ABRIRSE LA CAMARA
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //ACTIVIDAD DE LA CAMARA
                startActivityForResult(camara, REQUEST_CODE); //AQUI HACE LA ACCION

            }
        });

        return view;
    }

    //CUANDO HAGA LA FOTO ESTO LO QUE HARA SERA MANDARLO A LA SIGUIENTE VISTA PARA MOSTRAR LA FOTO
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //RECOGEMOS LA IMAGEN
        Bitmap photo = (Bitmap) data.getExtras().get("data");
        //Y LA MANDAMOS A LA OTRA VISTA
        navController = Navigation.findNavController(requireActivity(), R.id.navHost);
        navController.navigate(SecondFragmentDirections.actionSecondFragmentToSixthFragment(photo));

    }


}