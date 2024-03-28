package ProjetPatron.src.controller.State;


import java.awt.event.MouseEvent;
import java.io.IOException;

public interface State {

    void hasClicked(MouseEvent e) throws IOException;
    void hasReleased(MouseEvent e) throws IOException;
    void hasPressed(MouseEvent e) throws IOException;
    void hasEntered(MouseEvent e);
    void hasExited(MouseEvent e);
}
