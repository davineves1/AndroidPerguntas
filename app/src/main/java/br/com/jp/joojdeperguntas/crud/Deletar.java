package br.com.jp.joojdeperguntas.crud;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import br.com.jp.joojdeperguntas.R;
import br.com.jp.joojdeperguntas.pojo.Perguntas;

public class Deletar extends AppCompatActivity {
    SQLiteDatabase db;
    ListView listView;
    ArrayList<Perguntas> perguntas = new ArrayList<>();
    ArrayAdapter<Perguntas> adaptador;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletar);
        listView = findViewById(R.id.listViewDeletar);

        // faz um select no database
        db = openOrCreateDatabase("db_perguntas", Context.MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM perguntas ORDER BY nome ASC", null);
        while (c.moveToNext()) {
            perguntas.add(new Perguntas(
                    c.getInt(0),
                    c.getString(1),
                    c.getString(2),
                    c.getString(3),
                    c.getString(4),
                    c.getString(5),
                    c.getString(6)));
        }

        // cria um, adaptador e adiciona no listview
        adaptador = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                perguntas);


        listView.setAdapter(adaptador);
        // deleta na tabela ao clckar no item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Perguntas perguntas = (Perguntas) listView.getItemAtPosition(position);
                db.execSQL("DELETE FROM ALUNO WHERE id =" +perguntas.getId()+";");
            }
        });

    }
}
