package com.example.crs.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.crs.model.generic.CPU;
import com.example.crs.model.generic.GPU;
import com.example.crs.model.generic.InternalMemory;
import com.example.crs.model.generic.RAM;
import com.example.crs.model.item.Item;
import com.example.crs.model.laptop.ComputerItem;
import com.example.crs.utility.ItemJsonDeserializer;
import com.example.crs.utility.RuntimeTypeAdapterFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.LinkedList;

public final class ComputerDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "ComputerDB.db";
    private static final String TABLE_NAME = "Computer";
    private static Gson gson;

    private enum Column {
        ID(0), COMPUTER_DATA(1), NAME(2), MODEL(3), URL(4), ITEM_TYPE(5), BOOKMARKED(6);
        int columnNumber;
        Column(int i) {
            this.columnNumber = i;
        }
    }

    public ComputerDBHandler(@Nullable Context context, @Nullable SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);

        RuntimeTypeAdapterFactory<Item> itemRuntimeTypeAdapterFactory
                = RuntimeTypeAdapterFactory.of(Item.class, "type")
                .registerSubtype(ComputerItem.class, "ComputerItem")
                .registerSubtype(CPU.class, "CPU")
                .registerSubtype(GPU.class, "GPU")
                .registerSubtype(RAM.class, "RAM")
                .registerSubtype(InternalMemory.class, "InternalMemory");

        gson = new GsonBuilder().registerTypeAdapterFactory(itemRuntimeTypeAdapterFactory).create();
    }

    // Load all the data
    public ArrayList<Item> loadHandler() {
        LinkedList<Item> data = new LinkedList<>();
        String query = "Select*FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                byte[] computerData_1 = cursor.getBlob(Column.COMPUTER_DATA.columnNumber);
                Item temp = new Gson().fromJson(new String(computerData_1), new TypeToken<Item>(){}.getType());
                data.add(temp);
            } while (cursor.moveToNext());
            cursor.close();
        }
        db.close();
        return new ArrayList<>(data);
    }

    // Add a data into the database
    public void addHandler(Item data) {
        ContentValues values = new ContentValues();
        values.put(Column.COMPUTER_DATA.name(), gson.toJson(data, Item.class).getBytes());
        values.put(Column.NAME.name(), data.getName());
        values.put(Column.MODEL.name(), data.getModel());
        values.put(Column.URL.name(), data.getUrl());
        values.put(Column.ITEM_TYPE.name(), data.getItemType().name());

        // Setting the last ID to the inserted data
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        Cursor cursor = db.rawQuery("Select*FROM " + TABLE_NAME, null);
        cursor.moveToLast();
        data.setId(cursor.getInt(Column.ID.columnNumber));

        cursor.close();
        db.close();
    }

    // Find an item from the database
    public ArrayList<Item> findHandler(String name) {
        LinkedList<Item> data = new LinkedList<>();
        String query = "Select * FROM " + TABLE_NAME + " WHERE " + Column.NAME.name() + " = " + "'" + name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                byte[] computerData_1 = cursor.getBlob(Column.COMPUTER_DATA.columnNumber);
                Item temp = gson.fromJson(new String(computerData_1), Item.class);
                data.add(temp);
            } while (cursor.moveToNext());
            cursor.close();
        }
        db.close();
        return new ArrayList<>(data);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
                "( " + Column.ID.name() + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + Column.COMPUTER_DATA.name() + " BLOB, " + Column.NAME.name() + " TEXT, "
                + Column.MODEL.name() + " TEXT, " + Column.URL.name() + " TEXT, "
                + Column.ITEM_TYPE.name() + " TEXT, " + Column.BOOKMARKED.name() + " TEXT )";
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
