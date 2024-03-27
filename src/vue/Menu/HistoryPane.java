package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.Formes.Forme;
import ProjetPatron.src.model.MainModel;
import ProjetPatron.src.vue.Layout.LayoutHistorique;
import ProjetPatron.src.vue.Layout.LayoutHistoriquePane;
import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class HistoryPane extends MenuAbstract {

    private static HistoryPane instance;
    private Container historique;

    @Override
    public String getNameFrame() {
        return "HistoryPane";
    }

    private HistoryPane(){
        this.setName("History");
        this.setBackground(ThemeView.getInstance().getColor());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.historique = new Container();
        this.historique.setName("ListHistorique");
        this.historique.setLayout(new LayoutHistorique());
        this.add(historique);
        this.setLayout(new LayoutHistoriquePane());
    }

    @Override
    public void reScaleAllComponentsImg() throws IOException {
        reloadHistory();
    }

    public void reloadHistory() throws IOException {
        this.historique.removeAll();
        for (Forme f: MainModel.getInstance().getFormes()){
            String pos = "";
            Coord center = f.getCenter();
            pos += center.getX() + "/" + center.getY();
            this.historique.add(new HistoriqueObjet(pos,f.getPathImg()));
        }
    }

    public static HistoryPane getInstance() throws IOException {
        if(instance == null){
            instance = new HistoryPane();
        }
        return instance;
    }

}
