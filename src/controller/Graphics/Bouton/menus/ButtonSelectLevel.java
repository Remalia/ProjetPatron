package ProjetPatron.src.controller.Graphics.Bouton.menus;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.vue.Menu.HistoryPane;
import ProjetPatron.src.model.MainModel;
import ProjetPatron.src.vue.MainVue;
import ProjetPatron.src.vue.Menu.MenuJeu;

import java.io.IOException;

/***
 * Classe de gestion du bouton de sélection de niveau
 */
public class ButtonSelectLevel extends Button {

    public ButtonSelectLevel(String name,String imgPath,int idMenu) {
        super(name,imgPath);
        this.addActionListener(e -> {
            try {
                MainModel.getInstance().loadLevel(idMenu);
                HistoryPane.getInstance().reloadHistory();
                MainVue.changeScene(MenuJeu.getInstance());
            } catch (IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public ButtonSelectLevel(String name,int idMenu) {
        super(name);
        this.addActionListener(e -> {
            try {
                MainModel.getInstance().loadLevel(idMenu);
                HistoryPane.getInstance().reloadHistory();
                MainVue.changeScene(MenuJeu.getInstance());
            } catch (IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
