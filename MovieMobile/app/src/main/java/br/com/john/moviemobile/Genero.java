package br.com.john.moviemobile;

import java.util.ArrayList;
import java.util.List;

public class Genero {
    private int id;
    private String nome;
    private List<Genero> list;

    public Genero(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public Genero(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Genero> getList() {
        return list;
    }

    public void setList(ArrayList<Genero> list) {
        this.list = list;
    }

    public List<Genero> gerarLista(){
        Genero g1 = new Genero(1, "Aventura");
        Genero g2 = new Genero(2, "Ação");

        this.list.add(g1);
        this.list.add(g2);

        return list;
    }

    public List<String> getGeneroNomeList(){
        ArrayList<String> list = new ArrayList<>();

        for (Genero g : this.getList()) {
            list.add(g.getNome());
        }

        return list;
    }
}

