package ProjetPatron.src.model.Action.Commandes;

import ProjetPatron.src.model.Formes.Forme;
import ProjetPatron.src.model.MainModel;
import ProjetPatron.src.model.Parser;

/***
 * Classe permettant de supprimer une forme
 */
public class SuppresionForme implements Command {

    private Forme forme;

    /***
     * Constructeur de la suppression d'une forme
     */
    public SuppresionForme(){}

    /***
     * Constructeur de la suppression d'une forme avec argument
     * @param f La forme à supprimer
     */
    public SuppresionForme(Forme f){
        this.forme = f;
    }

    /***
     * Permet de supprimer une forme
     */
    @Override
    public void execute() {
        MainModel.getInstance().getFormes().remove(forme);
    }

    /***
     * Permet de réajouter une forme supprimée
     */
    @Override
    public void backtrack() {
        MainModel.getInstance().getFormes().add(forme);
    }

    /***
     * Permet d'écrire une commande de suppression de forme dans le Yaml de sauvegarde
     * @param svg True --> Sauvegarde pour le Undo / False --> Sauvegarde pour le Redo
     */
    @Override
    public String writeCommand(boolean svg) {
        return "  suppr: " + forme.getId();
    }


    /***
     * Permet de reconstruire une forme depuis une ligne de sauvegarde
     * @param ligne La ligne en question
     */
    @Override
    public void readCommand(String ligne) {
        this.forme = MainModel.getInstance().getFormes().get(Integer.parseInt(ligne));
    }
}
