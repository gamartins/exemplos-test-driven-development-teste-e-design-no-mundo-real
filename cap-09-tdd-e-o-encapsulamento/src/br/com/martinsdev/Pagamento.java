package br.com.martinsdev;

/**
 * Created by gabriel on 5/17/16.
 */
public class Pagamento {
    private double valor;
    private MeioDePagamento meioDePagamento;

    public Pagamento(double valor, MeioDePagamento meioDePagamento) {
        this.valor = valor;
        this.meioDePagamento = meioDePagamento;
    }

    public double getValor() {
        return valor;
    }

    public MeioDePagamento getMeioDePagamento() {
        return meioDePagamento;
    }
}
