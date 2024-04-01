package ProjetPatron.src.vue;

import ProjetPatron.src.model.Param;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Classe qui permet de redimensionner les images
 */
public class ImageResizer {

    /***
     * Permet d'obtenir la bonne taille d'une image pour la barre de navigation
     * @param pathImg : chemin de l'image
     * @return l'image redimensionnée
     * @throws IOException Exception si l'image n'est pas trouvée
     */
    public static Image getGoodImageSizeNavBar(String pathImg) throws IOException {
        return ImageIO.read(new File(pathImg)).getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
    }

    /***
     * Permet d'obtenir la bonne taille d'une image pour la checkbox (fullscreen)
     * @return l'image redimensionnée
     * @throws IOException Exception si l'image n'est pas trouvée
     */
    public static Image getGoodImageCheckBox() throws IOException {
        String pathImg = Param.isFullScreen() ? "assets/images/Menu/case_cochee.png" : "assets/images/Menu/case.png";
        return ImageIO.read(new File(pathImg)).getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH);
    }

    /***
     * Permet d'obtenir la bonne taille d'une image pour le menu de sélection de niveau
     * @param pathImg : chemin de l'image
     * @return l'image redimensionnée
     * @throws IOException Exception si l'image n'est pas trouvée
     */
    public static Image getGoodImageSizeSelectionNiveau(String pathImg) throws  IOException {
        double widthMult = 0.10;
        double heightMult = 0.12;
        int width = MainVue.getFrameWidth();
        int height = MainVue.getFrameHeight();
        if((width * 100) / height > 155){
            widthMult = 0.12;
            heightMult = 0.17;
        }
        return ImageIO.read(new File(pathImg)).getScaledInstance((int)(width*widthMult),(int)(height*heightMult), Image.SCALE_SMOOTH);
    }

    /***
     * Permet d'obtenir la bonne taille d'une image pour le menu principal
     * @param pathImg : chemin de l'image
     * @return l'image redimensionnée
     * @throws IOException Exception si l'image n'est pas trouvée
     */
    public static Image getGoodImageSizeMenuPrincipal(String pathImg) throws IOException {
        double widthMult = 0.25;
        double heightMult = 0.125;
        int width = MainVue.getFrameWidth();
        int height = MainVue.getFrameHeight();
        if((width * 100) / height > 155){
            widthMult = 0.2;
        }
        return ImageIO.read(new File(pathImg)).getScaledInstance((int)(width*widthMult),(int)(height*heightMult), Image.SCALE_SMOOTH);
    }

}
