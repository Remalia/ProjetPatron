package ProjetPatron.src.vue.Menu;
import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.vue.MainVue;
import ProjetPatron.src.vue.ThemeView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class MenuAbstract extends JPanel{

    public abstract String getNameFrame();
    protected List<Button> buttons;

    protected MenuAbstract(){
        this.buttons = new ArrayList<>();
        this.setBackground(ThemeView.getInstance().getColor());
    }

    protected Image getGoodImageSizeNavBar(String pathImg) throws IOException {
        return ImageIO.read(new File(pathImg)).getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
    }

    protected Image getGoodImageSizeSelectionNiveau(String pathImg) throws  IOException {
        double widthMult = 0.10;
        double heightMult = 0.12;
        int width = MainVue.getFrameWidth();
        int height = MainVue.getFrameHeight();
        if((width * 100) / height > 155){
            widthMult = 0.12;
            heightMult = 0.17;
        }
        return ImageIO.read(new File(pathImg)).getScaledInstance((int)(width*widthMult),(int)(height*heightMult), Image.SCALE_SMOOTH);
    }

    protected Image getGoodImageSizeMenuPrincipal(String pathImg) throws IOException {
        double widthMult = 0.25;
        double heightMult = 0.125;
        int width = MainVue.getFrameWidth();
        int height = MainVue.getFrameHeight();
        if((width * 100) / height > 155){
            widthMult = 0.2;
        }
        return ImageIO.read(new File(pathImg)).getScaledInstance((int)(width*widthMult),(int)(height*heightMult), Image.SCALE_SMOOTH);
    }

    public void changeBackground(Color color){
        this.setBackground(color);
    }

    public abstract void reScaleAllComponentsImg() throws IOException;

    protected void addAllButtons(){
        for(Button button : buttons){
            this.add(button);
        }
    }
}
