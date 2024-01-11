package com.example.evaluacionbanderas.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.evaluacionbanderas.R;
import com.example.evaluacionbanderas.modelos.Paises;


import java.util.ArrayList;

public class AdaptadorPaises extends ArrayAdapter <Paises> {

    public AdaptadorPaises(Context context, ArrayList<Paises> datos){
        super(context, R.layout.lyitempaises, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitempaises, null);

        TextView lblNombre = (TextView)item.findViewById(R.id.lblNombre);
        lblNombre.setText(getItem(position).getNombre());

        ImageView imageView = (ImageView)item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext())
                .load(getItem(position).getUrlLogo())
                .into(imageView);

        return(item);
        }
}



