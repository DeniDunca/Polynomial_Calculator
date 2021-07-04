package controller;

import model.ModelCalc;
import model.Polinom;
import view.ViewCalc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerCalc {
    private ModelCalc m_model;
    private ViewCalc m_view;

    public ControllerCalc(ModelCalc model, ViewCalc view) {
        m_model = model;
        m_view = view;

        view.addAdunareListener(new AdunareListener());
        view.addScadereListener(new ScadereListener());
        view.addDerivareListener(new DerivareListener());
        view.addIntegrareListener(new IntegrareListener());
        view.addInmultireListener(new InmultireListener());
        view.addExitListener(new ExitListener());
    }

    //listenere pentru fiecare buton in parte
    private class AdunareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String p1 = m_view.getFirstPolinom();//citim primul polinom
            String p2 = m_view.getSecondPolinom();//citim al doilea polinom
            Polinom p11 = m_model.regex(p1);//verificam patternul cu regex pentru primul polinom
            Polinom p22 = m_model.regex(p2);//verificam patternul cu regex pentru al doilea polinom
            Polinom rez = p11.adunare(p22);// apelam metoda de adunare penrtu polinoame
            m_view.setRezultat(rez.toString());//punem rezultatul ca si string in textfieldul pentru rezultate
        }
    }

    private class ScadereListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String p1 = m_view.getFirstPolinom();
            String p2 = m_view.getSecondPolinom();
            Polinom p11 = m_model.regex(p1);
            Polinom p22 = m_model.regex(p2);
            Polinom rez = p11.scadere(p22);
            m_view.setRezultat(rez.toString());
        }
    }

    private class DerivareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String p1 = m_view.getFirstPolinom();
            Polinom rez = new Polinom();
            Polinom p11 = m_model.regex(p1);
            m_view.setRezultat(rez.derivare(p11).toString());
        }
    }

    private class IntegrareListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String p1 = m_view.getFirstPolinom();
            Polinom rez = new Polinom();
            Polinom p11 = m_model.regex(p1);
            m_view.setRezultat(rez.integrare(p11).toString());
        }
    }

    private class InmultireListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String p1 = m_view.getFirstPolinom();
            String p2 = m_view.getSecondPolinom();
            Polinom p11 = m_model.regex(p1);
            Polinom p22 = m_model.regex(p2);
            Polinom rez = p11.inmultire(p22);
            m_view.setRezultat(rez.toString());
        }
    }

    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
