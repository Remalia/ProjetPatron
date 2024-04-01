package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.vue.Layout.LayoutHistoriqueObjet;
import ProjetPatron.src.vue.Layout.LayoutHistoriquePane;
import ProjetPatron.src.vue.MainVue;
import ProjetPatron.src.vue.ThemeView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/***
 * Permet d'afficher l'historique des objets
 */
public class HistoriqueObjet extends MenuAbstract {

    private JLabel label;
    private JLabel icon;
    private String imgPath;

    /***
     * Constructeur de l'historique des objets
     * @param label
     * @param imgPath
     * @throws IOException
     */
    public HistoriqueObjet(String label, String imgPath) throws IOException {
        this.label = new JLabel(label);
        this.imgPath = imgPath;
        this.setLayout(new LayoutHistoriqueObjet());
        this.setBackground(ThemeView.getInstance().getColor());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.icon = new JLabel(new ImageIcon(ImageIO.read(new File(imgPath)).getScaledInstance((int) (MainVue.getFrameWidth()*0.2*0.2),(int) (MainVue.getFrameWidth()*0.2*0.2),java.awt.Image.SCALE_SMOOTH)));
        this.label.setName("texte");
        this.icon.setName("img");
        this.add(icon);
        this.add(this.label);
    }

    /***
     * Permet de retourner le nom de la frame
     * @return le nom de la frame
     */
    @Override
    public String getNameFrame() {
        return "Historique Objet";
    }

    /***
     * Permet de redimensionner les composants de l'historique des objets
     * @throws IOException si une erreur survient lors de la redimension
     */
    @Override
    public void reScaleAllComponentsImg() throws IOException {
        this.icon.setIcon(new ImageIcon(ImageIO.read(new File(imgPath)).getScaledInstance((int) (MainVue.getFrameWidth()*0.2*0.2),(int) (MainVue.getFrameWidth()*0.2*0.2),java.awt.Image.SCALE_SMOOTH)));
    }
}
