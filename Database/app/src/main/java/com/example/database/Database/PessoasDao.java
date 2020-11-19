package com.example.database.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PessoasDao {
    private SQLiteDatabase writeDb;
    private SQLiteDatabase readDb;

    public PessoasDao(Context context){
        SQLiteOpenHelper db = new DatabaseHelper(context);
        this.writeDb = db.getWritableDatabase();
        this.readDb = db.getReadableDatabase();
    }

    public long create(ContentValues values){
        return writeDb.insert(DatabaseHelper.TABELA_PESSOAS, null, values);
    }
    public Cursor read(String sql){
        return readDb.rawQuery(sql, null);
    }
    public int upadate(ContentValues newValues, String nome){
        String[] args = {nome};
        return writeDb.update(DatabaseHelper.TABELA_PESSOAS, newValues, "nome = ?", args);
    }
    public int delete(String nome){
        String[] args = {nome};
        return writeDb.delete(DatabaseHelper.TABELA_PESSOAS, "nome = ?", args);
    }


}
