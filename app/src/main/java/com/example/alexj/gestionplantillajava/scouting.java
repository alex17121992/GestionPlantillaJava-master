package com.example.alexj.gestionplantillajava;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class scouting extends AppCompatActivity {

    private TextView tvScoutingS;
    private TextView tvNDeportivoS;
    private EditText etNDeportivoS;
    private ImageView ivFotoScoutingS;
    private TextView tvNombreS;
    private EditText etNombreS;
    private TextView tvApellidosS;
    private EditText etApellidosS;
    private TextView tvEdadS;
    private EditText etEdadS;
    private TextView tvAlturaS;
    private EditText etAlturaS;
    private TextView tvPesoS;
    private EditText etPesoS;
    private TextView tvPDominanteS;
    private EditText etPDominanteS;
    private TextView tvDemarcacionS;
    private EditText etDemarcacionS;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scouting);

        tvScoutingS = (TextView) findViewById(R.id.tvScoutingS);
        tvNDeportivoS = (TextView) findViewById(R.id.tvNDeportivoS);
        etNDeportivoS = (EditText) findViewById(R.id.etNDeportivoS);
        ivFotoScoutingS = (ImageView) findViewById(R.id.ivFotoScoutingS);
        tvNombreS = (TextView) findViewById(R.id.tvNombreS);
        etNombreS = (EditText) findViewById(R.id.etNombreS);
        tvApellidosS = (TextView) findViewById(R.id.tvApellidosS);
        etApellidosS = (EditText) findViewById(R.id.etApellidosS);
        tvEdadS = (TextView) findViewById(R.id.tvEdadS);
        etEdadS = (EditText) findViewById(R.id.etEdadS);
        tvAlturaS = (TextView) findViewById(R.id.tvAlturaS);
        etAlturaS = (EditText) findViewById(R.id.etAlturaS);
        tvPesoS = (TextView) findViewById(R.id.tvPesoS);
        etPesoS = (EditText) findViewById(R.id.etPesoS);
        tvPDominanteS = (TextView) findViewById(R.id.tvPDominanteS);
        etPDominanteS = (EditText) findViewById(R.id.etPDominanteS);
        tvDemarcacionS = (TextView) findViewById(R.id.tvDemarcacionS);
        etDemarcacionS = (EditText) findViewById(R.id.etDemarcacionS);

        ivFotoScoutingS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarImagen();
            }
        });


    }


    // métodos para cargar las imagenes desde la galeria
    public void cargarImagen()
    {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent, "seleccione la Aplicación"), 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK)
        {
            try {
                Uri selectedImage = data.getData();

                ivFotoScoutingS.setImageURI(selectedImage);

            } catch(Exception e)
            {
                e.printStackTrace();
            }


        }
    }
}
