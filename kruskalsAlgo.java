package com.comp272;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
// List<WeightedEdge> alw = new ArrayList<>();
//Comparator<WeightedEdge> crp = Comparator.comparingDouble(WeightedEdge::getWeight);
//        Collections.sort(alw,crp);
//        System.out.println(alw);
//PriorityQueue<WeightedEdge> pq = new PriorityQueue<>(alw);
public class kruskalsAlgo{
    PriorityQueue<Integer> p;
    PriorityQueue<Integer> q;
    static List<WeightedEdge> ok;
    int size;
    ArrayList<Integer> og, on;

    Comparator<WeightedEdge> cr;

    public kruskalsAlgo(){
        p = new PriorityQueue<>();
        q = new PriorityQueue<>();
        ok = new ArrayList<>();
        og = new ArrayList<>();
        on = new ArrayList<>();
        size = 0;
        //cr = new Comparator();
    }

    public void readFileArt() {
        try {
            Scanner scanner = new Scanner(new File("/Users/jessicabajerek/MST/src/com/comp272/artist_edges.txt"));
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                String[] currentLineArray = currentLine.split("\t");
                og.add(Integer.parseInt(currentLineArray[0]));
                on.add(Integer.parseInt(currentLineArray[1]));
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Scanner scanner = new Scanner(new File("/Users/jessicabajerek/MST/src/com/comp272/Weights.txt"));
            while (scanner.hasNextLine()) {
                String cLine = scanner.nextLine();
                //String[] currentLineArray = currentLine.split(",");
                p.add(Integer.parseInt(cLine));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }




    public kruskalsAlgo(List<WeightedEdge> ok, int size){
        Collections.sort(ok);
        ArrayList<WeightedEdge> con = new ArrayList<>();
        if (ok == null) {
            return;
        }
        int sum = 0;


        UnionFind first = new UnionFind(size);

        for (WeightedEdge x : ok) {
            if (!first.cc(x.v1, x.v2)) {
                break;
            } else {
                first.union(x.v1, x.v2);
            }
            sum += x.weight;

            if (first.size(0) == size) {
                break;
            }
            //if(first.size(0) != null) {
            //    return null;
            // }
        }

    }


    public static void main(String[] args){
        List<WeightedEdge> alw = new ArrayList<>();


        //UnionFind test2 = new UnionFind();
        //test2.readFileArt();
        //alw.UnionFind(0);
        alw.add(new WeightedEdge(0,1,12));
        alw.add(new WeightedEdge(0,2,1));
        alw.add(new WeightedEdge(0,3,7));
        alw.add(new WeightedEdge(0,4,4));
        alw.add(new WeightedEdge(0,5,22));
       // UnionFind uf = new UnionFind(alw.getWeight());
        Comparator<WeightedEdge> crp = Comparator.comparingDouble(WeightedEdge::getWeight);
        Collections.sort(alw,crp);
        System.out.println(alw);

        crp= crp.reversed();
        Collections.sort(alw,crp);
        System.out.println(alw);
         new kruskalsAlgo(alw, alw.size());
       // kruskalsAlgo example = new kruskalsAlgo();
       // example.readFileArt();
        //PriorityQueue<WeightedEdge> pq = new PriorityQueue<Integer>(test);
        //System.out.println(pq.peek());

    }

    public static class UnionFind
    {
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

    public static class WeightedEdge implements Comparable<WeightedEdge> {
        int v1;  //frist vertex
        int v2; //second vertex
        double weight;  //cost to get from v1->v2

        //Initalize with v1,v2,w
        public WeightedEdge() {
            v1 = 0;
            v2 = 0;
            weight = 0;
        }

        //assignment for recall
        public WeightedEdge(int i, int j, double w) {
            v1 = i;
            v2 = j;
            weight = w;
        }

        public double getWeight() {
            return weight;
        }

        public int compareTo(WeightedEdge other) {
            return (Double.valueOf(weight).compareTo(Double.valueOf(other.weight)));
        }


        }
    }

