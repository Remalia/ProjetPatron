package ProjetPatron.src.model.Action.Commandes;

import ProjetPatron.src.model.Formes.Forme;
import ProjetPatron.src.model.MainModel;

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
     * Permet la supression de la forme
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
     */
    @Override
    public String writeCommand() {
        return "  suppr-"+ forme.getId() +": "+ forme.getId() + "\n" ;
    }


    /***
     * Permet de lire une ligne de sauvegarde
     * @param key La clé de la ligne en question
     * @param val La valeur de la ligne en question
     */
    @Override
    public void readCommand(String key, String val) {
        int id = Integer.parseInt(val);
        for (Forme f : MainModel.getInstance().getFormes()){
            if (f.getId() == id){
                this.forme = f;
            }
        }
    }
}
