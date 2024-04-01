package ProjetPatron.src.vue;

import ProjetPatron.src.model.Action.LoadLevel;
import ProjetPatron.src.model.Param;
import ProjetPatron.src.vue.Layout.LayoutMenuGlobal;
import ProjetPatron.src.vue.Menu.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Objects;
import java.util.Stack;

/***
 * Classe de regroupement de toutes les vues
 */
public class MainVue extends JFrame{

    private static final Stack<String> lastTitleNames = new Stack<>();;
    private static final Stack<Container> backupPanel = new Stack<>();;
    private static MainVue instance;
    private final List<MenuAbstract> allInstance;

    /***
     * Constructeur de la classe MainVue
     * @throws IOException : si il y a un problème avec les instances
     */
    private MainVue() throws IOException {
        allInstance = new ArrayList<>();
        this.setSize(Param.width,Param.height);
        this.getContentPane().setLayout(new LayoutMenuGlobal());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Menu Principal");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(NavBar.getInstance());
        this.getContentPane().add(MenuPrincipal.getInstance());
        this.setVisible(true);
        this.addAllInstance();
    }

    /***
     * Permet de changer de scène
     * @param menu : la nouvelle scène
     * @throws IOException : si il y a un problème avec l'instance
     * @throws InterruptedException : si il y a un problème avec l'instance
     */
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
        instance.repaintAll();
    }

    /***
     * Permet de récupérer la largeur de la fenêtre
     * @return
     */
    public static int getFrameWidth() {
        return Param.width;
    }

    /***
     * Permet de changer la largeur de la fenêtre
     * @param width : la nouvelle largeur
     */
    public static void setFrameWidth(int width) {
        Param.width = width;
    }

    /***
     * Permet de récupérer la hauteur de la fenêtre
     * @return
     */
    public static int getFrameHeight() {
        return Param.height;
    }

    /***
     * Permet de changer la hauteur de la fenêtre
     * @param height : la nouvelle hauteur
     */
    public static void setFrameHeight(int height) {
        Param.height = height;
    }

    /***
     * Permet de changer la résolution de la fenêtre
     * @param width : la nouvelle largeur
     * @param height : la nouvelle hauteur
     */
    public static void swapResolution(int width,int height){
        setFrameWidth(width);
        setFrameHeight(height);
        instance.setSize(new Dimension(width,height));
    }

    /***
     * Permet de re-actualiser tous les composants
     * @throws IOException : si il y a un problème avec l'instance MenuJeu
     */
    public void repaintAll() throws IOException {
        MenuJeu.getInstance().reScaleAllComponentsImg();
        MenuParametre.getInstance().reScaleAllComponentsImg();
        repaint();
        validate();
    }

    /***
     * Permet d'ajouter toutes les instances
     * @throws IOException : si il y a un problème avec les instances
     */
    private void addAllInstance() throws IOException {
        this.allInstance.add(MenuJeu.getInstance());
        this.allInstance.add(MenuParametre.getInstance());
        this.allInstance.add(MenuPrincipal.getInstance());
        this.allInstance.add(MenuSelectionNiveau.getInstance());
        this.allInstance.add(NavBar.getInstance());
        this.allInstance.add(NavBarJeu.getInstance());
        this.allInstance.add(NavBarParam.getInstance());
        this.allInstance.add(NavBarSelectionLVL.getInstance());
    }

    /***
     * Permet de changer le background
     * @param color : la nouvelle couleur
     */
    public void backgroundHasChanged(Color color){
        for(MenuAbstract mA: this.allInstance){
            mA.changeBackground(color);
        }
    }

    /***
     * Permet de retourner à la scène précédente
     * @throws IOException : si il y a un problème avec l'instance
     */
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

    /***
     * Permet de récupérer l'instance unique de la classe MainVue
     * @return l'instance en question
     * @throws IOException : si il y a un problème avec l'instance
     */
    public static MainVue getInstance() throws IOException {
        if(instance == null){
            instance = new MainVue();
        }
        return instance;
    }
}
