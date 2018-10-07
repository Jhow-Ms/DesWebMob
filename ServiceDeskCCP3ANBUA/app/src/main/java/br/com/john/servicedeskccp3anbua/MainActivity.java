package br.com.john.servicedeskccp3anbua;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {

    private EditText buscaFilaEditText;
    public static final String NOME_FILA = "nome_fila";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buscaFilaEditText = findViewById(R.id.buscaFilaEditText);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener((View view) -> {
            Intent intent = new Intent(this, ListaChamadosActivity.class);
            String texto = buscaFilaEditText.getEditableText().toString();
            intent.putExtra(NOME_FILA, texto);
            startActivity(intent);
        });
    }
}
