package br.com.martinsdev;

/**
 * Created by gabriel on 5/5/16.
 */
public class CalculadoraDeSalario {
    public double calculaSalario(Funcionario funcionario) {

        return funcionario.getCargo().getRegra().calcula(funcionario);
    }
}
