package br.com.martinsdev;

/**
 * Created by gabriel on 5/4/16.
 */
public class Produto {
    private String nome;
    private double valor;

    public Produto(String nome, double valor) {
        this.valor = valor;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
}
