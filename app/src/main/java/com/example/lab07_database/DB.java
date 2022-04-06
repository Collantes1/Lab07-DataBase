package com.example.lab07_database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {
    public DB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE my_test (my_key TEXT PRIMARY KEY, my_value TEXT);"; // Создание новой таблицы с 2 столбцами
        db.execSQL(sql); // Выполнение запроса
    }

    public void do_insert(String key, String value)
    {
        String sql = "INSERT INTO my_test VALUES('" + key + "', '" + value + "');"; // Вставить новую строку в таблицу
        SQLiteDatabase db = getWritableDatabase(); // Готовность к записи в БД
        db.execSQL(sql); // Выполнить запрос
    }

    public String do_select(String key)
    {
        String sql = "SELECT my_value FROM my_test WHERE my_key = '" + key + "';"; // Найти значение внутри таблицы по заданному ключу
        SQLiteDatabase db = getReadableDatabase(); // Готовность к чтению из БД
        Cursor cur = db.rawQuery(sql, null); // Запуск запроса и получение результата в новой таблице, только с одним столбцом

        if (cur.moveToFirst() == true) // Перейти к первой (и единственной) соответствующей записи, если это возможно
            return cur.getString(0); // Возвращаемое значение из первого столбца (my_value)

        return "(!) not found"; // Возвращать специальный текст, если результатов нет
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
