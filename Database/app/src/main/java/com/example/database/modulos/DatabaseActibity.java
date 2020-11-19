package com.example.database.modulos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.database.Database.DatabaseHelper;
import com.example.database.Database.PessoasDao;
import com.example.database.R;

public class DatabaseActibity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        PessoasDao  pessoasDao = new PessoasDao(getApplicationContext());

        //Insere valores
        ContentValues insertValues = new ContentValues();
        insertValues.put("nome","Maria");
        insertValues.put("idade",15);
        //pessoasDao.create(contentValues);

        //Atualiza
        ContentValues updateValues = new ContentValues();
        updateValues.put("idade",16);
        pessoasDao.upadate(updateValues,"Maria");

        //Deleta
        pessoasDao.delete("Maria");

        //Retorna valores
        String consultaTabelaPessoas = "SELECT * FROM " + DatabaseHelper.TABELA_PESSOAS;
        Cursor cursor = pessoasDao.read(consultaTabelaPessoas);
        percorreDados(cursor);




        /*
        try(SQLiteDatabase appDb = openOrCreateDatabase("app_db", MODE_PRIVATE, null)){

            //Criando tabela
            appDb.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(50) NOT NULL, idade INTEGER(3) NOT NULL)");

            //Inserindo valores
            //appDb.execSQL("INSERT INTO pessoas(nome,idade) VALUES('Karla',18)");

            //Atualizando valores
            //appDb.execSQL("UPDATE pessoas SET idade = 25 WHERE nome = 'Juliana'");

            //Deletando valores de uma tabela
            //appDb.execSQL("DELETE FROM pessoas WHERE nome = 'Juliana'");

            //Deleta uma tabela do banco de dados
            //appDb.execSQL("DROP TABLE IF EXISTS pessoas");

            //Recuperando valores
            Cursor cursor = appDb.rawQuery("SELECT * from pessoas", null);
            Log.i("Tamanho", "" + cursor.getCount());
            //cursor.moveToFirst();
            //System.out.println("Nome: " + cursor.getString(cursor.getColumnIndex("Nome")));
            percorreDados(cursor);
            //Recuperando valores filtrados
            //Cursor filtroIdade = appDb.rawQuery("SELECT id, nome,idade from pessoas WHERE idade > '18'",null);

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("ERRO OCORRIDO: " + e.getMessage());
        }
        */
    }

    public void percorreDados(Cursor cursor){
        int columId = cursor.getColumnIndex("id");
        int columNome = cursor.getColumnIndex("nome");
        int columIdade = cursor.getColumnIndex("idade");
        cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount(); i ++){
            Log.i("usuario", "id: " + cursor.getString(columId) + " | Nome: " + cursor.getString(columNome) + " | Idade: " + cursor.getString(columIdade));
            cursor.moveToNext();
        }
    }


}
