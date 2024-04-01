package ProjetPatron.src.vue.Menu;
import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.vue.MainVue;
import ProjetPatron.src.vue.ThemeView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/***
 * Classe abstract qui permet de créer un menu à l'aide de JPanel
 */
public abstract class MenuAbstract extends JPanel{

    /***
     * Méthode qui retourne le nom de la frame
     * @return String : le nom de la frame
     */
    public abstract String getNameFrame();
    protected List<Button> buttons;

    /***
     * Constructeur de la classe MenuAbstract
     */
    protected MenuAbstract(){
        this.buttons = new ArrayList<>();
        this.setBackground(ThemeView.getInstance().getColor());
    }

    /***
     * Permet de changer la couleur de fond du menu
     */
    public void changeBackground(Color color){
        this.setBackground(color);
    }

    /***
     * Permet de redimensionner les images des composants
     * @throws IOException : Exception si l'image n'est pas trouvée
     */
    public abstract void reScaleAllComponentsImg() throws IOException;

    /***
     * Permet d'ajouter tous les boutons au menu
     */
    protected void addAllButtons(){
        for(Button button : buttons){
            this.add(button);
        }
    }
}
