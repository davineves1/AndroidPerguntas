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

public class Editar extends AppCompatActivity {
    SQLiteDatabase db;
    ListView listView;
    ArrayList<Perguntas> perguntas = new ArrayList<>();
    ArrayAdapter<Perguntas> adaptador;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_editar);;
        listView = findViewById(R.id.listViewDeletar);
//        select na tabela e adiciona no array

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

//    cria um adaptadore adiciona no listview
        adaptador = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                perguntas);


        listView.setAdapter(adaptador);
        // ao clicar no item, chama a tela pra editar a pergunta
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent editar = new Intent(getApplicationContext(), EditarValores.class);
                editar.putExtra("objPerguntas", perguntas);
                startActivity(editar);
            }
        });
    }

}