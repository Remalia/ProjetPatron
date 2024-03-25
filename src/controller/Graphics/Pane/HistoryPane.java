package ProjetPatron.src.controller.Graphics.Pane;

import ProjetPatron.src.controller.Graphics.Box.ComboBoxResolution;
import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.*;

public class HistoryPane extends JPanel {

    private static HistoryPane instance;

    private HistoryPane(){
        this.setName("History");
        this.setBackground(ThemeView.getInstance().getColor());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        //TODO AFFICHER les 10 derniers figure créer
    }

    public static HistoryPane getInstance(){
        if(instance == null){
            instance = new HistoryPane();
        }
        return instance;
    }

}
