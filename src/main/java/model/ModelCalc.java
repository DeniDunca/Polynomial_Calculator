package model;


import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModelCalc {
    //metoda de regex pentru a gasi patternul de polinom
    public Polinom regex(String p1) {
        Polinom polinom = new Polinom();

        String poliPattern = "([-+]?\\d*)[xX]\\^(\\d?)";
        //pattern si matcher
        Pattern pattern = Pattern.compile(poliPattern);
        Matcher matcher = pattern.matcher(p1);
        //de fiecare data cand gasim match facem un nou monom si il adaugam in polinom
        while (matcher.find()) {
            int putere = Integer.parseInt(matcher.group(2));
            int coeficient = Integer.parseInt(matcher.group(1));

            Monom monom = new Monom(coeficient, putere);//nou polinom cu elementele din matcher
            polinom.getTermeni().add(monom);//adaugare
        }
        return polinom;
    }
}
