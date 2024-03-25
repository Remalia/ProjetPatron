package ProjetPatron.src.controller.Graphics.Pane;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class HistoriqueObjet extends JPanel {

    private JLabel label;
    private JLabel icon;

    public HistoriqueObjet(String label, String imgPath) throws IOException {
        this.label = new JLabel(label);
        this.icon = new JLabel(new ImageIcon(ImageIO.read(new File(imgPath)).getScaledInstance((int) (this.getWidth()*0.2),(int) (this.getWidth()*0.2),java.awt.Image.SCALE_SMOOTH)));
        this.label.setName("text");
        this.icon.setName("img");
        this.add(icon);
        this.add(this.label);
    }
}
