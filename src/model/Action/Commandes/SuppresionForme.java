package ProjetPatron.src.model.Action.Commandes;

import ProjetPatron.src.model.Formes.Forme;
import ProjetPatron.src.model.MainModel;
import ProjetPatron.src.model.Parser;

public class SuppresionForme implements Command {

    private Forme forme;

    public SuppresionForme(){}

    public SuppresionForme(Forme f){
        this.forme = f;
    }
    @Override
    public void execute() {
        MainModel.getInstance().getFormes().remove(forme);
    }

    @Override
    public void backtrack() {
        MainModel.getInstance().getFormes().add(forme);
    }

    @Override
    public String writeCommand(boolean svg) {
        return "  suppr: " + forme.getId();
    }

    @Override
    public void readCommand(String ligne) {
        this.forme = MainModel.getInstance().getFormes().get(Integer.parseInt(ligne));
    }
}
