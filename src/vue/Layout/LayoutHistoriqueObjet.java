package ProjetPatron.src.vue.Layout;

import ProjetPatron.src.vue.ThemeView;

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
                case "img": c.setBounds(5,0,(int) (width * 0.2),height); break;
                case "texte": c.setBounds((int) (width * 0.30),0,(int) (width * 0.8),height); c.setFont(new Font("Serif",Font.BOLD,(int)(width*0.10))); c.setForeground(ThemeView.getInstance().getOppositeColor()); break;
            }
        }
    }
}
