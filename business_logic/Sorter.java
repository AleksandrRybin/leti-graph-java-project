package business_logic;

// TODO import draw.Painter;

import java.util.LinkedList;
import java.util.ArrayDeque;

public enum STATE {
    WORK,
    END
}

public class Sorter {
    private final int[][] indMatrix;
    private final Painter painter;
    private List<int> res;
    private Deque<int> stk;
    private boolean[] visited;
    private current;
    private from;


    public Sorter(Graph graph, Painter painter) {
        this.indMatrix = graph.getIndMatrix();
        this.painter = painter;
        this.res = new LinkedList<>();
        this.stk = new ArrayDeque<>();
        this.visited = new boolean[indMatrix.length];
        this.current = 0;
        this.from = -1;

        Checker checker = new Checker(this);
        if (checker.CheckCycle()) {
            throw new IllegalArgumentException();
        }

        //TODO painter.init(graph);
    }

    public List getResult() {
        java.util.Collections.reverse(res);
        return res;
    }

    public STATE nextStep() {
        //TODO painter.fillVertex(current);

        for (int v = 0; v < indMatrix.length; v++) {
            if (indMatrix[current][v] == 1) {
                if (visited[v] == false) {
                    //TODO painter.fillEdge(current, v);

                    stk.addLast(from);
                    stk.addLast(current);

                    from = current;
                    current = v;

                    return WORK;
                }
            }
        }

        res.add(current);

        if (from != -1) {
            //TODO painter.refillEdge(from, current)

            current = stk.pollLast();
            from = stk.pollLast();

            return WORK;
        }
        else {
            for (int v = 0; v < indMatrix.length; v++) {
                if (visited[v] == false) {
                    current = v;
                    //TODO painter.fillVertex(v);
                    from = -1;

                    return WORK;
                }
            }

            return END;
        }
    }

}