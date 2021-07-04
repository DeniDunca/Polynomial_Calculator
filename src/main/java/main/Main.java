package main;

import controller.ControllerCalc;
import model.ModelCalc;
import model.Monom;
import model.Polinom;
import view.ViewCalc;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ModelCalc model = new ModelCalc();//obiect model
        ViewCalc view = new ViewCalc(model);//obiect view
        ControllerCalc controller = new ControllerCalc(model, view);//obiect controller care leaga model si view intre ele

        view.setVisible(true);

    }
}
