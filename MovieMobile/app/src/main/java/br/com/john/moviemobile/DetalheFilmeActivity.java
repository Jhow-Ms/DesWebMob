package br.com.john.moviemobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetalheFilmeActivity extends AppCompatActivity {
    TextView id, titulo, descricao, anoLancamento, popularidade, direcao, genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_filme);


        id = findViewById(R.id.txtId);
        titulo = findViewById(R.id.txtTitulo);
        descricao = findViewById(R.id.txtDescricao);
        anoLancamento = findViewById(R.id.txtAnoLancamento);
        popularidade = findViewById(R.id.txtPopularidade);
        direcao = findViewById(R.id.txtDirecao);
        genero = findViewById(R.id.txtGenero);

        Intent intent = getIntent();
        String nomeFilme = intent.getStringExtra(ListaFilmesActivity.FILME);

        Filme filme = new Filme();
        filme = filme.buscaFilme(nomeFilme);

        id.setText(String.valueOf(filme.getId()));
        titulo.setText(filme.getTitulo());
        descricao.setText(filme.getDescricao());
        anoLancamento.setText(filme.getAnoLancamento());
        popularidade.setText(String.valueOf(filme.getPopularidade()));
        direcao.setText(filme.getDirecao());
        genero.setText(filme.getGenero().getNome());
    }
}
