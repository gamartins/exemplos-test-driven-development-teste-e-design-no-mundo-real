package br.com.martinsdev;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gabriel on 5/9/16.
 */
public class CarrinhoDeComprasTest {
    private CarrinhoDeCompras carrinho;

    @Before
    public void inicializa(){
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
    }

    @Test
    public void deveRetornarZeroSeCarrinhoVazio(){
        assertEquals(0.0, carrinho.maiorValor(), 0.0001);
    }

    @Test
    public void deveRetornarValorDoItemSeCarrinhoComUmElemento(){
        carrinho.adiciona(new Item("Geladeira", 1, 900.0));

        assertEquals(900.0, carrinho.maiorValor(), 0.00001);
    }

    @Test
    public void deveRetornarValorSeCarrinhoContemMuitosElementos(){
        carrinho.adiciona(new Item("Geladeira", 1, 900.0));
        carrinho.adiciona(new Item("Fogão", 1, 1500.0));
        carrinho.adiciona(new Item("Máquina de Lavar", 1, 750.0));

        assertEquals(1500.0, carrinho.maiorValor(), 0.00001);
    }
}