package ProjetPatron.src.controller.Graphics.Pane;

import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.*;

public class ErrorPane extends JPanel {

    private static ErrorPane instance;

    private ErrorPane(){
        this.setName("Error");
        this.setBackground(ThemeView.getInstance().getColor());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        //TODO print dans label un texte d'erreur en rouge
    }

    public static ErrorPane getInstance(){
        if(instance == null){
            instance = new ErrorPane();
        }
        return instance;
    }

}
