package ProjetPatron.src.model.Action.Commandes;

import ProjetPatron.src.model.Action.SaveLevel;
import ProjetPatron.src.model.MainModel;
import ProjetPatron.src.model.Score;
import ProjetPatron.src.vue.MainVue;
import ProjetPatron.src.vue.Menu.ErrorPane;
import ProjetPatron.src.vue.Menu.MenuJeu;

import java.io.IOException;
import java.util.*;

/***
 * Classe de gestion des commandes
 */
public class CommandHandler{

    private final Stack<Command> stackCommand;
    private final Stack<Command> stackRedo;

    public Stack<Command> getStackCommand() {
        return stackCommand;
    }

    public Stack<Command> getStackRedo() {
        return stackRedo;
    }

    /***
     * Permet de créer un commandeHandler
     */
    public CommandHandler(){
        this.stackCommand = new Stack<>();
        this.stackRedo = new Stack<>();
    }

    /***
     * Permet d'ajouter une commande
     * @param c la commande à ajouter
     */
    public void addCommand(Command c) throws IOException {
        c.execute();
        this.stackCommand.push(c);
        this.stackRedo.clear();
        MainVue.getInstance().repaintAll();
        SaveLevel.saveGameToYAML("assets/saves/Niveau"+MainModel.getInstance().getActualLevel()+"Save.yaml");
    }

    /***
     * Permet d'annuler la dernière commande réalisé
     */
    public void undo() throws IOException {
        Command c;
        if (!stackCommand.empty()){
            c = this.stackCommand.pop();
            c.backtrack();
            stackRedo.push(c);
            MainVue.getInstance().repaintAll();
            SaveLevel.saveGameToYAML("assets/saves/Niveau"+MainModel.getInstance().getActualLevel()+"Save.yaml");
        }else{
            ErrorPane.getInstance().setErrorText("La pile undo est vide !");
        }
    }

    /***
     * Permet de refaire la commande précedemment annuler
     */
    public void redo() throws IOException {
        Command c;
        if(!stackRedo.empty()) {
            c = this.stackRedo.pop();
            c.execute();
            stackCommand.push(c);
            MainVue.getInstance().repaintAll();
            SaveLevel.saveGameToYAML("assets/saves/Niveau"+MainModel.getInstance().getActualLevel()+"Save.yaml");
        }else{
            ErrorPane.getInstance().setErrorText("La pile redo est vide !");
        }
    }
}
