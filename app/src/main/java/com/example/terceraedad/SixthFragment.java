package com.example.terceraedad;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SixthFragment extends Fragment {
    View view;
    ImageView imageView;
    SixthFragmentArgs args;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_sixth, container, false);


        imageView=view.findViewById(R.id.imageView2);
        args = SixthFragmentArgs.fromBundle(getArguments());
        imageView.setImageBitmap(args.getImagen());


        return view;
    }

}