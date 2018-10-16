package br.com.john.moviemobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaFilmesActivity extends AppCompatActivity {

    public static final String FILME = "br.com.john.moviemobile.filme";
    Activity atividade;
    Filme filme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        atividade = this;
        filme = new Filme();
        Intent intent = getIntent();
        String genero = intent.getStringExtra(MainActivity.CHAVE);

        ListView listView = (ListView) findViewById(R.id.lista_filmes);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, filme.getListaNomes(genero));
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalheFilmeActivity.class);
                intent.putExtra(FILME, parent.getItemIdAtPosition(position));
                startActivity(intent);
            }

        });
    }
}
