package windows_interface;

import javax.swing.*;

/**
 * Window with loaded graph and alghoritm visualization
 * @author Grigoriev Ivan
 * @version 1.1
 */

public class GraphVisualizationWindow extends JFrame {
    private JButton button1;
    private JPanel panel;
    private JPanel graph_panel;

    //TODO private Sorter sorter;

    public GraphVisualizationWindow(/*TODO Graph graph*/) {
        super("LETI project");
        this.getContentPane().add(panel);
        //TODO this.sorter = new Sorter(graph, new GraphPainter(this, graph));
    }
}
