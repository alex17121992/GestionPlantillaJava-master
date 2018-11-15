package com.example.alexj.gestionplantillajava;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

public class jugador extends AppCompatActivity {


    private TextView tvJugadorJ;
    private ImageView ivFotoJ;
    private TextView tvNombreJ;
    private EditText etNombreJ;
    private TextView tvApellidosJ;
    private EditText etApellidosJ;
    private TextView tvNDeportivoJ;
    private EditText etNDeportivoJ;
    private TextView tvEdadJ;
    private EditText etEdadJ;
    private TextView tvAlturaJ;
    private EditText etAlturaJ;
    private TextView tvPesoJ;
    private EditText etPesoJ;
    private TextView tvDeHabitualJ;
    private EditText etDeHabitualJ;
    private TextView tvDeSecundariaJ;
    private EditText etDeSecundariaJ;
    private TextView tvPDominanteJ;
    private EditText etPDominanteJ;
    private TextView tvLesionesJ;
    private EditText etLesionesJ;
    private TextView tvEAnterioresJ;
    private EditText etEAnterioresJ;
    private FloatingActionButton anadir;
    private static BdJugador bd;
    private static final int REQUEST_IMAGE = 100;
    private static final int REQUEST_IMAGE_CAMERA = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugador);


        tvJugadorJ = (TextView) findViewById(R.id.tvJugadorJ);
        ivFotoJ = (ImageView) findViewById(R.id.ivFotoJ);
        tvNombreJ = (TextView) findViewById(R.id.tvNombreJ);
        etNombreJ = (EditText) findViewById(R.id.etNombreJ);
        tvApellidosJ = (TextView) findViewById(R.id.tvApellidosJ);
        etApellidosJ = (EditText) findViewById(R.id.etApellidosJ);
        tvNDeportivoJ = (TextView) findViewById(R.id.tvNDeportivoJ);
        etNDeportivoJ = (EditText) findViewById(R.id.etNDeportivoJ);
        tvEdadJ = (TextView) findViewById(R.id.tvEdadJ);
        etEdadJ = (EditText) findViewById(R.id.etEdadJ);
        tvAlturaJ = (TextView) findViewById(R.id.etAlturaJ);
        etAlturaJ = (EditText) findViewById(R.id.etAlturaJ) ;
        tvPesoJ = (TextView) findViewById(R.id.tvPesoJ);
        etPesoJ = (EditText) findViewById(R.id.etPesoJ);
        tvDeHabitualJ = (TextView) findViewById(R.id.tvDeHabitualJ);
        etDeHabitualJ = (EditText) findViewById(R.id.etDeHabitualJ);
        tvDeSecundariaJ = (TextView) findViewById(R.id.tvDeSecundariaJ);
        etDeSecundariaJ = (EditText) findViewById(R.id.etDeSecundariaJ);
        tvPDominanteJ = (TextView) findViewById(R.id.tvPDominanteJ);
        etPDominanteJ = (EditText) findViewById(R.id.etPDominanteJ);
        tvLesionesJ = (TextView) findViewById(R.id.tvLesionesJ);
        etLesionesJ = (EditText) findViewById(R.id.etLesionesJ);
        tvEAnterioresJ = (TextView) findViewById(R.id.tvEAnterioresJ);
        etEAnterioresJ = (EditText) findViewById(R.id.etEAnterioresJ);
        anadir= (FloatingActionButton) findViewById(R.id.btnAnadir);
        anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    insertarJugador();
                    Log.d("Valor","Hola");
                }
            }

        );
        ivFotoJ.setOnClickListener(new View.OnClickListener() {
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

                        ivFotoJ.setImageURI(selectedImage);

                    } catch(Exception e)
                {
                    e.printStackTrace();
                }


        }
    }

    public void insertarJugador(){
        bd=new BdJugador(this,"BDEquipos",null,1);
        SQLiteDatabase sq=bd.getWritableDatabase();
        SQLiteDatabase myDataBase =SQLiteDatabase
                .openDatabase(sq.getPath(),
                        null,
                        SQLiteDatabase.OPEN_READWRITE);
        //myDataBase.execSQL("INSERT INTO EQUIPO(NOMBRE)VALUES('"+"GRANADA"+"')");
        myDataBase.execSQL("INSERT INTO JUGADOR(NOMBRE,APELLIDOS,NOMBREDEPORT,EDAD,ALTURA,PESO,DEMARCACIONPRI,DEMARCACIONSEC,PIE,LESIONES,EQUIPOSPRO,FOTO,TIPO,IDEQUIP) VALUES('"+etNombreJ.getText()+"','"+etApellidosJ.getText()+"','"
        +etNDeportivoJ.getText()+"',"+ etEdadJ.getText()+","+etAlturaJ.getText()+","+etPesoJ.getText()+",'"+etDeHabitualJ.getText()+"','"+
        etDeSecundariaJ.getText()+"','"+etPDominanteJ.getText()+"','"+etLesionesJ.getText()+"','"+etEAnterioresJ.getText()+"','"+""+"',"+"'S'"+",1)");
        /*Cursor c=myDataBase.rawQuery("SELECT * FROM JUGADOR",null);
        if (c.moveToFirst()){
            do {
                // Passing values
                String column1 = c.getString(0);
                String column2 = c.getString(1);
                String column3 = c.getString(2);
                Log.d("Valores",column1 + " " + column2 +" " + column3);
                // Do something Here with values
            } while(c.moveToNext());
        }
        c.close();*/

    }
}
