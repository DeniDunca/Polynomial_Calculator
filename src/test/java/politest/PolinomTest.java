package politest;

import java.util.ArrayList;
import model.Monom;
import model.Polinom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolinomTest {

    Polinom pol1 = new Polinom();
    Polinom pol2 = new Polinom();
    Polinom rezultat = new Polinom();

    @Test
    public void adunareTest(){

        pol1.add(new Monom(7,3));
        pol1.add(new Monom(2,2));
        pol1.add(new Monom(1,1));
        pol1.add(new Monom(3,0));

        pol2.add(new Monom(-2,3));
        pol2.add(new Monom(2,2));


        Polinom pol3 = new Polinom();

        pol3.add(new Monom(5,3));
        pol3.add(new Monom(4,2));
        pol3.add(new Monom(1,1));


        rezultat= pol1.adunare(pol2);

        assertEquals(rezultat.toString(), pol3.toString());
    }

    @Test
    public void scadereTest(){

        pol1.add(new Monom(7,3));
        pol1.add(new Monom(3,2));
        pol1.add(new Monom(1,1));
        pol1.add(new Monom(3,0));

        pol2.add(new Monom(-2,3));
        pol2.add(new Monom(2,2));


        Polinom pol3 = new Polinom();

        pol3.add(new Monom(9,3));
        pol3.add(new Monom(1,2));
        pol3.add(new Monom(1,1));

        rezultat= pol1.scadere(pol2);

        assertEquals(rezultat.toString(), pol3.toString());

    }

    @Test
    public void inmultireTest(){

        pol1.add(new Monom(7,3));
        pol1.add(new Monom(3,2));
        pol1.add(new Monom(1,1));
        pol1.add(new Monom(3,0));

        pol2.add(new Monom(-2,3));
        pol2.add(new Monom(2,2));


        Polinom pol3 = new Polinom();

        pol3.add(new Monom(-14,6));
        pol3.add(new Monom(8,5));
        pol3.add(new Monom(4,4));
        pol3.add(new Monom(-4,3));
        pol3.add(new Monom(6,2));

        rezultat= pol1.inmultire(pol2);

        assertEquals(rezultat.toString(), pol3.toString());
    }

    @Test
    public void derivareTest(){

        pol1.add(new Monom(7,3));
        pol1.add(new Monom(3,2));
        pol1.add(new Monom(1,1));
        pol1.add(new Monom(3,0));

        Polinom pol3 = new Polinom();

        pol3.add(new Monom(21,2));
        pol3.add(new Monom(6,1));
        pol3.add(new Monom(1,0));

        assertEquals(rezultat.derivare(pol1).toString(), pol3.toString());
    }

    @Test
    public void integrareTest(){

        pol1.add(new Monom(7,3));
        pol1.add(new Monom(3,2));
        pol1.add(new Monom(1,1));
        pol1.add(new Monom(3,0));

        Polinom pol3 = new Polinom();

        pol3.add(new Monom(1.75f,4));
        pol3.add(new Monom(1,3));
        pol3.add(new Monom(0.5f,2));

        assertEquals(rezultat.integrare(pol1).toString(), pol3.toString());
    }

    @Test
    public void regexTest()
    {
        String polinom = "+7.0x^3+3.0x^2+1.0x^1+3.0";
        Polinom pol1 = new Polinom();
        pol1.add(new Monom(7,3));
        pol1.add(new Monom(3,2));
        pol1.add(new Monom(1,1));
        pol1.add(new Monom(3,0));

        assertEquals(pol1.toString(),polinom);

    }
}
