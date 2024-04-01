package ProjetPatron.src.model.Action.Commandes;

/***
 *  Interface commune à chaque commande
 */
public interface Command {

    void execute();
    void backtrack();
    String writeCommand();
    void readCommand(String key, String val);

}
