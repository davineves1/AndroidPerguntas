package br.com.jp.joojdeperguntas.controller;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.com.jp.joojdeperguntas.R;
import br.com.jp.joojdeperguntas.crud.Deletar;
import br.com.jp.joojdeperguntas.crud.Editar;
import br.com.jp.joojdeperguntas.crud.Inserir;

public class Config extends AppCompatActivity {
    Button btnInserir,btnEditar, btnDeletar;
    //botões da tela de congifurações  que mandam para suas respectivas contentviews
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);

        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inserir = new Intent(getApplicationContext(), Inserir.class);
                startActivity(inserir);
            }
        });

        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deletar = new Intent(getApplicationContext(), Deletar.class);
                startActivity(deletar);
            }
        });

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editar = new Intent(getApplicationContext(), Editar.class);
                startActivity(editar);
            }
        });
    }
}
