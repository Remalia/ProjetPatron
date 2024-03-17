package ProjetPatron.src.vue.Layout;

import ProjetPatron.src.vue.MainVue;

import java.awt.*;

public class NavBarLayout implements LayoutManager {
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
                case "retour": comp.setBounds(10,5,50,50); break;
                case "param": comp.setBounds(width-60,5,50,50); break;
            }
        }
    }
}
