package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonJouer;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonParams;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonRetour;
import ProjetPatron.src.vue.Layout.LayoutMenuPrincipal;

public class MenuPrincipal extends MenuAbstract {

    private static MenuPrincipal instance;

    private MenuPrincipal() {
        this.setName("MenuPrincipal");
        this.setLayout(new LayoutMenuPrincipal());
        this.add(new ButtonJouer("Jouer"));
        this.add(new ButtonParams("Paramètres"));
        this.add(new ButtonRetour("Quitter"));
    }

    public static MenuPrincipal getInstance(){
        if(instance == null){
            instance = new MenuPrincipal();
        }
        return instance;
    }

    @Override
    public String getNameFrame() {
        return "Menu Principal";
    }
}
