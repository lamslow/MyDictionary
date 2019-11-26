package com.example.mydictionary.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mydictionary.database.DatabaseHelper;
import com.example.mydictionary.model.Favorite;

import java.util.ArrayList;
import java.util.List;

public class FavoriteDAO {
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;
    public static final String TABLE_NAME_FAV = "Favorite";
    public static final String CREATE_TABLE_FAV = "CREATE TABLE Favorite(wordFavorite text primary key)";

    public FavoriteDAO(Context context) {
        databaseHelper = new DatabaseHelper(context);
        db = databaseHelper.getWritableDatabase();
    }

    public long insertFavorite(Favorite favorite) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("wordFavorite", favorite.wordFavorite);
        long result = db.insert(TABLE_NAME_FAV, null, contentValues);
        return result;
    }

    public int delFavorite(String word) {
        int result = db.delete(TABLE_NAME_FAV, "wordFavorite=?", new String[]{word});
        return result;
    }

    public List<Favorite> getAllWordFavorite() {
        List<Favorite> list = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME_FAV, null,
                null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            Favorite favorite = new Favorite();
            favorite.setWordFavorite(cursor.getString(0));

            list.add(favorite);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
