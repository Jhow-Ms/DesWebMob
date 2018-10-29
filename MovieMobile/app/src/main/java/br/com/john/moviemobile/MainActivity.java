package br.com.john.moviemobile;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class MainActivity extends AppCompatActivity {

    Spinner spinnerGenero;
    public static final String CHAVE = "br.com.john.moviemobile.txtGenero";
    String genero = "Todos";
    Genero _genero;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerGenero = (Spinner) findViewById(R.id.spinnerGenero);
        _genero = new Genero();

        WebServiceClient client = new WebServiceClient();
        client.execute("generos");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, _genero.getGeneroNomeList());
        spinnerGenero.setAdapter(adapter);
        spinnerGenero.setOnItemSelectedListener(new GeneroSelecionado());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ListaFilmesActivity.class);
                intent.putExtra(CHAVE, genero);
                startActivity(intent);
            }
        });
    }

    private class GeneroSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            genero = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
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
                _genero.getList().clear();
                Gson gson = new Gson();
                GeneroListData generoList = gson.fromJson(json, GeneroListData.class);
                for (Genero data : generoList.getList()) {
                    _genero.getList().add(data);
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
