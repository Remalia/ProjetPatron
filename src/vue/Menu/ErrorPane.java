package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/***
 * Permet d'afficher le panel des erreurs
 */
public class ErrorPane extends MenuAbstract {

    private static ErrorPane instance;
    private JLabel errorLabel;

    /***
     * Permet de retourner le nom de la frame
     * @return le nom de la frame
     */
    @Override
    public String getNameFrame() {
        return "Error Pane";
    }

    /***
     * Constructeur du panel des erreurs
     */
    private ErrorPane(){
        this.setName("Error");
        this.setBackground(ThemeView.getInstance().getColor());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        errorLabel = new JLabel("Les erreurs s'affichent ici");
        errorLabel.setForeground(Color.RED);
        this.add(errorLabel);
    }

    @Override
    public void reScaleAllComponentsImg() throws IOException {

    }

    /***
     * Permet de changer le texte d'erreur
     * @param errorText le texte d'erreur
     */
    public void setErrorText(String errorText) {
        this.errorLabel.setText(errorText);
    }

    /***
     * Permet de récupérer l'instance unique du panel des erreurs
     * @return le panel des erreurs
     */
    public static ErrorPane getInstance(){
        if(instance == null){
            instance = new ErrorPane();
        }
        return instance;
    }

}
