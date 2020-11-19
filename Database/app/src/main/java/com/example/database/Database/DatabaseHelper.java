package com.example.database.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String TABELA_PESSOAS = "pessoas";
    private static  String NAMEDB = "bancodb";
    private static Integer VERSION = 1;


    //Atribuindo os valores para o nome e versão do banco de dados que será criado através do método onCreate.
    public DatabaseHelper(@Nullable Context context) {
        super(context, NAMEDB, null, VERSION);
    }

    //Criar tabela no banco de dados
    @Override
    public void onCreate(SQLiteDatabase db) {
        String comandoCriaTabela = "CREATE TABLE IF NOT EXISTS " + TABELA_PESSOAS + "(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(60) NOT NULL, idade INTEGER(3) NOT NULL)";
        try{
            db.execSQL(comandoCriaTabela);

        }catch (SQLiteException e) {
            Log.i("Exception Create", " Falha ao creatar tabela: " + e.getMessage());
        }
    }


    //Atualizar dados do banco de dados
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL("ALTER TABLE " + TABELA_PESSOAS + " ADD COLUMN telefone VARCHAR(11)");
            db.setVersion(newVersion);
            onCreate(db);
        }catch (SQLiteException e){
            Log.i("Exception Upgrade", "Falha ao atualizar tabela: " + e.getMessage());
        }
    }
}
