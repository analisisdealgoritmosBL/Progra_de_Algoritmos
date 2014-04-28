package tenis.app;

import tenis.logic.ViewController;
import tenis.views.MainWindow;

/**
 *
 * @author L. Antonio Hidalgo
 */
public class Main {
    public static void main(String[] args) {
        ViewController windowController = new ViewController();
        MainWindow window = new MainWindow(windowController);
    }
}
