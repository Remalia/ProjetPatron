package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Bouton.Button;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonParams;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonRetour;
import ProjetPatron.src.vue.Layout.NavBarLayout;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class NavBar extends MenuAbstract{

    private static NavBar instance;
    private final ButtonRetour btnRetour;
    private boolean isImageLeave;

    private NavBar(boolean isImageLeave){
        super();
        this.setName("NavBar");
        this.isImageLeave = isImageLeave;
        this.setLayout(new NavBarLayout());
        ButtonParams param = new ButtonParams("param","assets/images/reglage.png");
        this.btnRetour = new ButtonRetour("retour",getImageLeaveOrReturn());
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

    private String getImageLeaveOrReturn(){
        if(isImageLeave)
            return "assets/images/annuler.png";
        else
            return "assets/images/retour.png";
    }

    public static NavBar getInstance(boolean isImageLeave) throws IOException {
        if(instance == null){
            instance = new NavBar(isImageLeave);
        }else{
            instance.setIsImageLeave(isImageLeave);
        }
        instance.reScaleAllComponentsImg();
        return instance;
    }

    private void setIsImageLeave(Boolean isImageLeave) throws IOException {
        this.isImageLeave = isImageLeave;
        this.btnRetour.setIcon(new ImageIcon(getGoodImageSizeNavBar(getImageLeaveOrReturn())));
    }

    @Override
    public String getNameFrame() {
        return "NavBar";
    }
}
