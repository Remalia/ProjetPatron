package ProjetPatron.src.model.Action.Commandes;

import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.Formes.Forme;
import ProjetPatron.src.model.MainModel;

/***
 * Classe permettant le déplacement d'une forme
 */
public class DeplacementForme implements Command{

    private Forme forme;
    private int pixelX;
    private int pixelY;

    /***
     * Contructeur d'un déplacement de forme
     */
    public DeplacementForme(){

    }

    /***
     * Constructuer d'un déplacement de forme avec arguments
     * @param forme La forme à déplacer
     * @param pixelX Le nombre de pixel à droite à déplacer la forme
     * @param pixelY Le nombre de pixel en bas à déplacer la forme
     */
    public DeplacementForme(Forme forme,int pixelX,int pixelY){
        this.forme = forme;
        this.pixelX = pixelX;
        this.pixelY = pixelY;
    }

    /***
     * Permet le déplacement de la forme
     */
    @Override
    public void execute() {
        for (Coord i : this.forme.getPoints()){
            i.setX(i.getX() + this.pixelX);
            i.setY(i.getY() + this.pixelY);
        }
    }

    /***
     * Permet de d'annuler le déplacement
     */
    @Override
    public void backtrack() {
        for (Coord i : this.forme.getPoints()){
            i.setX(i.getX() - this.pixelX);
            i.setY(i.getY() - this.pixelY);
        }

    }

    /***
     * Permet d'écrire une commande de déplacement de forme dans le YAML de sauvegarde
     */
    @Override
    public String writeCommand() {
        String ligneDesc = " | ";
        ligneDesc += pixelX + " + " + pixelY +"\n";
        return "  deplacement: " + forme.getId() + ligneDesc;
    }

    /***
     * Permet de lire une ligne de sauvegarde
     * @param key La clé de la ligne en question
     * @param val La valeur de la ligne en question
     */
    @Override
    public void readCommand(String key, String val) {
        int id = Integer.parseInt(val.substring(0,val.indexOf("|")-1));
        for (Forme f : MainModel.getInstance().getFormes()){
            if (f.getId() == id){
                this.forme = f;
            }
        }
        this.pixelX = Integer.parseInt(val.substring(val.lastIndexOf("|")+2,val.indexOf("+")-1));
        this.pixelY = Integer.parseInt(val.substring(val.lastIndexOf("+")+2));
    }
}
