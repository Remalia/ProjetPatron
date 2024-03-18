package ProjetPatron.src.model;

import ProjetPatron.src.controller.Graphics.Box.CheckBoxFullScreen;
import ProjetPatron.src.controller.Graphics.Box.ComboBoxResolution;
import ProjetPatron.src.vue.MainVue;
import ProjetPatron.src.vue.ThemeView;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Param {

    public static void loadParam() throws IOException {
        ComboBoxResolution cbr = ComboBoxResolution.getInstance();
        ThemeView tv = ThemeView.getInstance();
        CheckBoxFullScreen cf = CheckBoxFullScreen.getInstance();
        HashMap<String,String> balises = Parser.getAllBalise(new File("assets/param.yaml"));
        if (!balises.isEmpty()){
            balises.forEach((key, val) -> {
                switch (key){
                    case "Resolution" :
                        switch (val) {
                            case "800x600": cbr.setSelectedIndex(2); break;
                            case "1920x1080": cbr.setSelectedIndex(0); break;
                            case "1280x1024": cbr.setSelectedIndex(1); break;
                        }
                        break;
                    case "Theme" :
                        if (val.equals("White")) {
                            tv.setColor(Color.lightGray);
                        } else {
                            tv.setColor(Color.DARK_GRAY);
                        }
                        break;
                    case "FullScreen" :
                        if(val.equals("false")){
                            cf.setSelected(false);
                        }else{
                            cf.setSelected(true);
                        }
                        break;
                }
            });
        }
        MainVue.getInstance().backgroundHasChanged(tv.getColor());
    }

    public static void saveParam(){
        //TODO SAUVEGARDER LES PARAMS ACTUEL DES INSTANCES DANS LE FICHIER PARAM.YAML
    }
}
