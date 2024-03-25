package ProjetPatron.src.vue.Layout;

import ProjetPatron.src.model.MainModel;

import java.awt.*;

public class LayoutHistorique implements LayoutManager {
    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

    @Override
    public void layoutContainer(Container parent) {
        int width = parent.getWidth();
        int height = parent.getHeight();
        int maxFormeAffichage = 10;
        int nbElemTraiter = 0;
        for (Component comp : parent.getComponents()){
            comp.setBounds(0,height/maxFormeAffichage*nbElemTraiter,width,height/maxFormeAffichage);
            nbElemTraiter++;
        }
    }
}
