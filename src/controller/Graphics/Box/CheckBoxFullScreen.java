package ProjetPatron.src.controller.Graphics.Box;

import ProjetPatron.src.model.Param;
import ProjetPatron.src.vue.MainVue;
import ProjetPatron.src.vue.ThemeView;

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
        this.setBackground(ThemeView.getInstance().getColor());
        this.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                try {
                    MainVue.getInstance().setExtendedState(JFrame.MAXIMIZED_BOTH);
                    MainVue.setFrameWidth(MainVue.getInstance().getWidth());
                    MainVue.setFrameHeight(MainVue.getInstance().getHeight());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }else{
                try {
                    MainVue.getInstance().setExtendedState(JFrame.NORMAL);
                    MainVue.getInstance().setLocationRelativeTo(null);
                    ComboBoxResolution.getInstance().actionPerformed((ActionEvent) ComboBoxResolution.getInstance().getAction());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            try {
                Param.saveParam();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
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
