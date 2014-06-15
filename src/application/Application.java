package application;

import model.GameService;
import views.MainWindow;
import javax.swing.JFrame;

public class Application {

    public static final String APP_NAME = "Gems";

    public void run() {
        GameService gameService = new GameService(8,8);
        MainWindow w = new MainWindow(gameService);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setVisible(true);

    }

    public static void main(String[] args) {
        Application a = new Application();
        a.run();
    }

}