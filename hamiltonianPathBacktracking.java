public class hamiltonianPathBacktracking
{
    int path[];

    boolean isSafe(int v, int graph[][], int path[], int pos)
    {
        /* Check if this vertex is an adjacent vertex of
           the previously added vertex. */
        if (graph[path[pos - 1]][v] == 0)
            return false;

        /* Check if the vertex has already been included.
           This step can be optimized by creating an array
           of size V */
        for (int i = 0; i < pos; i++)
            if (path[i] == v)
                return false;

        return true;
    }


    boolean hamPathUtil(int graph[][], int path[], int pos)
    {
        int V = graph.length;

        if (pos == V)
            return true;

        for (int v = 0; v < V; v++)
        {
            if (isSafe(v, graph, path, pos))
            {
                path[pos] = v;

                /* recur to construct rest of the path */
                if (hamPathUtil(graph, path, pos + 1) == true)
                    return true;

                /* If adding vertex v doesn't lead to a solution,
                   then remove it */
                path[pos] = -1;
            }
        }
        
        return false;
    }

    boolean hamPath(int graph[][])
    {
        int V = graph.length;
        path = new int[V];
        for (int i = 0; i < V; i++)
            path[i] = -1;

        for (int i = 0; i < V; i++) {
            path[0] = i;
            if (hamPathUtil(graph, path, 1) == true) {
                // printSolution(path);
                return true;
            }
            path[0] = -1;
        }

        // System.out.println("\nSolution does not exist");
        return false;
    }

    // void printSolution(int path[])
    // {
    //     int V = path.length;
    //     System.out.println("Solution Exists: Following" +
    //                        " is one Hamiltonian Path");
    //     for (int i = 0; i < V; i++)
    //         System.out.print(" " + path[i] + " ");
    //     System.out.println();
    // }
}
