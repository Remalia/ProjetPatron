package ProjetPatron.src.vue.Menu;
import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.vue.MainVue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class MenuAbstract extends JPanel{

    public abstract String getNameFrame();
    protected List<Button> buttons;

    protected MenuAbstract(){
        this.buttons = new ArrayList<>();
    }

    protected Image getGoodImageSizeNavBar(String pathImg) throws IOException {
        return ImageIO.read(new File(pathImg)).getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
    }

    protected Image getGoodImageSizeMenuPrincipal(String pathImg) throws IOException {
        int width = MainVue.getFrameWidth();
        int height = MainVue.getFrameHeight();
        return ImageIO.read(new File(pathImg)).getScaledInstance((int)(width*0.20),(int)(height*0.10),java.awt.Image.SCALE_SMOOTH);
    }

    public abstract void reScaleAllComponentsImg() throws IOException;

    protected void addAllButtons(){
        for(Button button : buttons){
            this.add(button);
        }
    }
}
