/*package com.comp272;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


/*public class unified(int n){
    vert = new iny[n];
    f

}*/
/*ublic class Subset {
    int parent;
    int tipPoint;
/// test throughough

    private static int find(Subset edgeSubsets[], int i) {
        //compression
        if (edgeSubsets[i].parent != i) {
            edgeSubsets[i].parent = find(edgeSubsets, edgeSubsets[i].parent);
        }

        return edgeSubsets[i].parent;
    }

//union find

    private static void Union(Subset subsetters[], int e1, int e2) {
        int xTip = find(subsetters, e1);
        int yTip = find(subsetters, e2);

        //go through if
        if (subsetters[xTip].tipPoint < subsetters[yTip].tipPoint) {
            subsetters[xTip].parent = yTip;
        } else if (subsetters[xTip].tipPoint > subsetters[yTip].tipPoint) {
            subsetters[yTip].parent = xTip;
        } else {
            //consider being equal to go back through and increment
            subsetters[yTip].parent = xTip;
            subsetters[xTip].tipPoint++;
        }
    }

    public static void unionFindPrint(ArrayList<WeightedEdge> stuff[], WeightedEdge userE[]) {
        Arrays.sort(userE, WeightedEdge.comp);
        WeightedEdge minspanT[] = new WeightedEdge[stuff.length - 1];
        for (int i = 0; i < stuff.length - 1; i++) {
            minspanT[i] = new WeightedEdge(-1, -1, -1);

        }

        int ed = 0;

        Subset subsetted[] = new Subset[stuff.length];
        for (int i = 0; i < stuff.length; i++) {
            subsetted[i] = new Subset();
        }

        for (int i = 0; i < userE.length; i++) {
            subsetted[i].parent = i;
            subsetted[i].tipPoint = 0;

        }

        //cycle check
        for (int i = 0; i < userE.length; i++) {
            int vX = find(subsetted, i);
            int vY = find(subsetted, i);

            if (vX != vY) {
                minspanT[ed] = userE[vX];
                minspanT[ed] = userE[vY];
                minspanT[ed].weight = userE[i].getWeight();
                Union(subsetted, vX, vY);
                ed++;

            }
            if (ed == stuff.length - 1) {
                return;
            }

        }

        //public  toString(){
        //    return ("From: ("+vX+","+v+")"+weight);
        // }
        for (int i = 0; i < stuff.length - 1; i++) {
            System.out.println("from" + minspanT[ed].v1 + "to " + minspanT[ed].v2 + "weight of " + minspanT[ed].weight);
        }

    }
*/

//graph array list

//addEdge

//MST with priority queue
    //name pq then
    //add all edgew to pq
    //make parent
    //make edgeset
    //go through index -1 with while


//check for cycle creation X_set == or y_set
//no cycle add to final result
//union of the parents

/*
    public static void main(String[] args) {
        ArrayList<WeightedEdge> alw = new ArrayList<>();
        WeightedEdge go[] = new WeightedEdge[5];
        ArrayList<WeightedEdge> attemp[] = new ArrayList[5];
        alw.add(new WeightedEdge(0, 1, 12));
        alw.add(new WeightedEdge(0, 2, 1));
        alw.add(new WeightedEdge(0, 3, 7));
        alw.add(new WeightedEdge(0, 4, 4));
        alw.add(new WeightedEdge(0, 5, 22));
        unionFindPrint(attemp, go);
        PriorityQueue<WeightedEdge> pq = new PriorityQueue<>(alw);
        System.out.println(pq.peek());
   /* Comparator<WeightedEdge> crp = Comparator.comparingDouble(WeightedEdge::getWeight);
    Collections.sort(alw,crp);
    System.out.println(alw);
    crp= crp.reversed();
    Collections.sort(alw,crp);
    System.out.println(alw);*/
    //}
//}//
