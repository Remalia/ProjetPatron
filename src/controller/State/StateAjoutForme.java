package ProjetPatron.src.controller.State;

import ProjetPatron.src.model.Formes.Coord;

import java.util.ArrayList;
import java.util.List;

public abstract class StateAjoutForme implements State{
    private List<Coord> posClicks;

    protected StateAjoutForme(){
        this.posClicks = new ArrayList<>();
    }

    public List<Coord> getPosClicks() {
        return posClicks;
    }

    public void setPosClicks(List<Coord> posClicks) {
        this.posClicks = posClicks;
    }
}
