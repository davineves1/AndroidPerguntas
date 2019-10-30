package br.com.jp.joojdeperguntas.crud;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.com.jp.joojdeperguntas.R;
import br.com.jp.joojdeperguntas.controller.Config;
import br.com.jp.joojdeperguntas.pojo.Perguntas;

public class Inserir extends AppCompatActivity {
    Button btnVoltar, btnInserir;
    EditText textPergunta, textAltA, textAltB, textAltC, textAltD, textAltCorreta;
    SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inserir);
        db = openOrCreateDatabase("db_perguntas", Context.MODE_PRIVATE, null);
        //cria a tabela no database
        db.execSQL("CREATE TABLE IF NOT EXISTS perguntas(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "questao VARCHAR NOT NULL, " +
                "alt_a VARCHAR NOT NULL, " +
                "alt_b VARCHAR NOT NULL, " +
                "alt_c VARCHAR NOT NULL," +
                "alt_d VARCHAR NOT NULL," +
                "alt_correta VARCHAR NOT NULL);");

        textPergunta = findViewById(R.id.editTextInserirPergunta);
        textAltA = findViewById(R.id.editTextInserirAltA);
        textAltB = findViewById(R.id.editTextInserirAltB);
        textAltC = findViewById(R.id.editTextInserirAltC);
        textAltD = findViewById(R.id.editTextInserirAltD);
        textAltCorreta = findViewById(R.id.editTextInserirAltCorreta);
        btnInserir = findViewById(R.id.buttonEditar2);
        btnVoltar = findViewById(R.id.buttonInserirVoltar);
        //insere valores ao clickar no botão
        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Perguntas perguntas = new Perguntas(null ,textPergunta.getText().toString(),
                            textAltA.getText().toString(),
                            textAltB.getText().toString(),
                            textAltC.getText().toString(),
                            textAltD.getText().toString(),
                            textAltCorreta.getText().toString());
                    ContentValues values = new ContentValues();
                    values.put("questao", perguntas.getQuestao());
                    values.put("alt_a", perguntas.getAltA());
                    values.put("alt_b", perguntas.getAltB());
                    values.put("alt_c", perguntas.getAltC());
                    values.put("alt_d", perguntas.getAltD());
                    values.put("alt_correta", perguntas.getAltCorreta());

                    db.insert("perguntas", null, values);
//                    Message message = new Message(Inserir.this);
//                    message.show( "Dados incluídos com sucesso!",
//                            perguntas.toString(),
//                            null);
                } catch (Throwable e) {
                    System.out.println(e);
                }
            }
        });
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar = new Intent(getApplicationContext(), Config.class);
                startActivity(voltar);
            }
        });
    }
}

