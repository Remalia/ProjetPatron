package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.model.MainModel;
import ProjetPatron.src.vue.ThemeView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.DecimalFormat;

public class PluginsPane extends MenuAbstract {

    private static PluginsPane instance;
    private JLabel scoreLabel;


    @Override
    public String getNameFrame() {
        return "PluginsFrame";
    }

    private PluginsPane(){
        this.setName("PluginsAddons");
        this.setBackground(ThemeView.getInstance().getColor());
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.scoreLabel = new JLabel();
        this.scoreLabel.setText("Score: " + MainModel.getInstance().getScore().calculScore() + "pts");
        this.scoreLabel.setFont(new Font("Serif", Font.BOLD, 25));
        this.scoreLabel.setForeground(Color.CYAN);
        this.add(scoreLabel);

    }

    @Override
    public void reScaleAllComponentsImg() throws IOException {
        DecimalFormat df = new DecimalFormat("0.000");

        this.scoreLabel.setText("Score: " + df.format(MainModel.getInstance().getScore().calculScore()) + "pts");
    }

    public static PluginsPane getInstance(){
        if(instance == null){
            instance = new PluginsPane();
        }
        return instance;
    }

}
