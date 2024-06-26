package ProjetPatron.src.vue.Layout;

import ProjetPatron.src.vue.MainVue;

import java.awt.*;

/**
 * Classe qui permet de gérer le layout de la barre de navigation
 */
public class NavBarLayout implements LayoutManager {

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
        for (Component comp: parent.getComponents()){
            switch (comp.getName()){
                case "retour": comp.setBounds(10,25,50,50); break;
                case "save": comp.setBounds(70, 25, 50,50);break;
                case "mouse":comp.setBounds(130, 25, 50,50);break;
                case "rectangle": comp.setBounds(280, 25, 50,50);break;
                case "cercle": comp.setBounds(340, 25, 50,50);break;
                case "triangle": comp.setBounds(400, 25, 50,50);break;
                case "param": comp.setBounds(width-60,25,50,50); break;
                case "undo":comp.setBounds(width-260, 25, 50,50);break;
                case "redo":comp.setBounds(width-200, 25, 50,50);break;
                case "plugins":comp.setBounds(width-120, 25, 50,50);break;
                case "delete":comp.setBounds(190,25,50,50); break;
            }
        }
    }
}
