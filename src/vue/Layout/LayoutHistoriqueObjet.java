package ProjetPatron.src.vue.Layout;

import java.awt.*;

public class LayoutHistoriqueObjet implements LayoutManager {
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
        for (Component c : parent.getComponents()){
            switch (c.getName()){
                case "img": c.setBounds(0,0,(int) (width * 0.2),(int) (width * 0.2)); break;
                case "text": c.setBounds((int) (width * 0.2),(int) (width * 0.1),(int) (width * 0.8),(int) (width * 0.8)); break;
            }
        }
    }
}
