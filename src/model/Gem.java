package model;

import java.awt.*;
import java.util.Random;
import utilits.RandomSingleton;

public class Gem {
    public final static Color[] colors = new Color[] {Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.RED, Color.YELLOW};
    Random r = RandomSingleton.getRandom();

    private Color color;

    public Gem(Color color){
        this.color = color;
    }

    public Gem() {
        color = colors[r.nextInt(Gem.colors.length)];
    }

    public Color getColor() {
        return color;
    }
}