package ProjetPatron.src.controller.Graphics.Box;

import javax.swing.*;

public class ComboBoxResolution extends JComboBox<String> {

    private static ComboBoxResolution instance;

    private ComboBoxResolution(){
        String[] resolutions = {"1920*1080","1280*1024","800*600"};
        this.setName("cbResolution");
        for (String resolution: resolutions)
            this.addItem(resolution);
    }

    public static ComboBoxResolution getInstance(){
        if(instance == null){
            instance = new ComboBoxResolution();
        }
        return instance;
    }

}
