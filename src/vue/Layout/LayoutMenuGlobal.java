package ProjetPatron.src.vue.Layout;

import java.awt.*;

/**
 * Classe qui permet de gérer le layout global du menu
 */
public class LayoutMenuGlobal implements LayoutManager {

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
    public void removeLayoutComponent(Component comp) {}

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
                case "NavBar", "NavBarJeu", "NavBarParam": comp.setBounds(0,0, width,100); break;
                case "MenuPrincipal", "Paramètre", "MenuSelectionNiveau","MenuJeu": comp.setBounds(0,100,width,height-100); break;
            }
        }
    }
}
