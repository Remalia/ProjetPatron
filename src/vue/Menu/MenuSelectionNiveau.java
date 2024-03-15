package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonSelectLevel;
import ProjetPatron.src.vue.Layout.LayoutSelectionNiveau;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class MenuSelectionNiveau extends MenuAbstract {

    private static MenuSelectionNiveau instance;

    private MenuSelectionNiveau() throws IOException {
        this.setName("MenuSelectionNiveau");
        this.setLayout(new LayoutSelectionNiveau());
        this.add(new ButtonSelectLevel("Niveau 1", ImageIO.read(new File("assets/images/1.png")).getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH)));
        this.add(new ButtonSelectLevel("Niveau 2",ImageIO.read(new File("assets/images/2.png")).getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH)));
        this.add(new ButtonSelectLevel("Niveau 3",ImageIO.read(new File("assets/images/3.png")).getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH)));
        this.add(new ButtonSelectLevel("Jeu libre"));
    }

    public static MenuSelectionNiveau getInstance() throws IOException {
        if(instance == null){
            instance = new MenuSelectionNiveau();
        }
        return instance;
    }

    @Override
    public String getNameFrame() {
        return "Menu Selection de niveau";
    }

}
