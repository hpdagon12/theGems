package views;

/**
 * Created by sasus on 15.06.14.
 */
import application.Application;
import model.GameFieldCoord;
import model.GameService;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;



public class MainWindow extends JFrame {
    private final int FIELD_ROWS;
    private final int FIELD_COLLS;

    private GameFieldCoord firstClick = null;

    private final GameService g;

    public MainWindow(GameService g) {
        super(Application.APP_NAME);

        this.g = g;

        FIELD_COLLS = g.getCollsCount();
        FIELD_ROWS = g.getCollsCount();

        setSize(600, 600);
        GridLayout layout = new GridLayout(FIELD_ROWS, FIELD_COLLS);
        layout.setVgap(10);
        layout.setHgap(10);
        getContentPane().setLayout(layout);
        redraw();

    }

    private void redraw() {
        //this.removeAll();
        for (Integer i = 0; i < FIELD_ROWS; i++) {
            for (Integer j = 0; j < FIELD_COLLS; j++) {
                GemButton b = new GemButton(new GameFieldCoord(j, i));
                b.setBackground( g.get(i, j).getColor());
                b.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        GemButton gb = (GemButton) e.getComponent();
                        click(gb.getCoord());
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
                add(b);
            }
        }

        this.revalidate();
    }

    private JButton getCell(int row, int coll) {
        Container pane = this.getContentPane();
        int index = FIELD_ROWS*coll+row;
        JButton b = (JButton) pane.getComponent(index);
        return b;
    }

    private void click(GameFieldCoord gfc) {
        if (firstClick != null) {
            if (g.swap(gfc.getY(), gfc.getX(), firstClick.getY(), firstClick.getX())) {
                this.removeAll();
                redraw();
            }
        } else {
            firstClick = gfc;
        }
    }
}