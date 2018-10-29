package br.com.john.moviemobile;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ListaFilmesActivity extends AppCompatActivity {

    public static final String FILME = "br.com.john.moviemobile";
    Activity atividade;
    Filme filme;
    List<Filme> filmeList;
    FilmeArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        atividade = this;
        filme = new Filme();

        Intent intent = getIntent();
        String genero = intent.getStringExtra(MainActivity.CHAVE);
        ListView listView = (ListView) findViewById(R.id.lista_filmes);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, filme.getListaNomes(genero));
        //FilmeArrayAdapter adapter = new FilmeArrayAdapter(this, filme.getFilmesPorGenero(genero));
        WebServiceClient client = new WebServiceClient();
        client.execute("filmes/" + genero);

        filmeList = new ArrayList<Filme>();
        adapter = new FilmeArrayAdapter(this, filmeList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalheFilmeActivity.class);
                intent.putExtra(FILME, filme.getList().get(position).getTitulo());
                startActivity(intent);
            }
        });
    }

    private class WebServiceClient extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... parameter) {
            try{
                URL url = createURL(parameter[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream stream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                String linha = null;
                StringBuilder stringBuilder = new StringBuilder ("");
                while ((linha = reader.readLine()) != null){
                    stringBuilder.append(linha);
                }
                return stringBuilder.toString();
            }
            catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
        @Override
        protected void onPostExecute(String json) {
            //Toast.makeText(MainActivity.this, json, Toast.LENGTH_SHORT).show();
            try {
                filmeList.clear();
                Gson gson = new Gson();
                FilmeListData films = gson.fromJson(json, FilmeListData.class);
                for (Filme data : films.getList()) {
                    filmeList.add(data);
                }
                adapter.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private URL createURL (String parameter){
        try{
            String baseURL = getString(R.string.web_service_url);
            String urlString = baseURL + parameter;
            return new URL(urlString);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
