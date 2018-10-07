package br.com.john.servicedeskccp3anbua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
public class ListaChamadosActivity extends AppCompatActivity {

    private ListView listView;
    private List<Chamado> chamado;
    private ChamadosAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_chamados);


        listView = findViewById(R.id.listView);
        chamado = new ArrayList<>();
        Intent intent  = getIntent();
        String valor = intent.getStringExtra(MainActivity.NOME_FILA);
        chamado = buscaChamados(valor);
        adapter = new ChamadosAdapter(chamado,this);
        listView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        ListView.OnItemClickListener itemClickListener =
                (parent, view, position, id) -> {
                    Chamado oCaraQueFoiTocado = chamado.get(position);
//                    Toast.makeText(ListaChamadosActivity.this, oCaraQueFoiTocado, Toast.LENGTH_SHORT).show();

                    Intent detalhesIntent = new Intent(this, DetalhesActivity.class);
                    detalhesIntent.putExtra("oCaraQueFoiTocado", oCaraQueFoiTocado);
                    startActivity(detalhesIntent);
                };

        listView.setOnItemClickListener(itemClickListener);


    }

    public ArrayList<Chamado> buscaChamados(String chave){
        ArrayList<Chamado> lista = geraListaChamados();
        if (chave == null || chave.length() == 0){
            return lista;
        } else {
            ArrayList<Chamado> subLista = new ArrayList<>();
            for(Chamado chamado:lista){
                if(chamado.getDescricao().toUpperCase().contains(chave.toUpperCase())){
                    subLista.add(chamado);
                }
            }
            return subLista;
        }
    }

    public ArrayList<Chamado> geraListaChamados(){
        ArrayList<Chamado> lista = new ArrayList<>();
        lista.add(new Chamado("Desktops", "Computador da secretária quebrado."));
        lista.add(new Chamado("Telefonia", "Telefone não funciona."));
        lista.add(new Chamado("Redes", "Manutenção no proxy."));
        lista.add(new Chamado("Servidores", "Lentidão generalizada."));
        lista.add(new Chamado("Novos Projetos", "CRM"));
        lista.add(new Chamado("Manutenção Sistema ERP", "atualizar versão."));
        lista.add(new Chamado("Novos Projetos", "Rede MPLS"));
        lista.add(new Chamado("Manutenção Sistema de Vendas", "incluir pipeline."));
        lista.add(new Chamado("Manutenção Sistema ERP", "erro contábil"));
        lista.add(new Chamado("Novos Projetos", "Gestão de Orçamento"));
        lista.add(new Chamado("Novos Projetos", "Big Data"));
        lista.add(new Chamado("Manoel de Barros"));
        lista.add(new Chamado("Redes", "Internet com lentidão"));
        lista.add(new Chamado("Novos Projetos", "Chatbot"));
        lista.add(new Chamado("Desktops", "troca de senha"));
        lista.add(new Chamado("Desktops", "falha no Windows"));
        lista.add(new Chamado("Novos Projetos", "ITIL V3"));
        lista.add(new Chamado("Telefonia", "liberar celular"));
        lista.add(new Chamado("Telefonia", "mover ramal"));
        lista.add(new Chamado("Redes", "ponto com defeito"));
        lista.add(new Chamado("Novos Projetos", "ferramenta EMM"));
        return lista;
    }
}
