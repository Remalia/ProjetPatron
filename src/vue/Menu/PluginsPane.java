package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.model.MainModel;
import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.DecimalFormat;

/***
 * Permet d'afficher le panel plugin qui affiche le score
 */
public class PluginsPane extends MenuAbstract {

    private static PluginsPane instance;
    private JLabel scoreLabel;


    /***
     * Permet de retourner le nom de la frame
     * @return le nom de la frame
     */
    @Override
    public String getNameFrame() {
        return "PluginsFrame";
    }

    /***
     * Constructeur du panel plugin
     */
    private PluginsPane(){
        this.setName("PluginsAddons");
        this.setBackground(ThemeView.getInstance().getColor());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.scoreLabel = new JLabel();
        this.scoreLabel.setText("Score: " + MainModel.getInstance().getScore().calculScore() + "pts");
        this.scoreLabel.setFont(new Font("Serif", Font.BOLD, 25));
        this.scoreLabel.setForeground(Color.CYAN);
        this.add(scoreLabel);

    }

    /***
     * Permet de remettre à échelle toutes les images du panel
     * @throws IOException Image non trouvée
     */
    @Override
    public void reScaleAllComponentsImg() throws IOException {
        DecimalFormat df = new DecimalFormat("0.000");
        this.scoreLabel.setText("Score: " + df.format(MainModel.getInstance().getScore().calculScore()) + "pts");
    }

    /***
     * permet de récupérer l'instance unique du panel plugin
     * @return le panel plugin
     */
    public static PluginsPane getInstance(){
        if(instance == null){
            instance = new PluginsPane();
        }
        return instance;
    }

}
