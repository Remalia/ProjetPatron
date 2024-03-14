package ProjetPatron.src.vue.Layout;

import java.awt.*;

public class LayoutMenuParametre implements LayoutManager {
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
            switch (comp.getName()){
                case "LabelResolution": comp.setBounds((int)(width*0.1),(int)(height*0.1),200,(int)(height*0.05)); comp.setFont(new Font("Serif",Font.BOLD,(int)(width*0.02))); break;
                case "LabelTheme": comp.setBounds((int)(width*0.1),(int)(height*0.2),200,(int)(height*0.05)); comp.setFont(new Font("Serif",Font.BOLD,(int)(width*0.02)));break;
                case "cbResolution": comp.setBounds((int)(width*0.25),(int)(height*0.1),200,(int)(height*0.05)); break;
                case "cbTheme": comp.setBounds((int)(width*0.25),(int)(height*0.2),200,(int)(height*0.05)); break;
            }
        }
    }
}
