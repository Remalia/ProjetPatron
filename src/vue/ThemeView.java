package ProjetPatron.src.vue;

import java.awt.*;
import java.io.IOException;

/**
 * Classe qui permet de gérer le thème de l'application
 */
public class ThemeView {

    private Color color;
    private static ThemeView instance;

    /***
     * Constructeur de la classe
     */
    private ThemeView(){
    }

    /***
     * Permet de récupérer la couleur actuelle
     * @return la couleur
     */
    public Color getColor(){
        return color;
    }

    /***
     * Permet de changer la couleur
     * @param color : nouvelle couleur
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /***
     * Permet d'avoir une couleur vive
     * @return la couleur rouge
     */
    public Color getIlluminateColor(){
        return Color.RED;
    }

    /***
     * Permet d'avoir la couleur opposée à la couleur actuelle
     * @return la couleur opposée (blanche ou noire)
     */
    public Color getOppositeColor(){
        if(color == Color.darkGray){
            return Color.lightGray;
        }else{
            return Color.darkGray;
        }
    }

    /***
     * Permet de changer la couleur du thème en noir
     * @throws IOException Exception si l'instance n'est pas trouvée
     */
    private void setBlack() throws IOException {
        this.color = Color.darkGray;
        MainVue.getInstance().backgroundHasChanged(Color.darkGray);
    }

    /***
     * Permet de changer la couleur du thème en blanc
     * @throws IOException Exception si l'instance n'est pas trouvée
     */
    private void setWhite() throws IOException {
        this.color = Color.lightGray;
        MainVue.getInstance().backgroundHasChanged(Color.lightGray);
    }

    /***
     * Permet de changer la couleur du thème
     * @param color : nouvelle couleur
     * @throws IOException Exception si l'instance n'est pas trouvée
     */
    public void swapColorTo(String color) throws IOException {
        if(color.equals("Black"))
            setBlack();
        else
            setWhite();
    }

    /***
     * Permet de récupérer l'instance unique de la classe
     * @return l'instance
     */
    public static ThemeView getInstance() {
        if(instance == null){
            instance = new ThemeView();
        }
        return instance;
    }
}
