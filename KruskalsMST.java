package com.comp272;
package com.Graph;
import java.util.*;
import java.io.*;
//import java.File.*;
//import WeightedEdge.java.*;
public class KruskalsMST {
    //ArrayList<Integer> check;
    //assignment for recall

    public  class UnionFind {
        ArrayList<Integer> check;
        ArrayList<Integer> size;
        int[] x, b;

        public UnionFind(int edge) {
            check = new ArrayList<>(edge);
            size = new ArrayList<>(edge);
            x = new int[edge];
            b = new int[edge];
            for (int i = 0; i < edge; i++) {
                x[i] = i;
                b[i] = 1;

            }
        }

        public int find(int searcher) {
            int tipPoint = searcher;
            while (tipPoint != x[tipPoint]) {
                tipPoint = x[tipPoint];
            }
            while (searcher != tipPoint) {
                int temp = x[searcher];
                x[searcher] = tipPoint;
                searcher = temp;
            }
            return tipPoint;
        }

        public boolean cc(int a, int b) {
            return find(a) == find(b);
        }

        public int size(int searcher) {
            return b[find(searcher)];
        }

        public void union(int ab, int cd) {
            int v1 = find(ab);
            int v2 = find(cd);
            if (v1 == v2) {
                return;
            }
            if (b[v1] < b[v2]) {
                b[v2] += b[v1];
            } else {
                b[v1] += b[v2];
                x[v2] = v1;
            }
        }
    }

    public static Long kurskalsUF(WeightedEdge[] we, int c) {
        if (we == null) {
            return null;
        }
        long sum = 0L;
        Arrays.sort(we);

        UnionFind first = new UnionFind(c);

        for (WeightedEdge x : we) {
            if (!first.cc(x.v1, x.v2)) {
                break;
            } else {
                first.union(x.v1, x.v2);
            }
            sum += x.weight;

            if (first.size(0) == c) {
                break;
            }
            //if(first.size(0) != null) {
            //    return null;
            // }
        }
        return sum;
    }

}

   /* public static void main(String[] args) {
        String file = "artist_edges.txt";
        String otherFile= "Weights.txt";
        KruskalsMST helpcheck = new KruskalsMST();
        helpcheck.readAndStore(file, otherFile);
        System.out.println(helpcheck);
        ArrayList<WeightedEdge> alw = new ArrayList<>();
        alw.add(new WeightedEdge(0, 1, 12));
        alw.add(new WeightedEdge(0, 2, 1));
        alw.add(new WeightedEdge(0, 3, 7));
        alw.add(new WeightedEdge(0, 4, 4));
        alw.add(new WeightedEdge(0, 5, 22));
        System.out.println(alw);


        Comparator<WeightedEdge> crp = Comparator.comparingDouble(WeightedEdge::getWeight);
        Collections.sort(alw,crp);
        //System.out.println(alw);

        crp= crp.reversed();
        Collections.sort(alw,crp);
        //System.out.println(alw);
        WeightedEdge go[] = new WeightedEdge[5];
        ArrayList<WeightedEdge> attemp[] = new ArrayList[5];
        alw.add(new WeightedEdge(0, 1, 12));
        alw.add(new WeightedEdge(0, 2, 1));
        alw.add(new WeightedEdge(0, 3, 7));
        alw.add(new WeightedEdge(0, 4, 4));
        alw.add(new WeightedEdge(0, 5, 22));
        //unionFindPrint(attemp, go);
        PriorityQueue<WeightedEdge> pq = new PriorityQueue<>(alw);
       // System.out.println(pq.peek());
    8*/