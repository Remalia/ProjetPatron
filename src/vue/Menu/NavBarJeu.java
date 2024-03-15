package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonParams;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonRetour;
import ProjetPatron.src.vue.Layout.NavBarLayout;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NavBarJeu extends MenuAbstract{

    private static NavBarJeu instance;

    private NavBarJeu() throws IOException {
        this.setName("NavBarJeu");
        this.setLayout(new NavBarLayout());
        ButtonParams param = new ButtonParams("param",getGoodImageSizeNavBar("assets/images/reglage.png"));
        ButtonRetour retour = new ButtonRetour("retour",getGoodImageSizeNavBar("assets/images/retour.png"));
        this.add(retour);
        this.add(param);
    }

    public static NavBarJeu getInstance() throws IOException {
        if(instance == null){
            instance = new NavBarJeu();
        }
        return instance;
    }

    @Override
    public String getNameFrame() {
        return "NavBarJeu";
    }

}
