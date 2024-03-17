package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonParams;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonRetour;
import ProjetPatron.src.vue.Layout.NavBarLayout;

import java.io.IOException;

public class NavBarJeu extends MenuAbstract{

    private static NavBarJeu instance;

    private NavBarJeu() throws IOException {
        super();
        this.setName("NavBarJeu");
        this.setLayout(new NavBarLayout());
        ButtonParams param = new ButtonParams("param","assets/images/reglage.png");
        ButtonRetour retour = new ButtonRetour("retour","assets/images/retour.png");
        this.buttons.add(retour);
        this.buttons.add(param);
        this.addAllButtons();
        reScaleAllComponentsImg("NavBar");
    }

    public static NavBarJeu getInstance() throws IOException {
        if(instance == null){
            instance = new NavBarJeu();
        }
        instance.reScaleAllComponentsImg("NavBar");
        return instance;
    }

    @Override
    public String getNameFrame() {
        return "NavBarJeu";
    }

}
