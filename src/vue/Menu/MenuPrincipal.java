package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonJouer;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonParams;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonRetour;
import ProjetPatron.src.vue.Layout.LayoutMenuPrincipal;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static ProjetPatron.src.vue.ImageResizer.getGoodImageSizeMenuPrincipal;

public class MenuPrincipal extends MenuAbstract {

    private static MenuPrincipal instance;

    private MenuPrincipal() throws IOException {
        super();
        this.setName("MenuPrincipal");
        this.setLayout(new LayoutMenuPrincipal());
        this.buttons.add(new ButtonJouer("Jouer", "assets/images/Menu/jouer.png"));
        this.buttons.add(new ButtonParams("Paramètres", "assets/images/Menu/paramètres.png"));
        this.buttons.add(new ButtonRetour("Quitter", "assets/images/Menu/quitter.png"));
        this.addAllButtons();
        reScaleAllComponentsImg();
    }

    @Override
    public void reScaleAllComponentsImg() throws IOException {
        for (Button button : buttons){
            if(button.getIcon() != null){
                button.setIcon(new ImageIcon(getGoodImageSizeMenuPrincipal(button.getImgPath())));
            }
        }
    }

    @Override
    public void changeBackground(Color color) {
        super.changeBackground(color);
        for (Component c: this.getComponents()){
            c.setBackground(color);
        }
    }

    public static MenuPrincipal getInstance() throws IOException {
        if(instance == null){
            instance = new MenuPrincipal();
        }
        instance.reScaleAllComponentsImg();
        return instance;
    }

    @Override
    public String getNameFrame() {
        return "Menu Principal";
    }
}
