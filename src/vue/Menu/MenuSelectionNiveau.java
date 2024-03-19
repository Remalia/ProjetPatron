package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonSelectLevel;
import ProjetPatron.src.vue.Layout.LayoutSelectionNiveau;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/***
 * Permet de créer et d'initialiser le menu de sélection de niveau
 *
 */
public class MenuSelectionNiveau extends MenuAbstract {

    private static MenuSelectionNiveau instance;

    /***
     * Constructeur d'un menu de sélection de niveau
     * @throws IOException Fichier image introuvable
     */
    private MenuSelectionNiveau() throws IOException {
        super();
        this.setName("MenuSelectionNiveau");
        this.setLayout(new LayoutSelectionNiveau());

        //TODO AJOUTER LES BUTTONS SAUVEGARDE ET NOUVELLE PARTIE NE PAS LES RELIER ENCORE MAIS FAIRE UN TRUC DE PROPRE

        this.buttons.add(new ButtonSelectLevel("Niveau 1","assets/images/Menu/lvl_1.png"));
        this.buttons.add(new ButtonSelectLevel("Niveau 2","assets/images/Menu/lvl_2.png"));
        this.buttons.add(new ButtonSelectLevel("Niveau 3","assets/images/Menu/lvl_3.png"));
        this.buttons.add(new ButtonSelectLevel("Jeu libre"));
        this.addAllButtons();
        reScaleAllComponentsImg();
    }

    /***
     * Permet de changer le background du menu
     * @param color La couleur du background
     */
    @Override
    public void changeBackground(Color color) {
        super.changeBackground(color);
        for (Component c: this.getComponents()){
            c.setBackground(color);
        }
    }

    /***
     * Permet de remettre à échelle toutes les images du menu
     * @throws IOException Image non trouvée
     */
    @Override
    public void reScaleAllComponentsImg() throws IOException {
        for (Button button : buttons){
            if(button.getIcon() != null){
                button.setIcon(new ImageIcon(getGoodImageSizeSelectionNiveau(button.getImgPath())));
            }
        }
    }

    /***
     * Permet de retourner l'instance unique du menu de sélection de niveau
     * @return L'instance en question
     * @throws IOException Image non trouvé
     */
    public static MenuSelectionNiveau getInstance() throws IOException {
        if(instance == null){
            instance = new MenuSelectionNiveau();
        }
        instance.reScaleAllComponentsImg();
        return instance;
    }

    /***
     * Renvoie le nom de la frame
     * @return Son nom
     */
    @Override
    public String getNameFrame() {
        return "Menu Selection de niveau";
    }

}
