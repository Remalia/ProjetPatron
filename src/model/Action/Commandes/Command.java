package ProjetPatron.src.model.Action.Commandes;

/***
 *  Interface commune à chaque commande
 */
public interface Command {

    public void execute();
    public void backtrack();
}
