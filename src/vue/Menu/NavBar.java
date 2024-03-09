package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Bouton.menus.ButtonParams;
import ProjetPatron.src.controller.Bouton.menus.ButtonRetour;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

import static ProjetPatron.src.vue.MainVue.getPane;

public class NavBar extends JPanel{

    private static NavBar instance;
    private JPanel barPanel;

    private NavBar() throws IOException {
        barPanel = new JPanel();
        this.barPanel.setLayout(new BoxLayout(barPanel,BoxLayout.X_AXIS));
        ButtonParams param = new ButtonParams(ImageIO.read(new File("assets/images/reglage.png")).getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH));
        ButtonRetour retour = new ButtonRetour(ImageIO.read(new File("assets/images/retour.png")).getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH));
        this.barPanel.add(param);
        this.barPanel.add(retour);
        this.add(barPanel);
    }

    public static NavBar getInstance() throws IOException {
        if(instance == null){
            instance = new NavBar();
        }
        return instance;
    }
}
