package business_logic;

class DFSChecker {
    private final int[][] indMatrix;

    public Checker(Graph graph) {
        this.indMatrix = graph.getIndMatrix();
    }

    private boolean dfs(boolean visited[], int u) {
        visited[u] = true;

        for (int v : indMatrix[u]) {
            if (v != 0) {
                if (visited[v] == false) {
                    checkCycle(v);
                }
                else {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean CheckCycle() {
        boolean[] visited = new boolean[indMatrix.length];

        for (int u = 0; u < indMatrix.length; u++) {
            if (visited[u] == false) {
                if (dfs(visited, u)) {
                    return true;
                }
            }
        }

        return false;
    }
}