package ProjetPatron.src.vue.Layout;

import java.awt.*;

public class LayoutMenuPrincipal implements LayoutManager {
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
                case "Jouer": comp.setBounds((int)(width*0.4),(int)(height*0.2),(int)(width*0.25),(int)(height*0.15)); break;
                case "Paramètres": comp.setBounds((int)(width*0.4),(int)(height*0.4),(int)(width*0.25),(int)(height*0.15)); break;
                case "Quitter": comp.setBounds((int)(width*0.4),(int)(height*0.6),(int)(width*0.25),(int)(height*0.15)); break;
            }
        }
    }
}
