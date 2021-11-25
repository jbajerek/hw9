package com.comp272;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class WeightedEdge implements Comparable<WeightedEdge> {
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
    public static void readAndStore(String fileName, String otherfileName) {

        PriorityQueue<WeightedEdge> xord = new PriorityQueue<>();

        try {
            Scanner sc = new Scanner(new File("/Users/jessicabajerek/MinSpanningTree/src/com/comp272/artist_edges.txt"));
            String s;
            Scanner bc = new Scanner(new File("/Users/jessicabajerek/MinSpanningTree/src/com/comp272/Weights.txt"));
            String x;


            // graph.add(new ArrayList<Integer>());

            while (sc.hasNextLine()) {
                s = sc.nextLine();

                String[] line = s.split("\t", 90);

                int v1 = Integer.parseInt(line[0]);
                int v2 = Integer.parseInt(line[1]);

                if (s.trim().isEmpty()) {
                    continue;
                }

                if (bc.hasNextLine()) {
                    x = bc.nextLine();
                    double weight = Double.parseDouble(x);

                    //int a = s;

                    //String line = s.split("\t");


                    //weight = x;
                    xord.add(new WeightedEdge(v1, v2, weight));
                }


            }
            sc.close();
            bc.close();

        } catch (FileNotFoundException e) {
            //xord.
        }
    }


    public static void main(String[] args) {
        String file = "artist_edges.txt";
        String otherFile= "Weights.txt";
        WeightedEdge helpcheck = new WeightedEdge();
         WeightedEdge.readAndStore(file, otherFile);
        //helpcheck.add(new WeightedEdge(0,1,12));
      //  System.out.println(helpcheck);
        List<WeightedEdge> alw = new ArrayList<>();
        alw.add(new WeightedEdge(0,1,12));
        System.out.println(alw);
        alw.add(new WeightedEdge(0,2,1));
        alw.add(new WeightedEdge(0,3,7));
        alw.add(new WeightedEdge(0,4,4));
        alw.add(new WeightedEdge(0,5,22));
        PriorityQueue<WeightedEdge> pq = new PriorityQueue<>(alw);
        System.out.println(pq.peek());



        Comparator<WeightedEdge> crp = Comparator.comparingDouble(WeightedEdge::getWeight);
        Collections.sort(alw,crp);
        //System.out.println(alw);

        crp= crp.reversed();
        Collections.sort(alw,crp);
        //System.out.println(alw);

    }

}


