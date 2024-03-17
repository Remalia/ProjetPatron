package ProjetPatron.src.vue;

public class ThemeView {

    private String color;

    private static ThemeView instance;

    private ThemeView(String color){
        if(color.equals("White"))
            setWhite();
        else
            setBlack();
    }

    private void setBlack() {
        //TODO faire un template FULL BLANC
    }

    private void setWhite() {
        //TODO faire un template FULL BLACK
    }

    public void swapColorTo(String color){
        if(color.equals("Black"))
            setBlack();
        else
            setWhite();
    }

    private static String getThemeSaved(){
        String value = "";
        
        return value;
    }

    public static ThemeView getInstance() {
        if(instance == null){
            instance = new ThemeView(getThemeSaved());
        }
        return instance;
    }
}
