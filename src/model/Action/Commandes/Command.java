package ProjetPatron.src.model.Action.Commandes;

/***
 *  Interface commune à chaque commande
 */
public interface Command {

    /***
     * Execute la commande
     */
    void execute();

    /***
     * Annule la commande
     */
    void backtrack();

    /***
     * Ecrit la commande pour le YAML
     * @return la commande
     */
    String writeCommand();

    /***
     * Lit la commande de la ligne actuelle
     * @param ligne la ligne en question
     */
    void readCommand(String ligne);

}
