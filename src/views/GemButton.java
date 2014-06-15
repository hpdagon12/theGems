package views;

import model.GameFieldCoord;

import javax.swing.*;

public class GemButton extends JButton {
    GameFieldCoord coord;

    public GemButton(GameFieldCoord coord) {
        this.coord = coord;
    }

    public GameFieldCoord getCoord() {
        return coord;
    }

    public void setCoord(GameFieldCoord coord) {
        this.coord = coord;
    }
}