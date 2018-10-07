package br.com.john.servicedeskccp3anbua;

import java.io.Serializable;

public class Chamado implements Serializable {

    private String fila;
    private String descricao = "";

    public Chamado(String desktops) {
        this.fila = desktops;
    }

    public Chamado(String fila, String descricao) {
        this.fila = fila;
        this.descricao = descricao;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Descrição: " + this.fila + ", Fila: " + this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}