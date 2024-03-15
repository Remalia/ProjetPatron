package ProjetPatron.src.vue.Menu;
import ProjetPatron.src.vue.MainVue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class MenuAbstract extends JPanel{

    public abstract String getNameFrame();

    Image getGoodImageSizeNavBar(String pathImg) throws IOException {
        return ImageIO.read(new File(pathImg)).getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
    }
}
