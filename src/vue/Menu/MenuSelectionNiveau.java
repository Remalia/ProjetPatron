package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonSelectLevel;
import ProjetPatron.src.vue.Layout.LayoutSelectionNiveau;

import java.io.IOException;

public class MenuSelectionNiveau extends MenuAbstract {

    private static MenuSelectionNiveau instance;

    private MenuSelectionNiveau() throws IOException {
        super();
        this.setName("MenuSelectionNiveau");
        this.setLayout(new LayoutSelectionNiveau());
        this.buttons.add(new ButtonSelectLevel("Niveau 1","assets/images/Menu/lvl_1.png"));
        this.buttons.add(new ButtonSelectLevel("Niveau 2","assets/images/Menu/lvl_2.png"));
        this.buttons.add(new ButtonSelectLevel("Niveau 3","assets/images/Menu/lvl_3.png"));
        this.buttons.add(new ButtonSelectLevel("Jeu libre"));
        this.addAllButtons();
        reScaleAllComponentsImg("NavBar");
    }

    public static MenuSelectionNiveau getInstance() throws IOException {
        if(instance == null){
            instance = new MenuSelectionNiveau();
        }
        instance.reScaleAllComponentsImg("NavBar");
        return instance;
    }

    @Override
    public String getNameFrame() {
        return "Menu Selection de niveau";
    }

}
