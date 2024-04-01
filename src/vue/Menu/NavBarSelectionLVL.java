package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonParams;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonRetour;
import ProjetPatron.src.vue.ImageResizer;
import ProjetPatron.src.vue.Layout.NavBarLayout;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/***
 * Permet de créer et d'initialiser la barre de navigation pour la selection des niveaux
 *
 */
public class NavBarSelectionLVL extends MenuAbstract{

    private static NavBarSelectionLVL instance;

    /***
     * Constructeur de la barre de navigation pour la selection des niveaux
     */
    private NavBarSelectionLVL(){
        super();
        this.setName("NavBar");
        this.setLayout(new NavBarLayout());
        ButtonParams param = new ButtonParams("param","assets/images/reglage.png");
        ButtonRetour btnRetour = new ButtonRetour("retour", "assets/images/retour.png");
        this.buttons.add(param);
        this.buttons.add(btnRetour);
        this.addAllButtons();
    }

    /***
     * Permet de changer le background de la barre de navigation pour la selection des niveaux
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
     * Permet de remettre à échelle toutes les images de la barre de navigation pour la selection des niveaux
     * @throws IOException Image non trouvée
     */
    @Override
    public void reScaleAllComponentsImg() throws IOException {
        for (Button button : buttons){
            if(button.getIcon() != null){
                button.setIcon(new ImageIcon(ImageResizer.getGoodImageSizeNavBar(button.getImgPath())));
            }
        }
    }

    /***
     * Permet de retourner l'instance de la barre de navigation pour la selection des niveaux
     * @return l'instance de la barre de navigation pour la selection des niveaux
     * @throws IOException Image non trouvée
     */
    public static NavBarSelectionLVL getInstance() throws IOException {
        if(instance == null){
            instance = new NavBarSelectionLVL();
        }
        instance.reScaleAllComponentsImg();
        return instance;
    }

    /***
     * Permet de retourner le nom de la frame
     * @return le nom de la frame
     */
    @Override
    public String getNameFrame() {
        return "NavBar";
    }
}

