package business_logic;


import paint_graph.GraphPainter;

import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.List;


public class Sorter {
    private final int[][] indMatrix;
    private final GraphPainter painter;
    private List<Integer> res;
    private Deque<Integer> stk;
    private boolean[] visited;
    private int current;
    private int from;
    private STATE state;


    public Sorter(Graph graph, GraphPainter painter) {
        DFSChecker checker = new DFSChecker(graph);
        if (checker.CheckCycle()) {
            this.state = STATE.ERROR;
        }

        this.indMatrix = graph.getIndMatrix();
        this.painter = painter;
        this.res = new LinkedList<>();
        this.stk = new ArrayDeque<>();
        this.visited = new boolean[indMatrix.length];
        this.current = 0;
        this.from = -1;
        this.state = STATE.INIT;
    }

    public List getResult() {
        java.util.Collections.reverse(res);
        return res;
    }

    public STATE getState() {
        return state;
    }

    public void nextStep() {
        painter.fillVertex(current);

        for (int v = 0; v < indMatrix[current].length; v++) {
            if (indMatrix[current][v] == 1) {
                if (visited[v] == false) {
                    painter.fillEdge(current, v);
                    painter.fillVertex(v);

                    stk.addLast(from);
                    stk.addLast(current);

                    from = current;
                    current = v;

                    state = STATE.WORK;
                    return;
                }
            }
        }

        res.add(current);

        if (from != -1) {
            current = stk.pollLast();
            from = stk.pollLast();

            return;
        }
        else {
            for (int v = 0; v < indMatrix.length; v++) {
                if (visited[v] == false) {
                    current = v;
                    painter.fillVertex(v);
                    from = -1;

                    state = STATE.WORK;
                    return;
                }
            }

            state = STATE.END;
        }
    }

}