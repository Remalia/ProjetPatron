package ProjetPatron.src.model.Action;

import ProjetPatron.src.model.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

/***
 * Permet de charger une partie
 */
public class LoadLevel {

    /***
     * Permet de charger une partie depuis un fichier YAML
     * @param path : le chemin du fichier
     * @throws FileNotFoundException Fichier Yaml non trouvé
     */
    public static void loadGameFromYAML(String path) throws FileNotFoundException {
        HashMap<String,String> hashMap =  Parser.getAllBalise(new File(path));

    }
}
