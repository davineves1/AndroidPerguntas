package br.com.jp.joojdeperguntas.controller;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

import br.com.jp.joojdeperguntas.R;
import br.com.jp.joojdeperguntas.pojo.Perguntas;

public class Jogar extends AppCompatActivity {
    TextView questao, altA, altB, altC, altD;
    SQLiteDatabase db;
    ArrayList<Perguntas> perguntas = new ArrayList<>();
    boolean acertou = false;
    int pontos;
    Random random = new Random();
    public static Perguntas sorteada;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_jogo);
        inserirNoArray();
        questao = findViewById(R.id.textViewPergunta);
        altA = findViewById(R.id.textViewAltA);
        altB = findViewById(R.id.textViewAltB);
        altC = findViewById(R.id.textViewAltC);
        altD = findViewById(R.id.textViewAltD);
        //select no database a adicionando no array de perguntas
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

        iniciarJogo();


//        item com onclick para saber qual foi a alternativa escolhida
        altA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorA = "A";
                if(sorteada.getAltCorreta().toUpperCase().equals(valorA)){
                    acertou = true;
                    pontos = pontos+100;
                    iniciarJogo();
                }
            }
        });

//        item com onclick para saber qual foi a alternativa escolhida
        altB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorA = "B";
                if(sorteada.getAltCorreta().toUpperCase().equals(valorA)){
                    acertou = true;
                    pontos = pontos+100;
                    iniciarJogo();
                }
            }
        });
//        item com onclick para saber qual foi a alternativa escolhida
        altC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorA = "C";
                if(sorteada.getAltCorreta().toUpperCase().equals(valorA)){
                    acertou = true;
                    pontos = pontos+100;
                    iniciarJogo();
                }
            }
        });
//        item com onclick para saber qual foi a alternativa escolhida
        altD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorA = "D";
                if(sorteada.getAltCorreta().toUpperCase().equals(valorA)){
                    acertou = true;
                    pontos = pontos+100;
                    iniciarJogo();
                }
            }
        });
    }
    //metodo faz o sort e seta as perguntas na tela
    private void iniciarJogo() {
        sorteada = perguntas.get(random.nextInt(perguntas.size()));
        questao.setText(sorteada.getQuestao());

        altA.setText("a)"+sorteada.getAltA());
        altB.setText("b)"+sorteada.getAltB());
        altC.setText("c)"+sorteada.getAltC());
        altD.setText("d)"+sorteada.getAltD());
    }
    //metodo cria perguntas para nunca ficar sem perguntas ao iniciar
    public void inserirNoArray() {
        Perguntas pergunta = new Perguntas();
        pergunta.setQuestao("Quem descobriu o Brasil ?");
        pergunta.setAltA("Cristovão Colombo");
        pergunta.setAltB("Pedro Alvares Cabral");
        pergunta.setAltC("Tim Maia");
        pergunta.setAltD("Silvio Santos");
        pergunta.setAltCorreta("B");

        Perguntas pergunta2 = new Perguntas();
        pergunta.setQuestao("Qual a identidade do Batman");
        pergunta.setAltA("Bruce Wayne");
        pergunta.setAltB("Bruce laine");
        pergunta.setAltC("Bruce awayne");
        pergunta.setAltD("Silvio Santos");
        pergunta.setAltCorreta("B");
        perguntas.add(pergunta2);
    }
}
