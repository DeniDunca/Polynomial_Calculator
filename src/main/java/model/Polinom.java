package model;

import java.util.ArrayList;

public class Polinom extends Monom {
    public ArrayList<Monom> termeni; //declar un arrayList de monoame care sa formeze polinomul
    //constructori
    public Polinom(ArrayList<Monom> termeni) {
        this.termeni = termeni;
    }

    public Polinom() { termeni = new ArrayList<>(); }


    public ArrayList<Monom> getTermeni() {
        return termeni;
    }

    //setter pentru termeni
    public void setTermeni(ArrayList<Monom> termeni) {
        this.termeni = termeni;
    }

    //adaugare de monom pentru teste
    public void add(Monom monom)
    {
        this.termeni.add(monom);
    }
   //toString pentru polinoame care apeleaza toStringul de la monoame intr-un loop
    @Override
    public String toString() {
        String rez = "";
        for (Monom i : termeni) {
            rez = rez + i.toString();
        }
        return rez;
    }
    //functia de adunare
    public Polinom adunare(Polinom polinom2) {
        Polinom rezultat = new Polinom();
        int i = 0, j = 0;
        Monom pol1 = new Monom();
        Monom pol2 = new Monom();
        Monom suma = new Monom();

        int a = this.termeni.size();//cate monoame are primul polinom
        int b = polinom2.termeni.size();//cate monoame are al doilea polinom
        while(i < a || j < b) {// pentru cazul in care puneam de ex 2x^0 si nu avea cu ce compare exponentul
            if (i == a) {
                pol2 = polinom2.termeni.get(j);
                rezultat.termeni.add(pol2);
                i++;
                j++;
                break;
            }
            if (j == b) {
                pol1 = this.termeni.get(i);
                rezultat.termeni.add(pol1);
                j++;
                i++;
                break;
            }
            while (i < a && j < b) {// cat timp mai avem monoame
                pol1 = this.termeni.get(i);//se ia primul monom din primul polinom
                pol2 = polinom2.termeni.get(j);//se ia primul monom din al doilea polinom
                //comparam exponentele intre ele
                if (pol1.getExponent() > pol2.getExponent()) {//il luam pe cel mai mare, aici pe primul monom
                    rezultat.termeni.add(pol1);
                    i++;
                } else {
                    if (pol1.getExponent() < pol2.getExponent()) {// aici al doilea monom
                        rezultat.termeni.add(pol2);
                        j++;
                    } else {
                        suma = suma.adduna(pol1, pol2);//daca sunt egale apelam fuctia adduna care aduna monoame intre ele
                        rezultat.termeni.add(suma);//punem suma in rezultat
                        i++;
                        j++;
                        //trecem la urmatoarele monoame
                    }
                }
            }
        }
        return rezultat;
    }

    public Polinom scadere(Polinom polinom2) {
        Polinom rezultat = new Polinom();
        int i = 0, j = 0;
        Monom pol1 = new Monom();
        Monom pol2 = new Monom();
        Monom dif = new Monom();

        int a = this.termeni.size();
        int b = polinom2.termeni.size();

        while(i < a || j < b) {
            if (i == a) {
                pol2 = polinom2.termeni.get(j);
                rezultat.termeni.add(new Monom(pol2.getCoeficient() * (-1), pol2.getExponent()));//pentru ca atunci cand scadem termenii din al doilea polinom punem minus in fata
                i++;
                j++;
                break;
            }
            if (j == b) {
                pol1 = this.termeni.get(i);
                rezultat.termeni.add(pol1);
                j++;
                i++;
                break;
            }
            while (i < a && j < b) {
                pol1 = this.termeni.get(i);
                pol2 = polinom2.termeni.get(j);

                if (pol1.getExponent() > pol2.getExponent()) {
                    rezultat.termeni.add(pol1);
                    i++;
                } else {
                    if (pol1.getExponent() < pol2.getExponent()) {
                        rezultat.termeni.add(new Monom(pol2.getCoeficient() * (-1), pol2.getExponent()));//la fel ca mai sus cu -1
                        j++;
                    } else {
                        dif = dif.sccade(pol1, pol2);//apeleaza functia de scadere intre monoame
                        rezultat.termeni.add(dif);
                        i++;
                        j++;
                    }
                }
            }
        }
        return rezultat;
    }

    public Polinom derivare(Polinom p) {
        Polinom rezultat = new Polinom();
        for (Monom i : p.termeni) {//parcurgem fiecare monom din polinom
            if (i.getExponent() > 0) {//daca exponentul de mai mare decat 0 putem dereiva, altfel e constanta si oricum da 0 dupa derivare
                rezultat.termeni.add(new Monom(((int) i.getCoeficient() * i.getExponent()), i.getExponent() - 1));//formula de derivare (coef*exp)x^(exp-1)
            }
        }
        return rezultat;
    }

    public Polinom integrare(Polinom p) {
        Polinom rezultat = new Polinom();
        for (Monom i : p.termeni) {//parcurgem fiecare monom din polinom
            if (i.getExponent() > 0) {
                float coef = (i.getCoeficient() / (i.getExponent() + 1));//coef= coef/(exp + 1)
                i.setCoeficient(coef);
                rezultat.termeni.add(new Monom(i.getCoeficient(), i.getExponent() + 1));//exp= exp + 1
            }
        }
        return rezultat;
    }

    public Polinom inmultire(Polinom polinom2) {
        Polinom rezultat = new Polinom();
        ArrayList<Monom> mono = rezultat.getTermeni();//am creat o lista secundara pentru a aduna monoamele cu exponent egal de la rezultat
        for (Monom i : termeni) {//parcurg primul polinom luand fiecare monom
            for (Monom j : polinom2.termeni) {//parcurg al doilea polinom
                rezultat.termeni.add(new Monom(i.getCoeficient() * j.getCoeficient(), i.getExponent() + j.getExponent()));//formula de inmpultire (coef+coef)x^(exp+exp)
            }
        }
        int i = 0, j = 0;//vrem sa adunam monoamele din rezultat care au exp egal
        while(i < mono.size())
        {
            j = i + 1;
            while(j < mono.size())
            {
                if (mono.get(i).getExponent() == mono.get(j).getExponent()){//verificare daca au exponent egal
                    mono.get(i).setCoeficient(mono.get(i).getCoeficient() + mono.get(j).getCoeficient());//adunam monoamele la primul monom
                    mono.remove(j);//stergem al doilea monom din relatie
                }
                j++;
            }
            i++;
        }
        rezultat.setTermeni(mono);//luam monoamele din lista auxiliara si le punem in lista finala
        return rezultat;
    }

}
