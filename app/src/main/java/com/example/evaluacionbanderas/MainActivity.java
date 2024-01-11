package com.example.evaluacionbanderas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.evaluacionbanderas.WebServices.Asynchtask;
import com.example.evaluacionbanderas.WebServices.WebService;
import com.example.evaluacionbanderas.adaptadores.AdaptadorPaises;
import com.example.evaluacionbanderas.modelos.Paises;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("http://www.geognos.com/api/en/countries/info/all.json",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");


    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Paises> listapaises = new ArrayList<Paises>();
        JSONObject response = new JSONObject(result);
        JSONObject resultsObject = response.getJSONObject("Results");
        listapaises = Paises.JsonObjectsBuild(resultsObject);
        AdaptadorPaises adaptadorPais = new AdaptadorPaises(this, listapaises);
        ListView lstOpciones = (ListView) findViewById(R.id.lstpaises);
        lstOpciones.setAdapter(adaptadorPais);
    }
}