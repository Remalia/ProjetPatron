package ProjetPatron.src.model.Action;

import ProjetPatron.src.model.Action.Commandes.Command;
import ProjetPatron.src.model.MainModel;

import java.util.List;

/***
 * Permet de sauvegarder une partie en cours
 */
public class SaveLevel {

    public static void saveGameToYAML(){
        for (Command c : MainModel.getInstance().getCh().getStackCommand()){
            c.writeCommand(true);
        }
    }
}
