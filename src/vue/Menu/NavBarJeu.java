package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Bouton.menus.ButtonParams;
import ProjetPatron.src.controller.Bouton.menus.ButtonRetour;
import ProjetPatron.src.vue.Layout.NavBarLayout;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class NavBarJeu extends MenuAbstract{

    private static NavBarJeu instance;

    private NavBarJeu() throws IOException {
        this.setName("NavBarJeu");
        this.setLayout(new NavBarLayout());
        ButtonParams param = new ButtonParams("param", ImageIO.read(new File("assets/images/reglage.png")).getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH));
        ButtonRetour retour = new ButtonRetour("retour",ImageIO.read(new File("assets/images/retour.png")).getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH));
        this.add(retour);
        this.add(param);
    }

    public static NavBarJeu getInstance() throws IOException {
        if(instance == null){
            instance = new NavBarJeu();
        }
        return instance;
    }

}
