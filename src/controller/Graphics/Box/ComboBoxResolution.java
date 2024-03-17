package ProjetPatron.src.controller.Graphics.Box;

import ProjetPatron.src.vue.MainVue;

import javax.swing.*;
import java.io.IOException;

public class ComboBoxResolution extends JComboBox<String> {

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
            if(mv.getExtendedState() != 6){
                JComboBox cb = (JComboBox)e.getSource();
                String item = (String)cb.getSelectedItem();
                String[] tabItems = item.split("x");
                MainVue.swapResolution(Integer.parseInt(tabItems[0]),Integer.parseInt(tabItems[1]));
                try {
                    MainVue.getInstance().setLocationRelativeTo(null);
                } catch (IOException exp) {
                    throw new RuntimeException(exp);
                }
            }else{
                JComboBox cb = (JComboBox)e.getSource();
                String item = (String)cb.getSelectedItem();
                String[] tabItems = item.split("x");
                MainVue.swapResolution(Integer.parseInt(tabItems[0]),Integer.parseInt(tabItems[1]));
                mv.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
