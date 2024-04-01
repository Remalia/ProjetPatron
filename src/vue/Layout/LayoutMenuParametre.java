package ProjetPatron.src.vue.Layout;

import ProjetPatron.src.vue.ThemeView;

import java.awt.*;

/***
 * Classe qui permet de gérer le layout du menu paramètre
 */
public class LayoutMenuParametre implements LayoutManager {

    /**
     * Permet d'ajouter un composant
     * @param name : nom du composant
     * @param comp : composant
     */
    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    /**
     * Permet de supprimer un composant
     * @param comp : composant
     */
    @Override
    public void removeLayoutComponent(Component comp) {

    }

    /**
     * Permet de définir la taille
     * @param parent : conteneur parent
     * @return null
     */
    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    /**
     * Permet de définir la taille minimale
     * @param parent : conteneur parent
     * @return null
     */
    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

    /**
     * Permet de définir la position des composants
     * @param parent : conteneur parent
     */
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
                case "reset": comp.setBounds((int)(width*0.1)+200,(int)(height*0.70),500,150); break;
            }
        }
    }
}
