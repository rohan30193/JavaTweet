package com.example.helloworld;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphAdjList {



    LinkedList<Integer> list = new LinkedList<>();

    public static class Cell{
        int dist;
        int x;
        int y;
        Cell(int x,int y, int dist)
        {
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }

    public static class Graph{

        LinkedList<Integer> linkedList [];
        int size;

        Graph(int size)
        {
            this.size = size;
            linkedList = new LinkedList[size];

            for(int i=0;i<size;i++)
            {
                LinkedList<Integer> subList = new LinkedList<Integer>();
                linkedList[i] = subList;
            }
        }

        void addEdge(int start, int end)
        {
            linkedList[start].add(end);
        }

        void printGraph(Graph graph)
        {

            for(int i=0;i<graph.size;i++)
            {
                System.out.println(i);
                for(Integer integer:linkedList[i])
                {
                    System.out.print("->"+integer);
                }
                System.out.println();
            }
        }

        void bfs(Graph graph,int start)
        {
            LinkedList<Integer> queue = new LinkedList<Integer>();
            boolean visited[] = new boolean[graph.size];
            visited[start]=true;
            queue.add(start);

            while(!queue.isEmpty())
            {
                Integer vertex = queue.poll();
                System.out.print(vertex+"->");
                Iterator<Integer> it = linkedList[vertex].iterator();
                while (it.hasNext())
                {
                    Integer n = it.next();
                    if(visited[n]==false) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
            System.out.println();
        }
        void dfsUtil(boolean bool[],Graph graph, int index)
        {
            bool[index]=true;
            System.out.print(index+"->");

            Iterator<Integer> it = graph.linkedList[index].iterator();
            while(it.hasNext())
            {
                Integer n= it.next();
                if(bool[n]==false)
                {
                    dfsUtil(bool,graph,n);
                }
            }
        }
        void dfs(Graph graph, int index)
        {
            boolean bool[] = new boolean[graph.size];
            for(int i=0;i<graph.size;i++)
            {
                bool[i]=false;
            }

            dfsUtil(bool,graph,index);
            System.out.println();
        }

        int countIsland(Graph graph)
        {
            int result =0;
            boolean bool[] = new boolean[graph.size];
            for(int i=0;i<graph.size;i++)
            {
                bool[i]=false;
            }

            for(int i=0;i<graph.size;i++)
            {
                if(bool[i]==false)
                {
                    result++;
                    dfsUtil(bool,graph,i);
                }
            }

            return result;
        }
        int getMinimumDist(int starti,int startj,int endi,int endj,int N) {

            int X[] = new int[]{2, 2, -2, -2, 1, 1, -1, -1};
            int Y[] = new int[]{1, -1, 1, -1, 2, -2, 2, -2};

            LinkedList<Cell> list = new LinkedList<Cell>();
            boolean visited[][] = new boolean[N + 1][N + 1];
            for (int i = 0; i < N + 1; i++) {
                for (int j = 0; j < N + 1; j++) {
                    visited[i][j] = false;
                }
            }
            Cell cell = new Cell(starti, startj, 0);
            list.add(cell);
            visited[starti][startj] = true;

            while (!list.isEmpty()) {
                Cell cell1 = list.poll();
                System.out.println(" "+cell1.x+" "+cell1.y+" "+cell1.dist);
                if (cell1.x == endi && cell1.y == endj) {
                    return cell1.dist;
                }
                int dist = cell1.dist;
                for (int i = 0; i < 8; i++) {
                    starti += X[i];
                    startj += Y[i];

                    if (isSafe(starti, startj, N) && !visited[starti][startj]) {
                        cell1 = new Cell(starti, startj, dist + 1);
                        list.add(cell1);
                        visited[starti][startj] = true;
                    }

                }

            }
            return 0;
        }

        boolean isSafe(int starti,int startj,int N)
        {
            return(starti>0&&starti<=N && startj>0&& startj<=N);
        }





    }


    public static void main(String[] args) {
        int size =5;
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);

        graph.addEdge(1,4);
        graph.addEdge(2,1);
        //graph.addEdge(1,3);
        //graph.addEdge(3,0);


        //graph.printGraph(graph);
        //graph.bfs(graph,1);
        //graph.dfs(graph,1);
        //System.out.println(graph.countIsland(graph));

        System.out.println(graph.getMinimumDist( 0, 0, 3,3,30));



    }
}
