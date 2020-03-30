package com.example.helloworld;

public class NighttourProblem {
    static int N=8;
    static int a=1;
    static public void printSolution(int sol[][])
    {

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }
    static boolean isSafe(int x,int y, int sol[][])
    {
        return (x>=0 && x<N && y>=0 && y<N && sol[x][y]==-1);
    }
    static boolean solveKTUtil(int x,int y,int index, int sol[][],int Xarr[], int Yarr[])
    {


        if(index == N*N)
            return true;
        int nX;
        int nY;
        for(int i=0;i<N;i++)
        {
            nX=x+Xarr[i];
            nY=y+Yarr[i];

            if(isSafe(nX,nY,sol))
            {
                sol[nX][nY]=index;
                if(solveKTUtil(nX,nY,index+1,sol,Xarr,Yarr))
                return true;
                else
                    sol[nX][nY]=-1;
            }


        }
        return  false;

    }
    static int  solveKT()
    {
        int [][]sol = new int[N][N];
        int [] Xarr = new int[] {2,1,-1,-2,-2,-1,1,2};
        int [] Yarr = new int[] {1,2,2,1,-1,-2,-2,-1};


        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                sol[i][j]=-1;
            }
        }
        sol[0][0]=0;
        if(solveKTUtil(0,0,1,sol,Xarr,Yarr)== false)
        {
            System.out.println("No solution exist");
            return 0;
        }
        else
            printSolution(sol);
        return 1;
    }
    public static void main(String[] args) {
        NighttourProblem nighttourProblem = new NighttourProblem();
        nighttourProblem.solveKT();
    }
}
