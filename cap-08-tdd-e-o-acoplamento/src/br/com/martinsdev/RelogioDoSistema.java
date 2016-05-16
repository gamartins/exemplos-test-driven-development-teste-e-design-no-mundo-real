package br.com.martinsdev;

import java.util.Calendar;

/**
 * Created by gabriel on 5/12/16.
 */
public class RelogioDoSistema implements Relogio {

    @Override
    public Calendar hoje() {
        return Calendar.getInstance();
    }
}
