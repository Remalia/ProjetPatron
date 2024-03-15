package ProjetPatron.src.controller.Graphics.Box;

import javax.swing.*;

public class CheckBoxFullScreen extends JCheckBox {

    private static CheckBoxFullScreen instance;

    private CheckBoxFullScreen(){
        this.setText("Fullscreen (ignore resolution)");
        this.setName("cbFullScreen");
    }

    public static CheckBoxFullScreen getInstance(){
        if (instance == null){
            instance = new CheckBoxFullScreen();
        }
        return instance;
    }

}
