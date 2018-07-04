package business_logic;

// TODO import draw.Painter;

import java.util.LinkedList;
import java.util.ArrayDeque;

public enum STATE {
    INIT,
    WORK,
    END,
    ERROR
}

public class Sorter {
    private final int[][] indMatrix;
    private final Painter painter;
    private List<int> res;
    private Deque<int> stk;
    private boolean[] visited;
    private current;
    private from;
    private STATE state;


    public Sorter(Graph graph, Painter painter) {
        Checker checker = new Checker(graph);
        if (checker.CheckCycle()) {
            this.state = STATE.ERROR;
            throw new IllegalArgumentException();
        }

        this.indMatrix = graph.getIndMatrix();
        this.painter = painter;
        this.res = new LinkedList<>();
        this.stk = new ArrayDeque<>();
        this.visited = new boolean[indMatrix.length];
        this.current = 0;
        this.from = -1;
        this.state = STATE.INIT;

        //TODO painter.init(graph);
    }

    public List getResult() {
        java.util.Collections.reverse(res);
        return res;
    }

    public STATE getState() {
        return state;
    }

    public void nextStep() {
        //TODO painter.fillVertex(current);

        for (int v = 0; v < indMatrix[current].length; v++) {
            if (indMatrix[current][v] == 1) {
                if (visited[v] == false) {
                    //TODO painter.fillEdge(current, v);
                    //TODO painter.fillVertex(v);

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
            //TODO painter.refillEdge(from, current)

            current = stk.pollLast();
            from = stk.pollLast();

            return;
        }
        else {
            for (int v = 0; v < indMatrix.length; v++) {
                if (visited[v] == false) {
                    current = v;
                    //TODO painter.fillVertex(v);
                    from = -1;

                    state = STATE.WORK;
                    return;
                }
            }

            state = STATE.END;
        }
    }

}