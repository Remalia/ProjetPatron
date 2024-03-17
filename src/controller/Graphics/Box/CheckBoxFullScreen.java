package ProjetPatron.src.controller.Graphics.Box;

import ProjetPatron.src.vue.MainVue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class CheckBoxFullScreen extends JCheckBox {

    private static CheckBoxFullScreen instance;

    private CheckBoxFullScreen(){
        this.setText("Fullscreen (ignore resolution)");
        this.setName("cbFullScreen");
        this.addItemListener(e -> {
            if(e.getStateChange() == 1) {
                try {
                    MainVue.getInstance().setExtendedState(JFrame.MAXIMIZED_BOTH);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }else{
                try {
                    MainVue.getInstance().setExtendedState(JFrame.NORMAL);
                    MainVue.getInstance().setLocationRelativeTo(null);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static CheckBoxFullScreen getInstance(){
        if (instance == null){
            instance = new CheckBoxFullScreen();
        }
        return instance;
    }

}
