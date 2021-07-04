package view;


import model.ModelCalc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewCalc extends JFrame {
    //declararea obiectelor ce urmeaza sa fie folosite
    private final JLabel m_titlu = new JLabel("Calculator de polinoame");
    private final JLabel m_cerinta = new JLabel("Introduceti doua polinoame: ");
    private final JLabel m_textpol1 = new JLabel("Primul polinom: ");
    private final JLabel m_textpol2 = new JLabel("Al doilea polinom: ");
    private final JLabel m_textrez = new JLabel("Rezultat: ");
    private final JTextField m_polinom1 = new JTextField(15);
    private final JTextField m_polinom2 = new JTextField(15);
    private final JTextField m_rezultat = new JTextField(20);
    private final JButton m_adunare = new JButton("Adunare ");
    private final JButton m_scadere = new JButton("Scadere ");
    private final JButton m_inmultire = new JButton("Inmultire");
    private final JButton m_impartire = new JButton("Impartire");
    private final JButton m_derivare = new JButton("Derivare");
    private final JButton m_integrare = new JButton("Integrare");
    private final JButton m_exit = new JButton("Exit");

    private final ModelCalc m_model;

    public ViewCalc(ModelCalc m_model) {
        this.m_model = m_model;
        //panelul cu titlul
        JPanel content1 = new JPanel();
        content1.setLayout(new FlowLayout());
        content1.setBackground(Color.decode("#eee6ff"));
        content1.add(m_titlu);
        //panelul cu cerinta
        JPanel content2 = new JPanel();
        content2.setLayout(new FlowLayout());
        content2.setBackground(Color.decode("#dcccff"));
        content2.add(m_cerinta);
        //panelul cu labelul si textfieldul pentru primul polinom
        JPanel content3 = new JPanel();
        content3.setLayout(new FlowLayout());
        content3.setBackground(Color.decode("#cbb3ff"));
        content3.add(m_textpol1);
        content3.add(m_polinom1);
        //panelul cu labelul si textfieldul pentru al doilea polinom
        JPanel content4 = new JPanel();
        content4.setLayout(new FlowLayout());
        content4.setBackground(Color.decode("#b999ff"));
        content4.add(m_textpol2);
        content4.add(m_polinom2);
        //panelul cu labelul si textfieldul pentru rezultat
        JPanel content5 = new JPanel();
        content5.setLayout(new FlowLayout());
        content5.setBackground(Color.decode("#a880ff"));
        content5.add(m_textrez);
        content5.add(m_rezultat);
        //panelul cu butoanele de adunare si scadere
        JPanel content6 = new JPanel();
        content6.setLayout(new FlowLayout());
        content6.setBackground(Color.decode("#9666ff"));
        content6.add(m_adunare);
        content6.add(m_scadere);
        //panelul cu butoanele de inmultire si impartire
        JPanel content7 = new JPanel();
        content7.setLayout(new FlowLayout());
        content7.setBackground(Color.decode("#854dff"));
        content7.add(m_inmultire);
        content7.add(m_impartire);
        //panelul cu butoanele de derivare si integrare
        JPanel content8 = new JPanel();
        content8.setLayout(new FlowLayout());
        content8.setBackground(Color.decode("#7433ff"));
        content8.add(m_derivare);
        content8.add(m_integrare);
        //panelul cu butonul de exit
        JPanel content9 = new JPanel();
        content9.setLayout(new FlowLayout());
        content9.setBackground(Color.decode("#621aff"));
        content9.add(m_exit);
        //unirea tuturor panelurilor secundare in panelul principal
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add(content1);
        content.add(content2);
        content.add(content3);
        content.add(content4);
        content.add(content5);
        content.add(content6);
        content.add(content7);
        content.add(content8);
        content.add(content9);

        this.setContentPane(content);
        this.pack();
        this.setTitle("Calculator de polinoame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 350);
    }
    //declarare de listere la butoane
    public void addAdunareListener(ActionListener add) {
        m_adunare.addActionListener(add);
    }

    public void addScadereListener(ActionListener sub) {
        m_scadere.addActionListener(sub);
    }

    public void addDerivareListener(ActionListener der) {
        m_derivare.addActionListener(der);
    }

    public void addIntegrareListener(ActionListener ing) {
        m_integrare.addActionListener(ing);
    }

    public void addInmultireListener(ActionListener inm) {
        m_inmultire.addActionListener(inm);
    }

    public void addExitListener(ActionListener ext) {
        m_exit.addActionListener(ext);
    }

    public void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }
    //gettere si settere
    public String getFirstPolinom() {
        return this.m_polinom1.getText();
    }

    public String getSecondPolinom() {
        return this.m_polinom2.getText();
    }

    public void setRezultat(String rez) {
        this.m_rezultat.setText(rez);
    }

}
