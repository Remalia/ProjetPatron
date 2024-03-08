package ProjetPatron;

import ProjetPatron.src.controller.MainController;
import ProjetPatron.src.model.MainModel;
import ProjetPatron.src.vue.MainVue;

/***
 * Classe qui permet de créer et lancer le jeu
 */
public class Jeu {

    public static void main(String[] args) {
        MainModel model = new MainModel();
        MainController controller = new MainController();
        MainVue vue = new MainVue();
    }
}
