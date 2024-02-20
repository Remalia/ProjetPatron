package ProjetPatron.src.model.Action.Commandes;

/***
 *  Classe d'ajout de triangle dans le jeu
 */
public class AjoutTriangle implements Command{

    @Override
    public void execute() {
        //TODO
    }

    @Override
    public void backtrack() {
        //TODO
    }

    /***
     * Permet d'écrire une commande d'ajout de triangle dans le Yaml de sauvegarde
     * @param svg True --> Sauvegarde pour le Undo / False --> Sauvegarde pour le Redo
     * @return La commande de sauvegarde
     */
    @Override
    public String writeCommand(boolean svg) {
        return null;
    }

    /***
     * Permet de reconstruire un ajout de triangle depuis une ligne de sauvegarde
     */
    @Override
    public void readCommand() {

    }

}
