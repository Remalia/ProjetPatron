package ProjetPatron.src.vue.Layout;

import java.awt.*;

public class LayoutMenuJeu implements LayoutManager {
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
        for (Component comp : parent.getComponents()){
            switch (comp.getName()) {
                case "History":
                    comp.setBounds(0, 0, (int) (width * 0.2), height - 29);
                    break;
                case "PluginsAddons":
                    comp.setBounds((int) (width * 0.8), 0, (int) (width * 0.2), height - 29);
                    break;
                case "Error":
                    comp.setBounds(0, height-30, width, 30);
                    break;
                case "Game":
                    comp.setBounds((int) (width * 0.2),0,(int) (width * 0.6),height - 29);
            }
        }
    }
}
