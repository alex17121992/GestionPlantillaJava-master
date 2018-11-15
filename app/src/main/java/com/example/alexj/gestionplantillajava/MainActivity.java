package com.example.alexj.gestionplantillajava;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private LinearLayout llPrincipal;
    private LinearLayout llEquipo;
    private LinearLayout llPrimero;
    private LinearLayout llJugador;
    private LinearLayout llScouting;
    private LinearLayout llBotones;
    private TextView tvAñadirEquipo;
    private ImageView ivEquipo;
    private TextView tvAñadeJugador;
    private ImageView ivJugador;
    private TextView tvScoutingJugador;
    private ImageView ivScouting;
    private FloatingActionButton faBotonAñadirEquipo;
    private FloatingActionButton faBotonAñadirJugador;
    private FloatingActionButton faBotonAñadirScouting;
    private static BdJugador bd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llBotones = (LinearLayout) findViewById(R.id.llBotones);
        llScouting = (LinearLayout) findViewById(R.id.llScouting);
        llJugador = (LinearLayout) findViewById(R.id.llJugador);
        llEquipo = (LinearLayout)findViewById(R.id.llEquipo);
        llPrimero = (LinearLayout) findViewById(R.id.llPrimero);
        llPrincipal = (LinearLayout) findViewById(R.id.llPrincipal);
        tvAñadirEquipo = (TextView) findViewById(R.id.tvAñadirEquipo);
        ivEquipo = (ImageView) findViewById(R.id.ivEquipo);
        tvAñadeJugador = (TextView) findViewById(R.id.tvAñadeJugador);
        ivJugador = (ImageView) findViewById(R.id.ivJugador);
        tvScoutingJugador = (TextView) findViewById(R.id.tvScoutingJugador);
        ivScouting = (ImageView) findViewById(R.id.ivScouting);
        faBotonAñadirEquipo = (FloatingActionButton) findViewById(R.id.faBotonAñadirEquipo);
        faBotonAñadirJugador = (FloatingActionButton) findViewById(R.id.faBotonAñadirJugador);
        faBotonAñadirScouting = (FloatingActionButton) findViewById(R.id.faBotonAñadirScouting);

        bd=new BdJugador(this,"BDEquipos",null,1);
        SQLiteDatabase sq=bd.getWritableDatabase();
        bd.onCreate(sq);

        faBotonAñadirEquipo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Opcion disponible proximamente", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        faBotonAñadirJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =  new Intent(MainActivity.this, jugador.class);
                startActivity(intent1);
            }
        });


        faBotonAñadirScouting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, scouting.class);
                startActivity(intent);
            }
        });

    }

}
