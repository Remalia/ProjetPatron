package ProjetPatron.src.model;

import ProjetPatron.src.controller.Graphics.Box.CheckBoxFullScreen;
import ProjetPatron.src.controller.Graphics.Box.ComboBoxResolution;
import ProjetPatron.src.controller.Graphics.Box.ComboBoxTheme;
import ProjetPatron.src.vue.MainVue;
import ProjetPatron.src.vue.ThemeView;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Param {

    private static boolean fullScreen;

    public static void setFullScreen(boolean b){
        fullScreen = b;
    }

    public static boolean isFullScreen(){
        return fullScreen;
    }

    public static void loadParam() throws IOException {
        ComboBoxResolution cbr = ComboBoxResolution.getInstance();
        ComboBoxTheme cbt = ComboBoxTheme.getInstance();
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
                            cbt.setSelectedIndex(0);
                        } else {
                            tv.setColor(Color.DARK_GRAY);
                            cbt.setSelectedIndex(1);
                        }
                        break;
                    case "FullScreen" :
                        if(val.equals("false")){
                            fullScreen = false;
                            cf.setSelected(false);
                        }else{
                            fullScreen = true;
                            cf.setSelected(true);
                        }
                        break;
                }
            });
        }
        MainVue.getInstance().backgroundHasChanged(tv.getColor());
    }

    public static void saveParam() throws IOException {
        ComboBoxResolution cbr = ComboBoxResolution.getInstance();
        ComboBoxTheme cbt = ComboBoxTheme.getInstance();
        CheckBoxFullScreen cf = CheckBoxFullScreen.getInstance();
        FileWriter fic = new FileWriter("assets/param.yaml");
        fic.append("Resolution: ").append(String.valueOf(cbr.getSelectedItem()));
        fic.append("\nTheme: ").append(String.valueOf(cbt.getSelectedItem()));
        fic.append("\nFullScreen: ").append(String.valueOf(cf.isSelected()));
        fic.flush();
        fic.close();
    }
}
