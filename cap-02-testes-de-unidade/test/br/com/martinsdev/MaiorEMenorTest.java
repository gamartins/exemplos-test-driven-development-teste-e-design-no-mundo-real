package br.com.martinsdev;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gabriel on 5/4/16.
 */
public class MaiorEMenorTest {
    @Test
    public void ordemDecrescente() {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adiciona(new Produto("Geladeira", 450.0));
        carrinho.adiciona(new Produto("Liquidificar", 250.0));
        carrinho.adiciona(new Produto("Jogo de Pratos", 70.0));

        MaiorEMenor algoritmo = new MaiorEMenor();
        algoritmo.encontra(carrinho);

        assertEquals("Jogo de Pratos", algoritmo.getMenor().getNome());
        assertEquals("Geladeira", algoritmo.getMaior().getNome());
    }

    @Test
    public void apenasUmProduto(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adiciona(new Produto("Geladeira", 450.0));

        MaiorEMenor algoritmo = new MaiorEMenor();
        algoritmo.encontra(carrinho);

        Assert.assertEquals("Geladeira", algoritmo.getMenor().getNome());
        Assert.assertEquals("Geladeira", algoritmo.getMaior().getNome());
    }
}