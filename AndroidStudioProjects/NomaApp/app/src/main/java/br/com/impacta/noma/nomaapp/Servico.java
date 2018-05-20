package br.com.impacta.noma.nomaapp;

import java.io.Serializable;

/**
 * Created by pR on 29/04/2018.
 */

public class Servico implements Serializable {
    public long id;
    public String nome;
    public int tempo_estimado;
    public int tempo_aplicacao;
    public double preço;

    public Servico(String nome, int tempo_estimado, int tempo_aplicacao, double preço){
        this.nome = nome;
        this.tempo_estimado = tempo_estimado;
        this.tempo_aplicacao = tempo_aplicacao;
        this.preço = preço;
    }
}
