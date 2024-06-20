import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.PriorityQueue;

public class Main {

    static Map<Integer, Integer> distances;
    public static void main(String[] args) throws Exception, IOException {
        
        int V, E, K;
        int u, v, w;
        int maxWeight = 0;
        Graph graph = new Graph();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        for(int i = 1; i <= V; i++) {
            graph.addEdge(i, i, 0);
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph.addEdge(u, v, w);
            maxWeight += w;
        }

        Dijkstra(graph, K);
        Map<Integer, Integer> sortedDistance = new TreeMap<>(distances);

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, Integer> entry : sortedDistance.entrySet()) {
            int dist = entry.getValue();
            if(dist > maxWeight) {
                sb.append("INF\n");
            } else {
                sb.append(dist).append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    static void Dijkstra(Graph graph, int startNode) {

        distances = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int vertex: graph.getVertices()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }

        distances.put(startNode, 0);

        pq.add(new Node(startNode, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            if(visited.contains(current.id)) continue;
            visited.add(current.id);

            for(Edge edge: graph.getEdges(current.id)) {
                if(!visited.contains(edge.destination)) {
                    int dist = distances.get(current.id) + edge.weight;
                    if(dist < distances.get(edge.destination)) {
                        distances.put(edge.destination, dist);
                        pq.add(new Node(edge.destination, dist));
                    }
                }
            }
        }
    }
}

class Graph {
    Map<Integer, List<Edge>> vertices;

    public Graph() {
        vertices = new HashMap<>();
    }

    public void addEdge(int source, int destination, int weight) {
        vertices.computeIfAbsent(source, k -> new ArrayList<>()).add(new Edge(destination, weight));
    }

    public List<Edge> getEdges(int vertex) {
        return vertices.get(vertex);
    }

    public Set<Integer> getVertices() {
        return vertices.keySet();
    }
}

class Edge {
    int destination;
    int weight;

    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

class Node implements Comparable<Node>{
    int id;
    int distance;

    public Node(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node n) {
        return this.distance - n.distance;
    }
}