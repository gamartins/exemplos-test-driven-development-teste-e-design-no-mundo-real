package br.com.martinsdev;

/**
 * Created by gabriel on 5/5/16.
 */
public enum Cargo {
    DESENVOLVEDOR(new DezOuVintePorCento()),
    DBA(new QuinzeOuVintePorCento()),
    TESTADOR(new QuinzeOuVintePorCento());

    private final RegraDeCalculo regra;

    Cargo(RegraDeCalculo regra) {
        this.regra = regra;
    }

    public RegraDeCalculo getRegra() {
        return regra;
    }
}
