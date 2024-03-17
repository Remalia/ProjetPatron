package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonParams;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonRetour;
import ProjetPatron.src.vue.Layout.NavBarLayout;

import javax.swing.*;
import java.io.IOException;

public class NavBarJeu extends MenuAbstract{

    private static NavBarJeu instance;

    private NavBarJeu() throws IOException {
        super();
        this.setName("NavBarJeu");
        this.setLayout(new NavBarLayout());
        ButtonParams param = new ButtonParams("param","assets/images/reglage.png");
        ButtonRetour retour = new ButtonRetour("retour","assets/images/retour.png");
        this.buttons.add(retour);
        this.buttons.add(param);
        this.addAllButtons();
        reScaleAllComponentsImg();
    }

    @Override
    public void reScaleAllComponentsImg() throws IOException {
        for (Button button : buttons){
            if(button.getIcon() != null){
                button.setIcon(new ImageIcon(getGoodImageSizeNavBar(button.getImgPath())));
            }
        }
    }

    public static NavBarJeu getInstance() throws IOException {
        if(instance == null){
            instance = new NavBarJeu();
        }
        instance.reScaleAllComponentsImg();
        return instance;
    }

    @Override
    public String getNameFrame() {
        return "NavBarJeu";
    }

}
