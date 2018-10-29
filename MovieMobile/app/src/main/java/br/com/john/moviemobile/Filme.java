package br.com.john.moviemobile;

import java.util.ArrayList;

public class Filme {

    private int id;
    private String titulo;
    private String descricao;
    private String anoLancamento;
    private String direcao;
    private int popularidade;
    private Genero genero;
    private String iconName;

    private ArrayList<Filme> list = new ArrayList<>();

    public Filme(){}
    public Filme(int id, String titulo, String descricao, String anoLancamento, String direcao, int popularidade, Genero genero, String iconName) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.anoLancamento = anoLancamento;
        this.direcao = direcao;
        this.popularidade = popularidade;
        this.genero = genero;
        this.iconName = iconName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public int getPopularidade() {
        return popularidade;
    }

    public void setPopularidade(int popularidade) {
        this.popularidade = popularidade;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName= iconName;
    }

    public ArrayList<Filme> getList() {
        return list;
    }

    public void setList(ArrayList<Filme> list) {
        this.list = list;
    }

    public ArrayList<Filme> gerarLista(){
        Filme f1 = new Filme(1, "Procurando Nemo", "Descrição testes",
                "20/01/2001", "Direção", 50, new Genero(1, "Aventura"), "image1.png");

        Filme f2 = new Filme(2, "Filme de ação", "Descrição testes",
                "20/01/2001", "Direção", 50, new Genero(2, "Ação"), "image1.png");

        Filme f3 = new Filme(3, "Filme de comédia", "Descrição testes",
                "20/01/2001", "Direção", 50, new Genero(3, "Comédia"), "image1.png");

        getList().add(f1);
        getList().add(f2);
        getList().add(f3);
        return this.list;
    }

    public ArrayList<String> getListaNomes(String genero){
        ArrayList<String> lista = new ArrayList<String>();
        setList(gerarLista());
        for (Filme filme: list) {
            if(genero.equals("Todos"))
                lista.add(filme.getTitulo());

            if(filme.getGenero().getNome().equals(genero))
                lista.add(filme.getTitulo());
        }

        return lista;
    }

    public Filme buscaFilme(String nomeFilme){
        setList(gerarLista());

        for (Filme filme:list) {
            if(filme.getTitulo().equals(nomeFilme))
                return filme;
        }

        return null;
    }

    public ArrayList<Filme> getFilmesPorGenero(String genero){
        ArrayList<Filme> lista = new ArrayList<Filme>();
        setList(gerarLista());
        for (Filme filme: list) {
            if(genero.equals("Todos"))
                lista.add(filme);

            if(filme.getGenero().getNome().equals(genero))
                lista.add(filme);
        }

        return lista;
    }
}
