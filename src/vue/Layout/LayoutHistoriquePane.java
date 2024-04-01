package ProjetPatron.src.vue.Layout;

import java.awt.*;

/**
 * Classe qui permet de gérer le layout de l'historique des formes
 */
public class LayoutHistoriquePane implements LayoutManager {

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
        parent.getComponent(0).setBounds(0,0,parent.getWidth(),parent.getHeight());
    }
}
