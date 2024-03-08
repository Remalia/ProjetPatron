package ProjetPatron.src.controller.Bouton.menus;

import ProjetPatron.src.controller.Bouton.Button;
import ProjetPatron.src.controller.State.StateAjoutTriangle;

import java.awt.*;

public class ButtonJouer extends Button {


    public ButtonJouer(String name) {
        super(name);
        this.addActionListener(e -> System.out.println("FDP"));
    }

    public ButtonJouer(Image image){
        super(image);
    }
}
