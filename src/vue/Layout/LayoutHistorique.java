package ProjetPatron.src.vue.Layout;

import ProjetPatron.src.model.MainModel;

import java.awt.*;

/***
 * Classe qui permet de gérer le layout du contenu de l'historique
 */
public class LayoutHistorique implements LayoutManager {

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
        int maxFormeAffichage = 10;
        int nbElemTraiter = 0;
        for (Component comp : parent.getComponents()){
            comp.setBounds(0,height/maxFormeAffichage*nbElemTraiter,width,height/maxFormeAffichage);
            nbElemTraiter++;
        }
    }
}
