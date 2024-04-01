package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonRetour;
import ProjetPatron.src.vue.ImageResizer;
import ProjetPatron.src.vue.Layout.NavBarLayout;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/***
 * Permet de créer et d'initialiser la barre de navigation des paramètres
 *
 */
public class NavBarParam extends MenuAbstract{

    private static NavBarParam instance;

    /***
     * Constructeur de la barre de navigation des paramètres
     * 
     */
    private NavBarParam(){
        super();
        this.setName("NavBar");
        this.setLayout(new NavBarLayout());
        ButtonRetour retour = new ButtonRetour("retour","assets/images/retour.png");
        this.buttons.add(retour);
        this.addAllButtons();
    }

    /***
     * Permet de changer le background de la barre de navigation des paramètres
     * @param color la couleur du background
     */
    @Override
    public void changeBackground(Color color) {
        super.changeBackground(color);
        for (Component c: this.getComponents()){
            c.setBackground(color);
        }
    }

    /***
     * Permet de remettre à échelle toutes les images de la barre de navigation des paramètres
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
     * Permet de retourner le nom de la frame
     * @return le nom de la frame
     */
    @Override
    public String getNameFrame() {
        return "NavBarParam";
    }

    /***
     * Permet de récupérer l'instance unique de la barre de navigation des paramètres
     * @return L'instance unique de la barre de navigation des paramètres
     * @throws IOException Image non trouvée
     */
    public static NavBarParam getInstance() throws IOException {
        if(instance == null){
            instance = new NavBarParam();
        }
        instance.reScaleAllComponentsImg();
        return instance;
    }
}
