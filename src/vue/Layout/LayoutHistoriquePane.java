package ProjetPatron.src.vue.Layout;

import java.awt.*;

public class LayoutHistoriquePane implements LayoutManager {
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
        parent.getComponent(0).setBounds(0,0,parent.getWidth(),parent.getHeight());
    }
}
