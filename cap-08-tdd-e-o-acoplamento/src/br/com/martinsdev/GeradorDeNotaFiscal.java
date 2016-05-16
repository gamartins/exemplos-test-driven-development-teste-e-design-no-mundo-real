package br.com.martinsdev;

import java.util.Calendar;
import java.util.List;

/**
 * Created by gabriel on 5/11/16.
 */
public class GeradorDeNotaFiscal {
    private final List<AcaoAposGerarNota> acoes;
    private final Relogio relogio;
    private final Tabela tabela;

    public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acoes, Tabela tabela, Relogio relogio){
        this.acoes = acoes;
        this.relogio = relogio;
        this.tabela = tabela;
    }

    public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acoes, Tabela tabela) {
        this.acoes = acoes;
        this.relogio = new RelogioDoSistema();
        this.tabela = tabela;
    }

    public NotaFiscal gera(Pedido pedido) {
        NotaFiscal nf = new NotaFiscal(pedido.getCliente(),
                pedido.getValorTotal() * tabela.paraValor(pedido.getValorTotal()), relogio.hoje());

        for (AcaoAposGerarNota acao : acoes){
            acao.executa(nf);
        }

        return nf;
    }
}
