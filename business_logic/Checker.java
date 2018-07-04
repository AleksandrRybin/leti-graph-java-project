package business_logic;

class DFSChecker {
    private final int[][] indMatrix;
    private final boolean[] visited;

    public Checker(Graph graph) {
        this.indMatrix = graph.getIndMatrix();
        visited = new boolean[indMatrix.length];
    }

    private boolean dfs(int u) {
        visited[u] = true;

        for (int v = 0; v < indMatrix[u].length; v++) {
            if (indMatrix[u][v] != 0) {
                if (visited[v] == false) {
                    dfs(v);
                }
                else {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean CheckCycle() {
        for (int u = 0; u < indMatrix.length; u++) {
            if (visited[u] == false) {
                if (dfs(u)) {
                    return true;
                }
            }
        }

        return false;
    }
}