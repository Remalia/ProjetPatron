package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonParams;
import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonRetour;
import ProjetPatron.src.vue.Layout.NavBarLayout;
import ProjetPatron.src.vue.MainVue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class NavBar extends MenuAbstract{

    private static NavBar instance;
    private ButtonRetour btnRetour;
    private boolean isImageLeave;

    private NavBar(boolean isImageLeave) throws IOException {
        this.setName("NavBar");
        this.isImageLeave = isImageLeave;
        this.setLayout(new NavBarLayout());
        ButtonParams param = new ButtonParams("param",getGoodImageSizeNavBar("assets/images/reglage.png"));
        btnRetour = new ButtonRetour("retour",getGoodImageSizeNavBar(getImageLeaveOrReturn()));
        this.add(btnRetour);
        this.add(param);
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
