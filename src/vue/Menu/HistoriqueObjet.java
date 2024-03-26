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

public class HistoriqueObjet extends MenuAbstract {

    private JLabel label;
    private JLabel icon;
    private String imgPath;

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

    @Override
    public String getNameFrame() {
        return "Historique Objet";
    }

    @Override
    public void reScaleAllComponentsImg() throws IOException {
        this.icon.setIcon(new ImageIcon(ImageIO.read(new File(imgPath)).getScaledInstance((int) (MainVue.getFrameWidth()*0.2*0.2),(int) (MainVue.getFrameWidth()*0.2*0.2),java.awt.Image.SCALE_SMOOTH)));
    }
}
