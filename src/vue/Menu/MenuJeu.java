package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.vue.Layout.LayoutMenuJeu;
import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/***
 * Permet de créer et d'initialiser le menu du jeu
 *
 */
public class MenuJeu extends MenuAbstract {

    private static MenuJeu instance;

    /***
     * Constructeur du menu du jeu
     * @throws IOException Erreur pendant la construction du menu
     */
    private MenuJeu() throws IOException {
        super();
        this.setName("MenuJeu");
        this.setLayout(new LayoutMenuJeu());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(HistoryPane.getInstance());
        this.add(PluginsPane.getInstance());
        this.add(ErrorPane.getInstance());
        this.add(GamePane.getInstance());
    }

    /***
     * Permet de mettre à l'échelle toutes les images du menu
     * @throws IOException Erreur pendant la redimension des images
     */
    @Override
    public void reScaleAllComponentsImg() throws IOException {
        for (Component comp: this.getComponents()){
            comp.setBackground(ThemeView.getInstance().getColor());
            MenuAbstract menuAbstract = (MenuAbstract) comp;
            menuAbstract.reScaleAllComponentsImg();
        }
    }

    /***
     * Permet de changer le background du menu
     * @param color La couleur du background
     */
    @Override
    public void changeBackground(Color color) {
        super.changeBackground(color);
        for (Component comp : this.getComponents()){
            MenuAbstract mA = (MenuAbstract) comp;
            mA.changeBackground(color);
        }
    }

    /***
     * Permet de récupérer l'instance unique du menu du jeu
     * @return L'instance du menu du jeu
     */
    public static MenuJeu getInstance() throws IOException {
        if(instance == null){
            instance = new MenuJeu();
        }
        return instance;
    }

    /***
     * Permet de retourner le nom de la frame
     * @return le nom de la frame
     */ 
    @Override
    public String getNameFrame() {
        return "Jeu";
    }
}
