package com.example.crs.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public abstract class MyDBHandler<T> extends SQLiteOpenHelper {
    public MyDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public abstract ArrayList<T> loadHandler();

    public abstract void addHandler(T data);

    public abstract ArrayList<T> findHandler(String name);
}
