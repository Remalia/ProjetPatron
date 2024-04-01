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
 * Permet de créer et d'initialiser la barre de navigation
 *
 */
public class NavBar extends MenuAbstract{

    private static NavBar instance;
    private final ButtonRetour btnRetour;

    /***
     * Constructeur de la barre de navigation
     */
    private NavBar(){
        super();
        this.setName("NavBar");
        this.setLayout(new NavBarLayout());
        ButtonParams param = new ButtonParams("param","assets/images/reglage.png");
        this.btnRetour = new ButtonRetour("retour","assets/images/annuler.png");
        this.buttons.add(param);
        this.buttons.add(btnRetour);
        this.addAllButtons();
    }

    /***
     * Permet de changer le background de la barre de navigation
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
     * Permet de remettre à échelle toutes les images de la barre de navigation
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
     * Permet de récupérer l'instance unique de la barre de navigation
     * @return L'instance unique de la barre de navigation
     * @throws IOException Image non trouvée
     */
    public static NavBar getInstance() throws IOException {
        if(instance == null){
            instance = new NavBar();
        }
        instance.reScaleAllComponentsImg();
        return instance;
    }

    /***
     * Renvoie le nom de la frame
     * @return le nom de la frame
     */
    @Override
    public String getNameFrame() {
        return "NavBar";
    }
}
