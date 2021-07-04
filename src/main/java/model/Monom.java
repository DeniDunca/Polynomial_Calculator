package model;

public class Monom implements Comparable<Monom> {
    public float coeficient;
    public int exponent;

    //constructori
    public Monom(float coeficient, int exponent) {
        this.coeficient = coeficient;
        this.exponent = exponent;
    }

    public Monom() { }
    //gettere si settere
    public float getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(float coeficient) {
        this.coeficient = coeficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }
    //o functie pentru adunare de monoame ce urmeaza sa fie apelata in polinom
    public Monom adduna(Monom m1, Monom m2) {
        Monom s = new Monom();
        s.setCoeficient((int) m1.coeficient + (int) m2.coeficient);
        s.setExponent(m1.exponent);

        return s;
    }
    //functie de scadere de monoame
    public Monom sccade(Monom m1, Monom m2) {
        Monom s = new Monom();
        s.setCoeficient((int) m1.coeficient - (int) m2.coeficient);
        s.setExponent(m1.exponent);

        return s;
    }
    //toString-ul
    public String toString() {
        String polinom = "";
        if (this.exponent == 0) {                                       //din cazul in care exponentul e 0 verificam daca afisam sau nu coeficientul
            if (this.coeficient != 0) {
                if (this.coeficient < 0) {
                    polinom = polinom + " " + String.valueOf(coeficient);
                } else polinom = polinom + "+" + String.valueOf(coeficient);
            } else {
                polinom = polinom + "+" + " ";
            }
        } else if (this.exponent == 1) {                                //daca exponentul e 1 verificam din nou coeficientul si afisam
            if (this.coeficient == 0) {
                polinom = polinom + "";
            } else {
                if (this.coeficient != 0) {
                    if (this.coeficient < 0) {
                        polinom = polinom + " " + String.valueOf(coeficient) + "x^" + String.valueOf(exponent);
                    } else polinom = polinom + "+" + String.valueOf(coeficient) + "x^" + String.valueOf(exponent);
                } else {
                    if (this.coeficient < 0) {
                        polinom = polinom + " " + "x^" + String.valueOf(exponent);
                    } else {
                        polinom = polinom + "+" + "x^" + String.valueOf(exponent);
                    }
                }
            }
        } else {                                                        //inca o verificare pentru celelalte cazuri ale exponentului
            if (this.coeficient != 0) {
                if (this.coeficient < 0) {
                    polinom = polinom + " " + String.valueOf(coeficient) + "x^" + String.valueOf(exponent);
                } else polinom = polinom + "+" + String.valueOf(coeficient) + "x^" + String.valueOf(exponent);
            } else {
                if (this.coeficient < 0) {
                    polinom = polinom + " " + "x^" + String.valueOf(exponent);
                } else {
                    polinom = polinom + "+" + "x^" + String.valueOf(exponent);
                }
            }
        }
        return polinom;
    }

    public int compareTo(Monom o) {
        if (this.getExponent() > o.getExponent()) {

            return -1;
        }
        if (this.getExponent() < o.getExponent()) {

            return 1;
        }
        return 0;
    }
}