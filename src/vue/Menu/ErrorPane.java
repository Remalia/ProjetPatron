package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ErrorPane extends MenuAbstract {

    private static ErrorPane instance;
    private String errorText;

    @Override
    public String getNameFrame() {
        return "Error Pane";
    }

    private ErrorPane(){
        this.setName("Error");
        this.setBackground(ThemeView.getInstance().getColor());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.errorText = "Les erreurs s'affichent ici";
        JLabel label = new JLabel(errorText);
        label.setForeground(Color.RED);
        this.add(label);
    }

    @Override
    public void reScaleAllComponentsImg() throws IOException {

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
