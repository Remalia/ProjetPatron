package ProjetPatron.src.controller.Graphics.Pane;

import ProjetPatron.src.vue.Layout.LayoutHistorique;
import ProjetPatron.src.vue.Layout.LayoutHistoriquePane;
import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.*;

public class HistoryPane extends JPanel {

    private static HistoryPane instance;
    private Container historique;

    private HistoryPane(){
        this.setName("History");
        this.setBackground(ThemeView.getInstance().getColor());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.historique = new Container();
        this.historique.setName("ListHistorique");
        this.historique.setLayout(new LayoutHistorique());
        this.add(historique);
        this.setLayout(new LayoutHistoriquePane());
        this.reloadHistory();
    }

    public void reloadHistory(){
        //TODO ajouter les 10 dernier objets sous forme de HistoriqueObjet
    }

    public static HistoryPane getInstance(){
        if(instance == null){
            instance = new HistoryPane();
        }
        return instance;
    }

}
