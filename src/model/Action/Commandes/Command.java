package ProjetPatron.src.model.Action.Commandes;

/***
 *  Interface commune à chaque commande
 */
public interface Command {

    public void execute();
    public void backtrack();
    public String writeCommand(boolean svg);
    public void readCommand();
}
