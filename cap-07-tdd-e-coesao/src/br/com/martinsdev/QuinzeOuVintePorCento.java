package br.com.martinsdev;

/**
 * Created by gabriel on 5/11/16.
 */
public class QuinzeOuVintePorCento implements RegraDeCalculo {
    @Override
    public double calcula(Funcionario funcionario) {
        if (funcionario.getSalario() < 2500){
            return funcionario.getSalario() * 0.85;
        }

        return funcionario.getSalario() * 0.75;
    }
}
