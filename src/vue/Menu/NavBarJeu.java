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

public class NavBarJeu extends MenuAbstract{

    private static NavBarJeu instance;

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
        ButtonDelete delete = new ButtonDelete("delete","assets/images/annuler.png"); //TODO GOMME
        ButtonPlugins plugins = new ButtonPlugins("plugins"); //TODO img Plugins
        ButtonSelect select = new ButtonSelect("mouse"); //TODO img Mouse
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

    @Override
    public void changeBackground(Color color) {
        super.changeBackground(color);
        for (Component c: this.getComponents()){
            c.setBackground(color);
        }
    }

    @Override
    public void reScaleAllComponentsImg() throws IOException {
        for (Button button : buttons){
            if(button.getIcon() != null){
                button.setIcon(new ImageIcon(ImageResizer.getGoodImageSizeNavBar(button.getImgPath())));
            }
        }
    }

    public static NavBarJeu getInstance() throws IOException {
        if(instance == null){
            instance = new NavBarJeu();
        }
        instance.reScaleAllComponentsImg();
        return instance;
    }

    @Override
    public String getNameFrame() {
        return "NavBarJeu";
    }

}
