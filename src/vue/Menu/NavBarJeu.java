package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.controller.Graphics.Bouton.actions.ButtonRedo;
import ProjetPatron.src.controller.Graphics.Bouton.actions.ButtonUndo;
import ProjetPatron.src.controller.Graphics.Bouton.formes.ButtonCercle;
import ProjetPatron.src.controller.Graphics.Bouton.formes.ButtonRectangle;
import ProjetPatron.src.controller.Graphics.Bouton.formes.ButtonTriangle;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonParams;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonRetour;
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
        ButtonParams param = new ButtonParams("param","assets/images/reglage.png");
        ButtonRetour retour = new ButtonRetour("retour","assets/images/retour.png");
        ButtonUndo undo = new ButtonUndo("undo","assets/images/undo.png");
        ButtonRedo redo = new ButtonRedo("redo", "assets/images/redo.png");
        ButtonCercle cercle = new ButtonCercle("redo", "assets/images/redo.png");
        ButtonTriangle triangle = new ButtonTriangle("redo", "assets/images/redo.png");
        ButtonRectangle rectangle = new ButtonRectangle("redo", "assets/images/redo.png");
        //TODO Logan la con de ta mère faut que tu finisses ça sale pd
        this.buttons.add(retour);
        this.buttons.add(param);
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
                button.setIcon(new ImageIcon(getGoodImageSizeNavBar(button.getImgPath())));
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
