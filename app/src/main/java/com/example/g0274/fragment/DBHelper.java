package com.example.g0274.fragment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by g0274 on 2015/12/25.
 */
class DBHelper extends SQLiteOpenHelper {
    private final static int _DBVersion = 1; //<-- 版本
    private final static String _DBName = "TEST.db";  //<-- db name
    private final static String _TableName = "Leave"; //<-- table name

    public DBHelper(Context context) {
        //將變數傳入
        super(context, _DBName,null, _DBVersion);
    }

    @Override
    //載入時找不到生成的資料庫檔案，就會觸發
    public void onCreate(SQLiteDatabase db) {
        final String SQL = "CREATE TABLE IF NOT EXISTS " + _TableName + "( " +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "_NAME VARCHAR(30), " +
                "_DATE VARCHAR(20), " +
                "_CONTENT TEXT," +
                "_STATE VARCHAR(1)" +
                ");";
        db.execSQL(SQL);
    }
    public void InsertDB() {
        //建立、開啟資料庫並回傳資料庫物件
        SQLiteDatabase db=getWritableDatabase();
    }
    @Override
    //資料庫結構有改變了就會觸發
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        final String SQL = "DROP TABLE " + _TableName;
        db.execSQL(SQL);
    }
}
