package ProjetPatron.src.controller.Graphics.Box;

import ProjetPatron.src.model.Param;
import ProjetPatron.src.vue.MainVue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ComboBoxResolution extends JComboBox<String> implements ActionListener {

    private static ComboBoxResolution instance;

    private ComboBoxResolution(){
        String[] resolutions = {"1920x1080","1280x1024","800x600"};
        this.setName("cbResolution");
        for (String resolution: resolutions)
            this.addItem(resolution);
        this.addActionListener(e -> {
            MainVue mv;
            try {
                mv = MainVue.getInstance();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            JComboBox cb = (JComboBox)e.getSource();
            String item = (String)cb.getSelectedItem();
            String[] tabItems = item.split("x");
            if(mv.getExtendedState() != 6){
                MainVue.setFrameHeight(Integer.parseInt(tabItems[0]));
                MainVue.setFrameWidth(Integer.parseInt(tabItems[1]));
                MainVue.swapResolution(Integer.parseInt(tabItems[0]),Integer.parseInt(tabItems[1]));
                try {
                    MainVue.getInstance().setLocationRelativeTo(null);
                } catch (IOException exp) {
                    throw new RuntimeException(exp);
                }
            }else{
                mv.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
            try {
                Param.saveParam();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

    }

    public static ComboBoxResolution getInstance(){
        if(instance == null){
            instance = new ComboBoxResolution();
        }
        return instance;
    }

}
