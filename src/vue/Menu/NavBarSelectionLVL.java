package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonParams;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonRetour;
import ProjetPatron.src.vue.Layout.NavBarLayout;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class NavBarSelectionLVL extends MenuAbstract{

    private static NavBarSelectionLVL instance;

    private NavBarSelectionLVL(){
        super();
        this.setName("NavBar");
        this.setLayout(new NavBarLayout());
        ButtonParams param = new ButtonParams("param","assets/images/reglage.png");
        ButtonRetour btnRetour = new ButtonRetour("retour", "assets/images/retour.png");
        this.buttons.add(param);
        this.buttons.add(btnRetour);
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
                button.setIcon(new ImageIcon(getGoodImageSizeNavBar(button.getImgPath())));
            }
        }
    }

    public static NavBarSelectionLVL getInstance() throws IOException {
        if(instance == null){
            instance = new NavBarSelectionLVL();
        }
        instance.reScaleAllComponentsImg();
        return instance;
    }

    @Override
    public String getNameFrame() {
        return "NavBar";
    }
}

