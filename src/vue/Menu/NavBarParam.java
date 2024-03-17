package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonRetour;
import ProjetPatron.src.vue.Layout.NavBarLayout;

import java.io.IOException;

public class NavBarParam extends MenuAbstract{

    private static NavBarParam instance;

    private NavBarParam() throws IOException {
        super();
        this.setName("NavBar");
        this.setLayout(new NavBarLayout());
        ButtonRetour retour = new ButtonRetour("retour","assets/images/retour.png");
        this.buttons.add(retour);
        this.addAllButtons();
        reScaleAllComponentsImg("NavBar");
    }

    @Override
    public String getNameFrame() {
        return "NavBarParam";
    }

    public static NavBarParam getInstance() throws IOException {
        if(instance == null){
            instance = new NavBarParam();
        }
        instance.reScaleAllComponentsImg("NavBar");
        return instance;
    }
}
