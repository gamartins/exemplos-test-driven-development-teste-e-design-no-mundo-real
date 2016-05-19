package br.com.martinsdev;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabriel on 5/17/16.
 */
public class Fatura {
    private String cliente;
    private double valor;
    private List<Pagamento> pagamentos;
    private boolean pago;

    public Fatura(String cliente, double valor){
        this.cliente = cliente;
        this.valor = valor;
        this.pagamentos = new ArrayList<Pagamento>();
        this.pago = false;
    }

    public String getCliente() {
        return cliente;
    }

    public double getValor() {
        return valor;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public boolean isPago() {
        return pago;
    }

    private void adicionaPagamento(Pagamento pagamento){
        this.pagamentos.add(pagamento);

        double valorTotal = 0;

        for (Pagamento p : pagamentos){
            valorTotal += p.getValor();
        }

        if (valorTotal >= this.valor) {
            this.pago = true;
        }
    }

    // Método removido de ProcessadorDeBoletos porque melhor se encaixa em fatura
    public void processa(List<Boleto> boletos){
        for (Boleto boleto : boletos) {
            Pagamento pagamento = new Pagamento(boleto.getValor(), MeioDePagamento.BOLETO);
            this.adicionaPagamento(pagamento);
        }
    }

}
