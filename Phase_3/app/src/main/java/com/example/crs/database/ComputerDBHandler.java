package com.example.crs.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.crs.model.item.ComputerItem;
import com.example.crs.model.item.ComputerItemType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.LinkedList;

public final class ComputerDBHandler<T extends ComputerItem, E extends ComputerItemType> extends MyDBHandler<T, E> {
    private static final String DATABASE_NAME = "ComputerDB.db";
    private static final String TABLE_NAME = "Computer";
    private static final String COLUMN_ID = "ComputerID";
    private static final String COLUMN_COMPUTER = "ComputerData";
    private static final String COLUMN_NAME = "ComputerName";
    private static final String COLUMN_MODEL = "ComputerModel";
    private static final String COLUMN_URL = "ComputerURL";
    private static final String COLUMN_TYPE = "ComputerType";

    public ComputerDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    // Load all the data
    @Override
    public ArrayList<T> loadHandler() {
        LinkedList<T> data = new LinkedList<>();
        String query = "Select*FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                byte[] computerData_1 = cursor.getBlob(1);
                data.add((T) new Gson().fromJson(new String(computerData_1), new TypeToken<T>(){}.getType()));
            } while (cursor.moveToNext());
            cursor.close();
        }
        db.close();
        return new ArrayList<>(data);
    }

    // Add a data into the database
    @Override
    public void addHandler(T data) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_COMPUTER, new Gson().toJson(data).getBytes());
        values.put(COLUMN_NAME, data.getName());
        values.put(COLUMN_MODEL, data.getModel());
        values.put(COLUMN_URL, data.getUrl());
        values.put(COLUMN_TYPE, data.getComputerItemType().getComputerTypeString(data.getComputerItemType()));
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        Cursor cursor = db.rawQuery("Select*FROM " + TABLE_NAME, null);
        cursor.moveToLast();
        data.setId(cursor.getInt(0));
        cursor.close();
        db.close();
    }

    // Find an item from the database
    @Override
    public ArrayList<T> findHandler(String name) {
        LinkedList<T> data = new LinkedList<>();
        String query = "Select * FROM " + TABLE_NAME + "WHERE " + COLUMN_NAME + " = " + "'" + name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                byte[] computerData_1 = cursor.getBlob(1);
                data.add((T) new Gson().fromJson(new String(computerData_1), new TypeToken<T>(){}.getType()));
            } while (cursor.moveToNext());
            cursor.close();
        }
        db.close();
        return new ArrayList<>(data);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
                "(" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," + COLUMN_COMPUTER + "BLOB," +
                COLUMN_NAME + "TEXT," + COLUMN_MODEL + "TEXT," +
                COLUMN_URL + "TEXT," + COLUMN_TYPE + "TEXT )";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }
}
