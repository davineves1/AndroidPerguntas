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
import br.com.jp.joojdeperguntas.pojo.Perguntas;

public class EditarValores extends AppCompatActivity {
    Button btnVoltar, btnEditar;
    EditText textPergunta, textAltA, textAltB, textAltC, textAltD, textAltCorreta;
    SQLiteDatabase db;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.valores_editar);

        textPergunta = findViewById(R.id.editTextEditarPergunta);
        textAltA = findViewById(R.id.editTextEditarAltA);
        textAltB = findViewById(R.id.editTextEditarAltB);
        textAltC = findViewById(R.id.editTextEditarAltC);
        textAltD = findViewById(R.id.editTextEditarAltD);
        textAltCorreta = findViewById(R.id.editTextEditarAltCorreta);
        btnEditar = findViewById(R.id.buttonEditar2);
        btnVoltar = findViewById(R.id.buttonEditarVoltar);
//        pega os valores passados na tela anterior
        final Intent itAluno = getIntent();
        final Perguntas perguntas = (Perguntas) itAluno.getExtras().getSerializable("objPerguntas");
        textPergunta.setText(perguntas.getQuestao());
        textAltA.setText(perguntas.getAltA());
        textAltB.setText(perguntas.getAltB());

        textAltC.setText(perguntas.getAltC());
        textAltD.setText(perguntas.getAltD());
        textAltCorreta.setText(perguntas.getAltCorreta());

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("questao", textPergunta.getText().toString());
                values.put("alt_a", textAltA.getText().toString());
                values.put("alt_b", textAltB.getText().toString());
                values.put("alt_c", textAltC.getText().toString());
                values.put("alt_d", textAltD.getText().toString());
                values.put("alt_correta", textAltCorreta.getText().toString());


                Perguntas novosDados = new Perguntas();
                novosDados.setQuestao(textPergunta.getText().toString());
                novosDados.setAltA(textAltA.getText().toString());
                novosDados.setAltB(textAltB.getText().toString());
                novosDados.setAltC(textAltC.getText().toString());
                novosDados.setAltD(textAltD.getText().toString());
                novosDados.setAltCorreta( textAltCorreta.getText().toString());

            // faz um update na tabela com os novos valores
                db = openOrCreateDatabase("db_perguntas", Context.MODE_PRIVATE, null);
                db.execSQL("UPDATE perguntas SET " +
                        "questao='"+novosDados.getQuestao()+"',"+
                        "alt_a= '" +novosDados.getAltA()+"',"+
                        "alt_b ='" +novosDados.getAltB()+"',"+
                        "alt_c ='" +novosDados.getAltC()+"',"+
                        "alt_d ='" +novosDados.getAltD()+"',"+
                        "alt_correta ='" +novosDados.getAltCorreta()+"'"+
                        " WHERE id= "+ perguntas.getId()+";"
                );

                Intent voltar = new Intent(getApplicationContext(), Editar.class);
                startActivity(voltar);
            }
        });
        // botão pra voltar para tela anterior
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar = new Intent(getApplicationContext(), Editar.class);
                startActivity(voltar);
            }
        });
    }
}
