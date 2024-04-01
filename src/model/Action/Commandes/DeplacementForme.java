package ProjetPatron.src.model.Action.Commandes;

import ProjetPatron.src.model.Formes.Coord;
import ProjetPatron.src.model.Formes.Forme;

public class DeplacementForme implements Command{

    private Forme forme;
    private int pixelX;
    private int pixelY;

    public DeplacementForme(){

    }

    /***
     * Constructuer d'un déplacement de forme
     * @param forme La forme à déplacer
     * @param pixelX Le nombre de pixel à droite à déplacer la forme
     * @param pixelY Le nombre de pixel en bas à déplacer la forme
     */
    public DeplacementForme(Forme forme,int pixelX,int pixelY){
        this.forme = forme;
        this.pixelX = pixelX;
        this.pixelY = pixelY;
    }

    @Override
    public void execute() {
        for (Coord i : this.forme.getPoints()){
            i.setX(i.getX() + this.pixelX);
            i.setY(i.getY() + this.pixelY);
        }
    }

    @Override
    public void backtrack() {
        for (Coord i : this.forme.getPoints()){
            i.setX(i.getX() - this.pixelX);
            i.setY(i.getY() - this.pixelY);
        }

    }

    @Override
    public String writeCommand() {
        String ligneDesc = " ";
        ligneDesc += pixelX + " + " + pixelY +"\n";
        return "  deplacement: " + forme.getId() + ligneDesc;
    }

    @Override
    public void readCommand(String ligne) {

    }
}
