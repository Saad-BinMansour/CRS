package com.example.crs.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public abstract class MyDBHandler<T,E> extends SQLiteOpenHelper {
    protected static final int DATABASE_VERSION = 1;

    public MyDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public abstract ArrayList<T> loadHandler();

    public abstract void addHandler(T data);

    public abstract ArrayList<T> findHandler(String name);
}
