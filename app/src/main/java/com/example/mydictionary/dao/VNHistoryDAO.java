package com.example.mydictionary.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mydictionary.database.DatabaseHelper;
import com.example.mydictionary.model.History;
import com.example.mydictionary.model.VNHistory;

import java.util.ArrayList;
import java.util.List;

public class VNHistoryDAO {
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase db;
    public static final String TABLE_NAME_HIS_VN = "HistoryVN";
    public static final String CREATE_TABLE_HIS_VN = "CREATE TABLE HistoryVN(wordHistory text primary key)";
    public VNHistoryDAO(Context context){
        databaseHelper=new DatabaseHelper(context);
        db=databaseHelper.getWritableDatabase();
    }
    public long insertVNHistory(VNHistory history) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("wordHistory", history.getVnHistoryWord());
        long result = db.insert(TABLE_NAME_HIS_VN, null, contentValues);
        return result;
    }
    public int delVNHistory(String word) {
        int result = db.delete(TABLE_NAME_HIS_VN, "wordHistory=?", new String[]{word});
        return result;
    }

    public List<VNHistory> getAllWordHistory() {
        List<VNHistory> list = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME_HIS_VN, null,
                null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            VNHistory history = new VNHistory();
            history.setVnHistoryWord(cursor.getString(0));

            list.add(history);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
    public VNHistory getWordHistory() {
        VNHistory history = new VNHistory();
        Cursor cursor = db.query(TABLE_NAME_HIS_VN, null,
                null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {

            history.setVnHistoryWord(cursor.getString(0));


            cursor.moveToNext();
        }
        cursor.close();
        return history;
    }
}
