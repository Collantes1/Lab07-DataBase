package com.example.lab07_database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txt_key; // Текстовые поля
    EditText txt_value; // Текстовые поля

    DB mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_key = findViewById(R.id.txt_key); // Получение текстовых полей
        txt_value = findViewById(R.id.txt_value); // Получение текстовых полей

        // Создание новой или открытие файла БД "mybase.db" с версией 1
        mydb = new DB(this,"mybase.db", null,1);
    }

    public void on_insert_click(View v)
    {
        String key = txt_key.getText().toString(); // Получение строк ключей и значений
        String value = txt_value.getText().toString();

        mydb.do_insert(key, value); // Вставить в таблицу
    }

    public void on_update_click(View v)
    {

    }

    public void on_select_click(View v)
    {
        String key = txt_key.getText().toString(); // получить строку ключа
        String value = mydb.do_select(key); // Поиск значения для этого ключа в таблице

        txt_value.setText(value); // Вывод результата
    }

    public void on_delete_click(View v)
    {

    }

}