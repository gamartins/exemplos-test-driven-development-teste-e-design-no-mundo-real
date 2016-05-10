package br.com.martinsdev;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gabriel on 5/4/16.
 */
public class CarrinhoDeCompras {
    List<Produto> produtos;

    public CarrinhoDeCompras() {
        this.produtos = new ArrayList<>();
    }

    public CarrinhoDeCompras(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adiciona(Produto produto){
        produtos.add(produto);
    }
}
