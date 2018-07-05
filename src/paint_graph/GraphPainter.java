package paint_graph;

import business_logic.*;
import windows_interface.*;

import javax.swing.*;
import java.awt.*;


public class GraphPainter {
    private final GraphPanel graphpanel;

    public GraphPainter(Graph graph){

        this.graphpanel = new GraphPanel(graph);

        // TODO: get Panel from window or create _window.setPanel(graphpanel);
    }

    public GraphPanel getGraphpanel() {
        return graphpanel;
    }

	// TODO: Compatibility
    public void fillVertex(int node){
        graphpanel.changeColorOfNode(node);
    }
    public void fillEdge(int node1, int node2) {
        graphpanel.changeColorOfEdge(node1, node2);
    }
}
