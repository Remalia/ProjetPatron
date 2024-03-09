package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Bouton.menus.ButtonJouer;
import ProjetPatron.src.controller.Bouton.menus.ButtonParams;
import ProjetPatron.src.controller.Bouton.menus.ButtonRetour;
import ProjetPatron.src.vue.MainVue;

import javax.swing.*;

import java.io.IOException;

import static ProjetPatron.src.vue.MainVue.getPane;

public class MenuPrincipal extends MenuAbstract {

    private static MenuPrincipal instance;
    private JPanel butPanel;

    private MenuPrincipal() throws IOException {
        super();
        butPanel = new JPanel();
        butPanel.setLayout(new BoxLayout(butPanel,BoxLayout.Y_AXIS));
        ButtonJouer butJouer = new ButtonJouer("Jouer");
        butPanel.add(butJouer);
        butPanel.add(new ButtonParams("Paramètres"));
        butPanel.add(new ButtonRetour("Quitter"));
        this.add(butPanel);
    }

    public static MenuPrincipal getInstance() throws IOException {
        if(instance == null){
            instance = new MenuPrincipal();
        }
        return instance;
    }

    @Override
    public void repaint() {
        super.repaint();
    }


}
