package windows_interface;

import javax.swing.*;
import java.awt.*;

/**
 * Start Window launch
 * @author Grigoriev Ivan
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();

        mainWindow.pack(); //упаковываем все элементы с нашей формы
        mainWindow.setSize(new Dimension(385, 200));
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - 385) / 2;
        int locationY = (screenSize.height - 200) / 2;
        mainWindow.setBounds(locationX, locationY, 385, 200);

        mainWindow.setVisible(true);
    }
}
