package ProjetPatron.src.vue.Layout;

import java.awt.*;

public class LayoutSelectionNiveau implements LayoutManager {
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
        for (Component comp: parent.getComponents()){
            switch (comp.getName()){
                case "Niveau 1": comp.setBounds((int)(width*0.1),(int)(height*0.1),(int)(width*0.15),(int)(height*0.15)); break;
                case "Niveau 2": comp.setBounds((int)(width*0.4),(int)(height*0.1),(int)(width*0.15),(int)(height*0.15)); break;
                case "Niveau 3": comp.setBounds((int)(width*0.7),(int)(height*0.1),(int)(width*0.15),(int)(height*0.15)); break;
                case "Jeu libre": comp.setBounds((int)(width*0.4),(int)(height*0.6),(int)(width*0.15),(int)(height*0.15)); break;
            }
        }
    }
}
