package ProjetPatron.src.model.Action;

import ProjetPatron.src.model.Action.Commandes.Command;
import ProjetPatron.src.model.Formes.Forme;
import ProjetPatron.src.model.MainModel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/***
 * Permet de sauvegarder une partie en cours
 */
public class SaveLevel {

    public static void saveGameToYAML(String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path, false);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        writer.write("level: "+MainModel.getInstance().getActualLevel());
        writer.write("\nformes: #( cercle --> centre(x/y) | ext(x/y) ) ( rectangle --> pts1(x/y) | pts2(x/y) ) (triangle --> pts1(x/y) | pts2(x/y) | pts3(x/y) ) + T/F --> Locked ou non\n");
        for (Forme f: MainModel.getInstance().getFormes()){
            writer.write(f.writeForme());
        }
        writer.write("historySvg: #( Pile Undo )\n");
        for (Command c : MainModel.getInstance().getCh().getStackCommand()) {
            writer.write(c.writeCommand());
        }
        writer.write("historyRecup: #( Pile Redo )\n");
        for (Command c : MainModel.getInstance().getCh().getStackRedo()) {
            writer.write(c.writeCommand());
        }
        writer.flush();
        writer.close();
    }
}
