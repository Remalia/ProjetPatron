package ProjetPatron.src.vue;

import ProjetPatron.src.model.Param;
import ProjetPatron.src.vue.Layout.LayoutMenuGlobal;
import ProjetPatron.src.vue.Menu.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Objects;
import java.util.Stack;

/***
 * Classe de regroupement de toutes les vues
 */
public class MainVue extends JFrame{

    private static int width = 800;
    private static int height = 600;
    private static final Stack<String> lastTitleNames = new Stack<>();;
    private static final Stack<Container> backupPanel = new Stack<>();;
    private static MainVue instance;

    private MainVue() throws IOException {
        this.setSize(width,height);
        this.getContentPane().setLayout(new LayoutMenuGlobal());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Menu Principal");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(NavBar.getInstance());
        this.getContentPane().add(MenuPrincipal.getInstance());
        this.setVisible(true);
    }

    public static void changeScene(MenuAbstract menu) throws IOException, InterruptedException {
        lastTitleNames.push(instance.getTitle());
        MenuAbstract navBarNeeded;
        if(menu == MenuPrincipal.getInstance()){
            navBarNeeded = NavBar.getInstance();
        }else{
            if(menu == MenuParametre.getInstance())
                navBarNeeded = NavBarParam.getInstance();
            else{
                if (menu == MenuJeu.getInstance())
                    navBarNeeded = NavBarJeu.getInstance();
                else
                    navBarNeeded = NavBarSelectionLVL.getInstance();
            }

        }
        Container oldPanel = new Container();
        for(Component comp: instance.getContentPane().getComponents()){
            oldPanel.add(comp);
        }
        backupPanel.push(oldPanel);
        instance.getContentPane().removeAll();
        instance.getContentPane().add(navBarNeeded);
        instance.getContentPane().add(menu);
        instance.setTitle(menu.getNameFrame());
        instance.repaint();
        instance.validate();
    }


    public static int getFrameWidth() {
        return width;
    }

    public static void setFrameWidth(int width) {
        MainVue.width = width;
    }

    public static int getFrameHeight() {
        return height;
    }

    public static void setFrameHeight(int height) {
        MainVue.height = height;
    }

    public static void swapResolution(int width,int height){
        setFrameWidth(width);
        setFrameHeight(height);
        instance.setSize(new Dimension(width,height));
    }

    public void repaintAll() throws IOException {
        MenuJeu.getInstance().reScaleAllComponentsImg();
        repaint();
        validate();
    }

    public void backgroundHasChanged(Color color) throws IOException {
        MenuJeu.getInstance().changeBackground(color);
        MenuParametre.getInstance().changeBackground(color);
        MenuPrincipal.getInstance().changeBackground(color);
        MenuSelectionNiveau.getInstance().changeBackground(color);
        NavBar.getInstance().changeBackground(color);
        NavBarJeu.getInstance().changeBackground(color);
        NavBarParam.getInstance().changeBackground(color);
        NavBarSelectionLVL.getInstance().changeBackground(color);
    }

    public static void backScene() throws IOException {
        if(lastTitleNames.empty()) {
            System.out.println("Closing game");
            instance.dispatchEvent(new WindowEvent(instance, WindowEvent.WINDOW_CLOSING));
        }else{
            String title = lastTitleNames.pop();
            instance.setTitle(title);
            Container oldPanel = new Container();
            for (Component comp : backupPanel.pop().getComponents()){
                oldPanel.add(comp);
            }
            instance.getContentPane().removeAll();
            if(Objects.equals(title, "Menu Principal"))
                instance.getContentPane().add(NavBar.getInstance());
            if(Objects.equals(title, "Menu Selection de niveau"))
                instance.getContentPane().add(NavBarSelectionLVL.getInstance());
            for (Component comp : oldPanel.getComponents()){
                MenuAbstract menu = (MenuAbstract)comp;
                menu.reScaleAllComponentsImg();
                instance.getContentPane().add(comp);
            }
            instance.repaint();
            instance.validate();
        }
    }

    public static MainVue getInstance() throws IOException {
        if(instance == null){
            instance = new MainVue();
        }
        return instance;
    }
}
