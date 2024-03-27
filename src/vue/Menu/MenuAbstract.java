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
