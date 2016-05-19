package br.com.martinsdev;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by gabriel on 5/17/16.
 */
public class FaturaTest {
    @Test
    public void deveProcessarPagamentosViaBoletoUnico(){
        Fatura fatura = new Fatura("Cliente", 150.0);
        Boleto b1 = new Boleto(150.0);
        List<Boleto> boletos = Arrays.asList(b1);

        fatura.processa(boletos);

        assertEquals(1, fatura.getPagamentos().size());
        assertEquals(150.0, fatura.getPagamentos().get(0).getValor(), 0.00001);
        assertTrue(fatura.isPago());
    }

    @Test
    public void deveProcessarPagamentoViaMuitosBoletos(){
        Fatura fatura = new Fatura("Cliente", 300.0);

        Boleto b1 = new Boleto(100.0);
        Boleto b2 = new Boleto(200.0);
        List<Boleto> boletos = Arrays.asList(b1, b2);

        fatura.processa(boletos);

        assertEquals(2, fatura.getPagamentos().size());
        assertEquals(100.0, fatura.getPagamentos().get(0).getValor(), 0.00001);
        assertEquals(200.0, fatura.getPagamentos().get(1).getValor(), 0.00001);
        assertTrue(fatura.isPago());
    }

}
