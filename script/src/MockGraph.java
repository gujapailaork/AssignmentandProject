import java.util.*;

public class MockGraph {

    
    private Map<Integer, Integer> vertexToIndexMap = new HashMap<>(); 
    
    private List<Integer> sortedVertices = new ArrayList<>(); 
    private int[][] adjMatrix;
    private int numVertices = 0;
    private int numEdges = 0;

    public void buildGraph(String edgeListInput) {
        
        vertexToIndexMap.clear();
        sortedVertices.clear();
        numEdges = 0;
        Set<Integer> uniqueVertices = new HashSet<>();
        List<int[]> edgesList = new ArrayList<>();

        
        String[] edges = edgeListInput.split(",\\s*");
        if (edges.length > 0 && !edges[0].trim().isEmpty()) {
            for (String edge : edges) {
                String[] parts = edge.split("-");
                if (parts.length == 2) {
                    try {
                        int u = Integer.parseInt(parts[0].trim());
                        int v = Integer.parseInt(parts[1].trim());

                        if (u != v) {
                            uniqueVertices.add(u);
                            uniqueVertices.add(v);
                            edgesList.add(new int[]{u, v});
                            numEdges++; 
                        }
                    } catch (NumberFormatException e) {
                        
                    }
                }
            }
        }
        
        
        numVertices = uniqueVertices.size();
        sortedVertices.addAll(uniqueVertices);
        Collections.sort(sortedVertices); 
        
        
        for (int i = 0; i < numVertices; i++) {
            vertexToIndexMap.put(sortedVertices.get(i), i);
        }
        
        
        adjMatrix = new int[numVertices][numVertices];
        
        for (int[] edge : edgesList) {
            int u = edge[0];
            int v = edge[1];
            
            if (vertexToIndexMap.containsKey(u) && vertexToIndexMap.containsKey(v)) {
                int uIndex = vertexToIndexMap.get(u);
                int vIndex = vertexToIndexMap.get(v);

                
                adjMatrix[uIndex][vIndex] = 1;
                adjMatrix[vIndex][uIndex] = 1;
            }
        }
    }

    
    public void printAdjacencyMatrix() {
        if (numVertices == 0) {
            System.out.println("0 0");
            return;
        }

        System.out.println(numVertices + " " + numEdges); 

        
        System.out.print("\t");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(sortedVertices.get(i) + (i == numVertices - 1 ? "" : "\t"));
        }
        System.out.println(); 

        
        for (int i = 0; i < numVertices; i++) {
            System.out.print(sortedVertices.get(i));
            for (int j = 0; j < numVertices; j++) {
                System.out.print("\t" + adjMatrix[i][j]);
            }
            System.out.println();
        }
    }
    
    
    public void printDegrees() {
        if (numVertices == 0) return;

        System.out.println("Vertex\tDegree"); 

        for (int i = 0; i < numVertices; i++) {
            int degree = 0;
            
            for (int j = 0; j < numVertices; j++) {
                degree += adjMatrix[i][j];
            }
            
            System.out.println(sortedVertices.get(i) + "\t" + degree); 
        }
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        MockGraph graph = new MockGraph();
        graph.buildGraph(input);

        graph.printAdjacencyMatrix();

        graph.printDegrees();
    }
}