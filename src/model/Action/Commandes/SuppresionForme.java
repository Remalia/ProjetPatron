package ProjetPatron.src.model.Action.Commandes;

import ProjetPatron.src.model.Formes.Forme;
import ProjetPatron.src.model.MainModel;

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
    public String writeCommand() {
        return "  suppr-"+ forme.getId() +": "+ forme.getId() + "\n" ;
    }

    @Override
    public void readCommand(String key, String val) {
        int id = Integer.parseInt(val);
        for (Forme f : MainModel.getInstance().getFormes()){
            if (f.getId() == id){
                this.forme = f;
            }
        }
    }
}
