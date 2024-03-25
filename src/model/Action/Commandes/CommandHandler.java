package ProjetPatron.src.model.Action.Commandes;

import ProjetPatron.src.controller.Graphics.Pane.ErrorPane;

import java.util.*;

/***
 * Classe de gestion des commandes
 */
public class CommandHandler{

    private final Stack<Command> stackCommand;
    private final Stack<Command> stackRedo;

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
    public void addCommand(Command c){
        c.execute();
        this.stackCommand.push(c);
        this.stackRedo.clear();
    }

    /***
     * Permet d'annuler la dernière commande réalisé
     */
    public void undo(){
        Command c;
        if (!stackCommand.empty()){
            c = this.stackCommand.pop();
            c.backtrack();
            stackRedo.push(c);
        }else{
            ErrorPane.getInstance().setErrorText("La pile undo est vide !");
        }
    }

    /***
     * Permet de refaire la commande précedemment annuler
     */
    public void redo(){
        Command c;
        if(!stackRedo.empty()) {
            c = this.stackRedo.pop();
            c.execute();
            stackCommand.push(c);
        }else{
            ErrorPane.getInstance().setErrorText("La pile redo est vide !");
        }
    }
}
