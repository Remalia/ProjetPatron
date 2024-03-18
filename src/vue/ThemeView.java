package ProjetPatron.src.vue;

import java.awt.*;
import java.io.IOException;

public class ThemeView {

    private Color color;

    private static ThemeView instance;

    private ThemeView(String color){
        if(color.equals("White"))
            this.color = Color.lightGray;
        else
            this.color = Color.darkGray;
    }

    public Color getColor(){
        return color;
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

    private static String getThemeSaved(){
        String value = "White";
        return value;
    }

    public static ThemeView getInstance() {
        if(instance == null){
            instance = new ThemeView(getThemeSaved());
        }
        return instance;
    }
}
