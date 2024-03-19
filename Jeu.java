package ProjetPatron;

import ProjetPatron.src.controller.MainController;
import ProjetPatron.src.model.Param;
import ProjetPatron.src.model.MainModel;
import ProjetPatron.src.vue.MainVue;

import java.io.IOException;

/***
 * Classe qui permet de créer et lancer le jeu
 */
public class Jeu {
    public static void main(String[] args) throws IOException{
        Param.loadParam();
        MainModel model = MainModel.getInstance();
        MainController controller = MainController.getInstance();
        MainVue vue = MainVue.getInstance();
    }
}
