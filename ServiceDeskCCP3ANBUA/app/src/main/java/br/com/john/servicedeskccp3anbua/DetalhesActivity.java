package br.com.john.servicedeskccp3anbua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class DetalhesActivity extends AppCompatActivity {

    private TextView nomeFilaTextView;
    private TextView descicaoChamadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        nomeFilaTextView = findViewById(R.id.nomeFilaTextView);
        descicaoChamadoTextView = findViewById(R.id.descicaoChamadoTextView);

        Intent intent = getIntent();
        Chamado oCaraQueFoiTocado = (Chamado) intent.getSerializableExtra("oCaraQueFoiTocado");
        nomeFilaTextView.setText(oCaraQueFoiTocado.getFila().trim());
        descicaoChamadoTextView.setText(oCaraQueFoiTocado.getDescricao().trim());
    }
}
