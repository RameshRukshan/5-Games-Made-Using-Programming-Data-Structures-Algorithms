/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author chiran
 */
import java.util.Arrays;
import java.util.*;

public class ShortestDisModel {
    private int[][] newmap;
    private int numCities;
    

    public ShortestDisModel(int[][] newmap) {
        this.newmap = newmap;
        this.numCities = newmap.length;
    }
    public void shortestPath(){
        
    }

    public List<Integer> findShortestPath(int startCity) {
        int[] distances = new int[numCities];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startCity] = 0;

        boolean[] visited = new boolean[numCities];
        int[] predecessor = new int[numCities]; // Store predecessor of each city

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startCity, 0));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int currentCity = currentNode.city;

            if (visited[currentCity]) {
                continue;
            }

            visited[currentCity] = true;

            for (int i = 0; i < numCities; i++) {
                if (newmap[currentCity][i] != 0 && !visited[i]) {
                    int newDistance = distances[currentCity] + newmap[currentCity][i];
                    if (newDistance < distances[i]) {
                        distances[i] = newDistance;
                        predecessor[i] = currentCity; // Update predecessor
                        queue.add(new Node(i, newDistance));
                    }
                }
            }
        }

        // Reconstruct shortest path
        List<Integer> shortestPath = new ArrayList<>();
        int currentCity = numCities - 1; // Start from the destination city
        while (currentCity != startCity) {
            shortestPath.add(0, currentCity);
            currentCity = predecessor[currentCity];
        }
        shortestPath.add(0, startCity); // Add the start city
        return shortestPath;
    }

    private static class Node implements Comparable<Node> {
        int city;
        int distance;

        Node(int city, int distance) {
            this.city = city;
            this.distance = distance;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
}
