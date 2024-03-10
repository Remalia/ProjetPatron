package ProjetPatron.src.vue.Layout;

import java.awt.*;

public class LayoutMenuGlobal implements LayoutManager {

    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {}

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
            switch (comp.getName()){
                case "NavBar","NavBarJeu": comp.setBounds(0,0, width,100); break;
                case "MenuPrincipal", "MenuSelectionNiveau": comp.setBounds(0,100,width,height-100); break;
                case "Scroll": comp.setBounds(0,100,(int)(width*0.2),height-100); break;
                case "PluginsAddons": comp.setBounds((int)(width*0.8),100,(int)(width*0.2),height-100); break;
                case "MenuJeu": comp.setBounds((int)(width*0.2),100,(int)(width*0.6),height-100); break;
            }
        }
    }
}
