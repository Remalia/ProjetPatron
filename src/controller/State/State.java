package ProjetPatron.src.controller.State;


import java.awt.event.MouseEvent;

public interface State {

    void hasClicked(MouseEvent e);
    void hasReleased(MouseEvent e);
    void hasPressed(MouseEvent e);
    void hasEntered(MouseEvent e);
    void hasExited(MouseEvent e);
}
