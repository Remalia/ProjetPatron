package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Bouton.menus.ButtonJouer;
import ProjetPatron.src.controller.Bouton.menus.ButtonParams;
import ProjetPatron.src.controller.Bouton.menus.ButtonRetour;
import ProjetPatron.src.vue.Layout.LayoutMenuPrincipal;

public class MenuPrincipal extends MenuAbstract {

    private static MenuPrincipal instance;

    private MenuPrincipal() {
        this.setName("MenuPrincipal");
        this.setLayout(new LayoutMenuPrincipal());
        ButtonJouer butJouer = new ButtonJouer("Jouer");
        this.add(butJouer);
        this.add(new ButtonParams("Paramètres"));
        this.add(new ButtonRetour("Quitter"));
    }

    public static MenuPrincipal getInstance(){
        if(instance == null){
            instance = new MenuPrincipal();
        }
        return instance;
    }
}
