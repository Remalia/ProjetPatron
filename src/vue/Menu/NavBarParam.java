package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonRetour;
import ProjetPatron.src.vue.ImageResizer;
import ProjetPatron.src.vue.Layout.NavBarLayout;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class NavBarParam extends MenuAbstract{

    private static NavBarParam instance;

    private NavBarParam(){
        super();
        this.setName("NavBar");
        this.setLayout(new NavBarLayout());
        ButtonRetour retour = new ButtonRetour("retour","assets/images/retour.png");
        this.buttons.add(retour);
        this.addAllButtons();
    }

    @Override
    public void changeBackground(Color color) {
        super.changeBackground(color);
        for (Component c: this.getComponents()){
            c.setBackground(color);
        }
    }

    @Override
    public void reScaleAllComponentsImg() throws IOException {
        for (Button button : buttons){
            if(button.getIcon() != null){
                button.setIcon(new ImageIcon(ImageResizer.getGoodImageSizeNavBar(button.getImgPath())));
            }
        }
    }

    @Override
    public String getNameFrame() {
        return "NavBarParam";
    }

    public static NavBarParam getInstance() throws IOException {
        if(instance == null){
            instance = new NavBarParam();
        }
        instance.reScaleAllComponentsImg();
        return instance;
    }
}
