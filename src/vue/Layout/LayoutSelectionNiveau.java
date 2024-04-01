package ProjetPatron.src.vue.Layout;

import java.awt.*;

/***
 * Classe qui permet de gerer le layout de la selection du niveau
 */
public class LayoutSelectionNiveau implements LayoutManager {

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
     * Permet de definir la taille
     * @param parent : conteneur parent
     * @return null
     */
    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    /**
     * Permet de definir la taille minimale
     * @param parent : conteneur parent
     * @return null
     */
    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

    /**
     * Permet de definir la position des composants
     * @param parent : conteneur parent
     */
    @Override
    public void layoutContainer(Container parent) {
        int width = parent.getWidth();
        int height = parent.getHeight();
        for (Component comp: parent.getComponents()){
            switch (comp.getName()){
                case "Niveau 1": comp.setBounds((int)(width*0.15),(int)(height*0.1),(int)(width*0.15),(int)(height*0.20)); break;
                case "Niveau 2": comp.setBounds((int)(width*0.425),(int)(height*0.1),(int)(width*0.15),(int)(height*0.20)); break;
                case "Niveau 3": comp.setBounds((int)(width*0.7),(int)(height*0.1),(int)(width*0.15),(int)(height*0.20)); break;
                case "Jeu libre": comp.setBounds((int)(width*0.35),(int)(height*0.6),(int)(width*0.3),(int)(height*0.20)); break;
            }
        }
    }
}
