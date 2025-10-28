import java.util.*;

public class GraphLab {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().replaceAll("\\s+", "");
        String[] edges = input.split(",");

        Set<Integer> verticesSet = new TreeSet<>();
        for (String edge : edges) {
            String[] parts = edge.split("-");
            verticesSet.add(Integer.parseInt(parts[0]));
            verticesSet.add(Integer.parseInt(parts[1]));
        }

        List<Integer> vertices = new ArrayList<>(verticesSet);
        int n = vertices.size();
        int[][] matrix = new int[n][n];

        for (String edge : edges) {
            String[] parts = edge.split("-");
            int v1 = vertices.indexOf(Integer.parseInt(parts[0]));
            int v2 = vertices.indexOf(Integer.parseInt(parts[1]));
            matrix[v1][v2] = 1;
            matrix[v2][v1] = 1;
        }

        System.out.println(n + " " + edges.length);
        System.out.print("\t");
        for (int v : vertices) System.out.print(v + "\t");
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(vertices.get(i) + "\t");
            for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }

        System.out.println("Vertex\tDegree");
        for (int i = 0; i < n; i++) {
            int degree = 0;
            for (int j = 0; j < n; j++) degree += matrix[i][j];
            System.out.println(vertices.get(i) + "\t" + degree);
        }
    }
}
