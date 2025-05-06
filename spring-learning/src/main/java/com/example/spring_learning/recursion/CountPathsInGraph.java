package com.example.spring_learning.recursion;

import java.util.Iterator;
import java.util.LinkedList;

public class CountPathsInGraph {

    public static void main(String args[])
    {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 4);

        int s = 0, d = 4;
        int pathCount = 0;
        // Function call
        System.out.println(g.countPaths(s, d, pathCount));
    }
    static class Graph {
        private LinkedList<Integer>[] adj;
        public Graph(int v) {
            adj = new LinkedList[v];
            for(int i=0; i<v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int v, int w) {
            adj[v].add(w);
        }

        public int countPaths(int s, int d, int pathCount) {
            if(s==d) pathCount++;
            else {
                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    pathCount = countPaths(n, d, pathCount);
                }
            }
            return pathCount;
        }
    }
}
