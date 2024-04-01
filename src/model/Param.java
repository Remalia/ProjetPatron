package ProjetPatron.src.model;

import ProjetPatron.src.controller.Graphics.Bouton.menus.ButtonReset;
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

/***
 * Classe qui permet de gérer les paramètres de l'application
 */
public class Param {

    public static int width = 800;
    public static int height = 600;
    private static boolean fullScreen;

    /***
     * Permet de changer le mode plein écran
     * @param b : true si on veut le mode plein écran, false sinon
     */
    public static void setFullScreen(boolean b){
        fullScreen = b;
    }

    /***
     * Permet de savoir si on est en mode plein écran
     * @return true si on est en mode plein écran, false sinon
     */
    public static boolean isFullScreen(){
        return fullScreen;
    }

    /***
     * Permet de charger les paramètres de l'application
     * @throws IOException Exception si le fichier n'est pas trouvé
     */
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
                            case "800x600": cbr.setSelectedIndex(2); width = 800; height = 600; break;
                            case "1920x1080": cbr.setSelectedIndex(0); width = 1920; height = 1080; break;
                            case "1280x1024": cbr.setSelectedIndex(1); width = 1280; height = 1024; break;
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

    /***
     * Permet de sauvegarder les paramètres de l'application
     * @throws IOException Exception si le fichier n'est pas trouvé
     */
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
