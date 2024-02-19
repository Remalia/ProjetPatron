package ProjetPatron.src.model.Action.Commandes;

import java.util.*;

public class CommandHandler{

    private final Stack<Command> stackCommand;
    private final Stack<Command> stackRedo;

    public CommandHandler(){
        this.stackCommand = new Stack<>();
        this.stackRedo = new Stack<>();
    }

    public void addCommand(Command c){
        c.execute();
        this.stackCommand.push(c);
    }

    public void undo(){
        Command c = this.stackCommand.pop();
        c.backtrack();
        stackRedo.push(c);
    }

    public void redo(){
        Command c;
        if(!stackRedo.empty()) {
            c = this.stackRedo.pop();
            this.addCommand(c);
        }else{
            //TODO gestion erreur giga propre avec fenêtre pop-up décrivant l'erreur.
            System.out.println("La pile redo est vide !");
        }
    }
}
