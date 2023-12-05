import java.util.Random;

public class Main {
    public static int[][] generateRandomGraph(int numVertices) {
        Random rand = new Random();
        int[][] graph = new int[numVertices][numVertices];
    
        for(int i = 0; i < numVertices; i++) {
            for(int j = i + 1; j < numVertices; j++) {
                // Connect vertices with probability 0.5
                if(rand.nextBoolean()) {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }
    
        return graph;
    }
    public static void main(String[] args) {
        //custom input
        int graph[][] = 
        {   {0, 0, 1, 1},
            {0, 0, 1, 0},
            {1, 1, 0, 0},
            {1, 0, 0, 0},
        };
        boolean dp = hamiltonianPathDP.Hamiltonian_path(graph, graph.length);      
        System.out.println("Custom input:");
        System.out.println("DP algorithm " + graph.length + " vertices: " + dp);
        hamiltonianPathBacktracking bt = new hamiltonianPathBacktracking();
        System.out.println("Backtracking algorithm " + graph.length + " vertices: " + bt.hamPath(graph));


        
        int[] sizes = {16, 18, 20};
        for (int size : sizes) {
            int[][] randomGraph = generateRandomGraph(size);
            boolean hasHamiltonianDP = hamiltonianPathDP.Hamiltonian_path(randomGraph, size);      
            
            System.out.println("----------------------------------------\n");
            System.out.println("DP algorithm " + size + " vertices: " + hasHamiltonianDP);
            
            long startTime = System.nanoTime();
            long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            hamiltonianPathDP.Hamiltonian_path(randomGraph, size);

            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            long memoryUsed = memoryAfter - memoryBefore;
            
            System.out.println("Execution time in milliseconds: " + elapsedTime/1000000.0);
            System.out.println("Memory used in bytes: " + memoryUsed); 
            System.out.println("----------------------------------------\n");

            hamiltonianPathBacktracking hamiltonBacktracking = new hamiltonianPathBacktracking();
            boolean hamPathResult = hamiltonBacktracking.hamPath(randomGraph);        
            System.out.println("Backtracking algorithm " + size + " vertices: " + hamPathResult);

            startTime = System.nanoTime();
            memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            hamiltonBacktracking.hamPath(randomGraph);

            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            memoryUsed = memoryAfter - memoryBefore;

            System.out.println("Execution time in milliseconds: " + elapsedTime/1000000.0);
            System.out.println("Memory used in bytes: " + memoryUsed);
            System.out.println("----------------------------------------\n");

        }
    }   
}


