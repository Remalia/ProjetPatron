package ProjetPatron.src.controller.Graphics.Pane;

import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.*;

public class ErrorPane extends JPanel {

    private static ErrorPane instance;
    private String errorText;

    private ErrorPane(){
        this.setName("Error");
        this.setBackground(ThemeView.getInstance().getColor());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.errorText = "Les erreurs s'affichent ici";
        JLabel label = new JLabel(errorText);
        label.setForeground(Color.RED);
        this.add(label);
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public static ErrorPane getInstance(){
        if(instance == null){
            instance = new ErrorPane();
        }
        return instance;
    }

}
