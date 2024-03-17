package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonJouer;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonParams;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonRetour;
import ProjetPatron.src.vue.Layout.LayoutMenuPrincipal;

import java.io.IOException;

public class MenuPrincipal extends MenuAbstract {

    private static MenuPrincipal instance;

    private MenuPrincipal() throws IOException {
        super();
        this.setName("MenuPrincipal");
        this.setLayout(new LayoutMenuPrincipal());
        this.buttons.add(new ButtonJouer("Jouer","assets/images/Menu/jouer_1.png"));
        this.buttons.add(new ButtonParams("Paramètres","assets/images/Menu/paramètres_1.png"));
        this.buttons.add(new ButtonRetour("Quitter","assets/images/Menu/quitter_1.png"));
        this.addAllButtons();
        reScaleAllComponentsImg("Menu Principal");
    }

    public static MenuPrincipal getInstance() throws IOException {
        if(instance == null){
            instance = new MenuPrincipal();
        }
        instance.reScaleAllComponentsImg("Menu Principal");
        return instance;
    }

    @Override
    public String getNameFrame() {
        return "Menu Principal";
    }
}
