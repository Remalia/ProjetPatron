package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.controller.Graphics.Bouton.actions.*;
import ProjetPatron.src.controller.Graphics.Bouton.formes.ButtonCercle;
import ProjetPatron.src.controller.Graphics.Bouton.formes.ButtonRectangle;
import ProjetPatron.src.controller.Graphics.Bouton.formes.ButtonTriangle;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonParams;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonRetour;
import ProjetPatron.src.vue.ImageResizer;
import ProjetPatron.src.vue.Layout.NavBarLayout;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/***
 * Permet de créer et d'initialiser la barre de navigation en jeu
 *
 */
public class NavBarJeu extends MenuAbstract{

    private static NavBarJeu instance;

    /***
     * Constructeur de la barre de navigation en jeu
     */
    private NavBarJeu(){
        super();
        this.setName("NavBarJeu");
        this.setLayout(new NavBarLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        ButtonParams param = new ButtonParams("param","assets/images/reglage.png");
        ButtonRetour retour = new ButtonRetour("retour","assets/images/retour.png");
        ButtonUndo undo = new ButtonUndo("undo","assets/images/jeu/undo.png");
        ButtonRedo redo = new ButtonRedo("redo", "assets/images/jeu/redo.png");
        ButtonCercle cercle = new ButtonCercle("cercle", "assets/images/jeu/cercle.png");
        ButtonTriangle triangle = new ButtonTriangle("triangle", "assets/images/jeu/triangle.png");
        ButtonRectangle rectangle = new ButtonRectangle("rectangle", "assets/images/jeu/rectangle.png");
        ButtonDelete delete = new ButtonDelete("delete","assets/images/jeu/gomme.png");
        ButtonPlugins plugins = new ButtonPlugins("plugins", "assets/images/jeu/plugins.png");
        ButtonSelect select = new ButtonSelect("mouse","assets/images/jeu/souris.png");
        this.buttons.add(retour);
        this.buttons.add(param);
        this.buttons.add(undo);
        this.buttons.add(redo);
        this.buttons.add(cercle);
        this.buttons.add(triangle);
        this.buttons.add(rectangle);
        this.buttons.add(delete);
        this.buttons.add(plugins);
        this.buttons.add(select);
        this.addAllButtons();
    }

    /***
     * Permet de changer le background de la barre de navigation en jeu
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
     * Permet de remettre à échelle toutes les images de la barre de navigation en jeu
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
     * Permet de récupérer l'instance unique de la barre de navigation en jeu
     * @return l'instance en question
     * @throws IOException Image non trouvée
     */
    public static NavBarJeu getInstance() throws IOException {
        if(instance == null){
            instance = new NavBarJeu();
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
        return "NavBarJeu";
    }

}
