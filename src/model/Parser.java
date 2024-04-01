package ProjetPatron.src.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Parser {
    /**
     * @param file Fichier à lire
     * @return une liste HashMap clé/valeur avec toutes les balises et les valeurs associées sous forme de string
     * @throws FileNotFoundException Fichier Introuvable
     */
    public static HashMap<String,String> getAllBalise(File file) throws FileNotFoundException {
        HashMap<String, String> balises = new LinkedHashMap<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                String key;
                String line = sc.nextLine();
                line = deleteStartSpace(line);
                key = line.substring(0,line.indexOf(":"));
                if((line.indexOf(":") + 2) < line.length())
                    balises.put(key,line.substring(line.indexOf(":") + 2));
            }
        } catch (IOException e){
            throw new FileNotFoundException("Fichier Introuvable");
        }
        return balises;
    }

    /**
     * Supprime les espaces en début de chaine de caractère
     * @param chaine la chaine en question
     * @return la chaine sans les espaces
     */
    private static String deleteStartSpace(String chaine) {
        int debut = 0;
        while (debut < chaine.length() && chaine.charAt(debut) == ' ') {
            debut++;
        }
        return chaine.substring(debut);
    }
}
