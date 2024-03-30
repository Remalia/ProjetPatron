package ProjetPatron.src.vue.Layout;

import ProjetPatron.src.vue.ThemeView;

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
                case "LabelResolution": comp.setBounds((int)(width*0.1),(int)(height*0.1),200,50); comp.setFont(new Font("Serif",Font.BOLD,32)); comp.setForeground(ThemeView.getInstance().getOppositeColor()); break;
                case "LabelTheme": comp.setBounds((int)(width*0.1),(int)(height*0.25),200,50); comp.setFont(new Font("Serif",Font.BOLD,32)); comp.setForeground(ThemeView.getInstance().getOppositeColor()); break;
                case "cbResolution": comp.setBounds((int)(width*0.1)+200,(int)(height*0.1),200,50); comp.setFont(new Font("Serif",Font.BOLD,32));break;
                case "cbTheme": comp.setBounds((int)(width*0.1)+200,(int)(height*0.25),200,50); comp.setFont(new Font("Serif",Font.BOLD,32));break;
                case "cbFullScreen": comp.setBounds((int)(width*0.1)+200,(int)(height*0.40),600,50); comp.setFont(new Font("Serif",Font.BOLD,32)); comp.setForeground(ThemeView.getInstance().getOppositeColor()); break;
            }
        }
    }
}
