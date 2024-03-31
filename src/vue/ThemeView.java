package ProjetPatron.src.vue;

import java.awt.*;
import java.io.IOException;

public class ThemeView {

    private Color color;
    private static ThemeView instance;

    private ThemeView(){
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getIlluminateColor(){
        return Color.PINK;
    }

    public Color getOppositeColor(){
        if(color == Color.darkGray){
            return Color.lightGray;
        }else{
            return Color.darkGray;
        }
    }

    private void setBlack() throws IOException {
        this.color = Color.darkGray;
        MainVue.getInstance().backgroundHasChanged(Color.darkGray);
    }

    private void setWhite() throws IOException {
        this.color = Color.lightGray;
        MainVue.getInstance().backgroundHasChanged(Color.lightGray);
    }

    public void swapColorTo(String color) throws IOException {
        if(color.equals("Black"))
            setBlack();
        else
            setWhite();
    }

    public static ThemeView getInstance() {
        if(instance == null){
            instance = new ThemeView();
        }
        return instance;
    }
}
