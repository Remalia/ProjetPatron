package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ErrorPane extends MenuAbstract {

    private static ErrorPane instance;
    private JLabel errorLabel;

    @Override
    public String getNameFrame() {
        return "Error Pane";
    }

    private ErrorPane(){
        this.setName("Error");
        this.setBackground(ThemeView.getInstance().getColor());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        errorLabel = new JLabel("Les erreurs s'affichent ici");
        errorLabel.setForeground(Color.RED);
        this.add(errorLabel);
    }

    @Override
    public void reScaleAllComponentsImg() throws IOException {

    }

    public void setErrorText(String errorText) {
        this.errorLabel.setText(errorText);
    }

    public static ErrorPane getInstance(){
        if(instance == null){
            instance = new ErrorPane();
        }
        return instance;
    }

}
