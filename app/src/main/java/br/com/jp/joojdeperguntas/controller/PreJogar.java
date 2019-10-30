package br.com.jp.joojdeperguntas.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.com.jp.joojdeperguntas.R;

public class PreJogar extends AppCompatActivity {
    EditText textNick;
    Button btnIniciar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jogar);

        textNick = findViewById(R.id.editTextNick);
        btnIniciar = findViewById(R.id.buttonIniciar);



    // botão pega o nick digitado
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nick = textNick.getText().toString();
               Intent iniciar =  new Intent(getApplicationContext(),Jogar.class);
               startActivity(iniciar);
            }
        });
    }
}
