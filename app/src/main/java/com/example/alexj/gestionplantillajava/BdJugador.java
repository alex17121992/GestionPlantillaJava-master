package com.example.alexj.gestionplantillajava;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.IOException;


public class BdJugador extends SQLiteOpenHelper{
    public BdJugador(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version){
        super(context, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //aquí creamos las tablas
        db.execSQL("CREATE TABLE IF NOT EXISTS EQUIPO(\n" +
                "   ID INTEGER CONSTRAINT PK_EQUIPO_ID PRIMARY KEY AUTOINCREMENT,\n" +
                "   NOMBRE VARCHAR(100) NOT NULL);");
        db.execSQL("CREATE TABLE IF NOT EXISTS JUGADOR(\n" +
                "   ID INTEGER CONSTRAINT PK_JUGADOR_ID PRIMARY KEY AUTOINCREMENT,\n" +
                "   NOMBRE VARCHAR(50) NOT NULL,\n" +
                "   APELLIDOS VARCHAR(100) NOT NULL,\n" +
                "   NOMBREDEPORT VARCHAR(100),\n" +
                "   EDAD NUMERIC(2),\n" +
                "   ALTURA NUMERIC(1,2),\n" +
                "   PESO NUMERIC(3,2),\n" +
                "   DEMARCACIONPRI VARCHAR(50),\n" +
                "   DEMARCACIONSEC VARCHAR(50),\n" +
                "   PIE VARCHAR(50),\n" +
                "   LESIONES VARCHAR(1),\n" +
                "   EQUIPOSPRO VARCHAR(100),\n" +
                "   FOTO VARCHAR(100)," +
                "   TIPO VARCHAR(1) NOT NULL," +
                "   IDEQUIP INTEGER CONSTRAINT FK_JUG_EQUIP REFERENCES EQUIPO(ID))" +
                " ;");
        db.execSQL("CREATE TABLE IF NOT EXISTS ENTRENAMIENTO(" +
                "IDENT INTEGER CONSTRAINT PK_ENTR_ID PRIMARY KEY AUTOINCREMENT," +
                "ENTR BLOB" +
                ");");
        db.execSQL("CREATE TABLE IF NOT EXISTS PARTIDOS(" +
                "FECHA VARCHAR(100) CONSTRAINT PK_PARTIDO_FECH PRIMARY KEY," +
                "TARJETASAM NUMERIC(2),\n" +
                "TARJETASROJ NUMERIC(2),\n" +
                "GOLES NUMERIC(2),\n" +
                "CAMBIOS NUMERIC(2),\n" +
                "MINUTOCAMBIO VARCHAR(10)," +
                "EQUIPOLOC VARCHAR(100)," +
                "EQUIPOVIS VARCHAR(100)," +
                "RESULT NUMERIC(2));");
        db.execSQL("CREATE TABLE IF NOT EXISTS PART_JUG(" +
                "FECHA VARCHAR(100)," +
                "IDJUG INTEGER," +
                "TARJETASAM NUMERIC(2),\n" +
                "TARJETASROJ NUMERIC(2),\n" +
                "GOLES NUMERIC(2),\n" +
                "MINGOL VARCHAR(10),\n" +
                "MINUTOCAMBIO VARCHAR(10)," +
                "MINTARJETROJ VARCHAR(10)," +
                "MINTARJETAM VARCHAR(10)," +
                "TITULAR VARCHAR(1)," +
                "PRIMARY KEY(FECHA,IDJUG)," +
                "FOREIGN KEY(FECHA) REFERENCES PARTIDO(FECHA)," +
                "FOREIGN KEY(IDJUG) REFERENCES JUGADOR(ID));");
        db.execSQL("CREATE TABLE IF NOT EXISTS EQUIP_PART(" +
                "FECHA VARCHAR(100)," +
                "ID INTEGER," +
                "PRIMARY KEY(FECHA,ID)," +
                "FOREIGN KEY(FECHA) REFERENCES PARTIDO(FECHA)," +
                "FOREIGN KEY(ID) REFERENCES EQUIPO(ID));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS EQUIPOS");
        db.execSQL("DROP TABLE IF EXISTS JUGADOR");
        db.execSQL("DROP TABLE IF EXISTS ENTRENAMIENTO");
        db.execSQL("DROP TABLE IF EXISTS PARTIDOS");
        db.execSQL("DROP TABLE IF EXISTS PART_JUG");
        db.execSQL("DROP TABLE IF EXISTS EQUIP_PART");
        onCreate(db);
    }

}
