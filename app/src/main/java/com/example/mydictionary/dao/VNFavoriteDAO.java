package com.example.mydictionary.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mydictionary.database.DatabaseHelper;
import com.example.mydictionary.model.Favorite;
import com.example.mydictionary.model.VNFavorite;

import java.util.ArrayList;
import java.util.List;

public class VNFavoriteDAO {
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;
    public static final String TABLE_NAME_FAV_VN = "VNFavorite";
    public static final String CREATE_TABLE_FAV_VN = "CREATE TABLE VNFavorite(wordFavorite text primary key)";

    public VNFavoriteDAO(Context context) {
        databaseHelper = new DatabaseHelper(context);
        db = databaseHelper.getWritableDatabase();
    }

    public long insertFavorite(VNFavorite vnFavorite) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("wordFavorite", vnFavorite.vnFavoriteword);
        long result = db.insert(TABLE_NAME_FAV_VN, null, contentValues);
        return result;
    }

    public int delFavorite(String word) {
        int result = db.delete(TABLE_NAME_FAV_VN, "wordFavorite=?", new String[]{word});
        return result;
    }

    public List<VNFavorite> getAllWordFavorite() {
        List<VNFavorite> list = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME_FAV_VN, null,
                null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            VNFavorite favorite = new VNFavorite();
            favorite.setVnFavoriteword(cursor.getString(0));

            list.add(favorite);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
