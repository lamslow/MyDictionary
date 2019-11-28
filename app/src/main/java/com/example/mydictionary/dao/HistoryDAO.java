package com.example.mydictionary.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mydictionary.database.DatabaseHelper;
import com.example.mydictionary.model.Favorite;
import com.example.mydictionary.model.History;

import java.util.ArrayList;
import java.util.List;

public class HistoryDAO {
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;
    public static final String TABLE_NAME_HIS = "History";
    public static final String CREATE_TABLE_HIS = "CREATE TABLE History(wordHistory text primary key)";
    public HistoryDAO(Context context){
        databaseHelper=new DatabaseHelper(context);
        db=databaseHelper.getWritableDatabase();
    }
    public long insertHistory(History history) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("wordHistory", history.wordHistory);
        long result = db.insert(TABLE_NAME_HIS, null, contentValues);
        return result;
    }
    public int delHistory(String word) {
        int result = db.delete(TABLE_NAME_HIS, "wordHistory=?", new String[]{word});
        return result;
    }

    public List<History> getAllWordHistory() {
        List<History> list = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME_HIS, null,
                null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            History history = new History();
            history.setWordHistory(cursor.getString(0));

            list.add(history);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
