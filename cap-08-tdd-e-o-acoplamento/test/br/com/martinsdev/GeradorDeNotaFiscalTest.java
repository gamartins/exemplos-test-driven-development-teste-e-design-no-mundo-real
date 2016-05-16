package br.com.martinsdev;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by gabriel on 5/11/16.
 */
public class GeradorDeNotaFiscalTest {
    private Tabela tabela;

    // Criado para evitar NullPointerException já que a classe precisa de 'Tabela' para a função 'gera()'
    @Before
    public void inicializa(){
        // Mockando a tabela que ainda não existe
        this.tabela = Mockito.mock(Tabela.class);
    }

    @Test
    public void deveGerarNFComValorDeImpostoDescontado(){
        List<AcaoAposGerarNota> acoes = new ArrayList<>();

        GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(acoes, tabela);
        Pedido pedido = new Pedido("Mauricio", 1000, 1);

        // Modificando valor retornado pela tabela para garantir o funcionamento do teste
        Mockito.when(tabela.paraValor(1000.0)).thenReturn(0.94);
        NotaFiscal nf = gerador.gera(pedido);

        assertEquals(1000 * 0.94, nf.getValor(), 0.00001);
    }

    @Test
    public void deveExecutarAcoesPosteriores(){
        AcaoAposGerarNota acao1 = Mockito.mock(AcaoAposGerarNota.class);
        AcaoAposGerarNota acao2 = Mockito.mock(AcaoAposGerarNota.class);

        List<AcaoAposGerarNota> acoes = Arrays.asList(acao1, acao2);

        GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(acoes, tabela);
        Pedido pedido = new Pedido("Mauricio", 1000, 1);

        NotaFiscal nf = gerador.gera(pedido);

        Mockito.verify(acao1).executa(nf);
        Mockito.verify(acao2).executa(nf);
    }

    @Test
    public void deveConsultarTabelaParaCalcularValor(){
        List<AcaoAposGerarNota> nenhumaAcao = Collections.emptyList();
        GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(nenhumaAcao, tabela);
        Pedido pedido = new Pedido("Mauricio", 1000, 1);

        // Definindo o futuro comportamento "paraValor", que deve retornar 0.2 caso seja 1000.0
        Mockito.when(tabela.paraValor(1000.0)).thenReturn(0.2);

        NotaFiscal nf = gerador.gera(pedido);

        // Garantindo que a tabela foi consultada
        Mockito.verify(tabela).paraValor(1000.0);
        assertEquals(1000 * 0.2, nf.getValor(), 0.00001);
    }

}