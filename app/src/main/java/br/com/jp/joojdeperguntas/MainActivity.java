package br.com.jp.joojdeperguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.jp.joojdeperguntas.controller.Config;
import br.com.jp.joojdeperguntas.controller.PreJogar;

public class MainActivity extends AppCompatActivity {
    Button btnJogar, btnRanking,btnConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnJogar = findViewById(R.id.buttonJogar);
        btnRanking = findViewById(R.id.buttonRanking);
        btnConfig = findViewById(R.id.buttonConfig);

        btnJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jogar = new Intent(getApplicationContext(), PreJogar.class);
                startActivity(jogar);
            }
        });

        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent config = new Intent(getApplicationContext(), Config.class);
                startActivity(config);
            }
        });
    }
}
