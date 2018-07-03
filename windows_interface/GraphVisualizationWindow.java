package windows_interface

import javax.swing.*;

/**
 * Window with loaded graph and alghoritm visualization
 * @author Grigoriev Ivan
 * @version 1.0
 */

public class GraphVisualizationWindow extends JFrame {
    private JButton button1;
    private JPanel panel;

    public GraphVisualizationWindow() {
        super("LETI project");
        this.getContentPane().add(panel);
    }
}
