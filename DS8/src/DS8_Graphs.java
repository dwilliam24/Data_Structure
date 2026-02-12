import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DS8_Graphs {

    public static ArrayList<String> bridges(String[] edges, String vertices) {
        ArrayList<String> bridge = new ArrayList<>();
        char start = vertices.charAt(0);

            for (int edgesLoop = 0; edgesLoop <edges.length; edgesLoop++){
                ArrayList<String> newEdges = new ArrayList<>();
                for (int f = 0; f <edges.length; f++){
                    if (!edges[f].equals(edges[edgesLoop])) {
                        newEdges.add(edges[f]);
                    }
                }
                String[] h = new String[newEdges.size()];
                for (int a =0; a<newEdges.size(); a++){
                    h[a]= newEdges.get(a);
                }

                for (int a = 0; a<vertices.length(); a++){
                    char end =' ';
                    if (vertices.charAt(a)!=start) {
                        end = vertices.charAt(a);
                        if (!breadthFirstSearch_Unweighted(h, vertices, start, end) && !bridge.contains(edges[edgesLoop])) {
                            bridge.add(edges[edgesLoop]);
                        }
                    }
            }
        }
            System.out.println(bridge);
            if (bridge.isEmpty()) return null;
            else return bridge;
    }

    public static String[] stronglyConnectedRegions(String[] edges, String vertices) {

        boolean[][] reach = new boolean[vertices.length()][vertices.length()];

        for (String edge : edges) {
            int y = vertices.indexOf(edge.charAt(0));
            int x = vertices.indexOf(edge.charAt(1));

            reach[y][x] = true;
        }

        for (int k = 0; k < vertices.length(); k++) {
            for (int i = 0; i < vertices.length(); i++) {
                for (int j = 0; j < vertices.length(); j++) {
                    if (reach[i][k] && reach[k][j]) {
                        reach[i][j] = true;
                    }
                }
            }
        }

        ArrayList<String> regionsList = new ArrayList<>();
        boolean[] visited = new boolean[vertices.length()];

        for (int i = 0; i < vertices.length(); i++) {
            if (!visited[i]) {
                ArrayList<Integer> componentIndices = new ArrayList<>();
                componentIndices.add(i);
                visited[i] = true;

                for (int j = i + 1; j < vertices.length(); j++) {
                    if (!visited[j]) {
                        if (reach[i][j] && reach[j][i]) {
                            componentIndices.add(j);
                            visited[j] = true;
                        }
                    }
                }

                if (componentIndices.size() > 1) {
                    Collections.sort(componentIndices);

                    String g = "";
                    for (int idx : componentIndices) {
                        g += vertices.charAt(idx);
                    }
                    regionsList.add(g);
                }
            }
        }

        if (regionsList.isEmpty()) {
            return null;
        }

        return regionsList.toArray(new String[0]);
    }

    public static Boolean breadthFirstSearch_Unweighted(String[] edges, String vertices, char start, char end) {
        int[] indexes = new int[26];
        Arrays.fill(indexes, -1);
        for (int i = 0; i < vertices.length(); i++) {
            indexes[vertices.charAt(i) - 'A'] = i;
        }

        ArrayList<Character>[] graph = new ArrayList[vertices.length()];
        for (int i = 0; i < vertices.length(); i++) {
            graph[i] = new ArrayList<>();
        }
        for (String edge : edges) {
            char a = edge.charAt(0);
            char b = edge.charAt(1);
            int g = indexes[a - 'A'];
            int h = indexes[b - 'A'];
            graph[g].add(b);
            graph[h].add(a);
        }

        DS8_Queue<Character> queue = new DS8_Queue<>();
        boolean[] visited = new boolean[vertices.length()];
        char[] parent = new char[vertices.length()];
        Arrays.fill(parent, '0');

        queue.offer(start);
        visited[indexes[start - 'A']] = true;

        while (!queue.isEmpty()) {
            char temp = queue.poll();
            int index = indexes[temp - 'A'];

            if (temp == end) {
                return true;
            }

            ArrayList<Character> l = graph[index];
            for (char neighbor : l) {
                int h = indexes[neighbor - 'A'];
                if (!visited[h]) {
                    visited[h] = true;
                    queue.offer(neighbor);
                    parent[h] = temp;
                }
            }
        }

        return false;
    }
}
