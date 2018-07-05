package windows_interface;

import javax.swing.*;
import business_logic.Graph;
import business_logic.Sorter;
import paint_graph.GraphPainter;
import paint_graph.GraphPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Window with loaded graph and alghoritm visualization
 * @author Grigoriev Ivan
 * @version 1.1
 */

public class GraphVisualizationWindow extends JFrame {

    private Sorter sorter;

    public GraphVisualizationWindow(Graph graph) {
        super("LETI project");

        GraphPainter graphPainter = new GraphPainter(graph);
        this.sorter = new Sorter(graph, graphPainter);

        JButton nextButton = new JButton(new AbstractAction("Next") {
            @Override
            public void actionPerformed(ActionEvent e) {
                sorter.nextStep();
            }
        });

        add(graphPainter.getGraphpanel());

        JPanel next = new JPanel(new FlowLayout());
        next.add(nextButton);
        add(next, BorderLayout.SOUTH);
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
//        topFrame.pack();
        repaint();



        //TODO getState error check


}
}
