package com.example.helloworld;

public class Nqueen {

    static int N=8;
    public void print(int sol[][])
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                System.out.print(sol[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    boolean IsSafe(int row, int col, int[][] sol)
    {
        for(int j=0;j<N;j++)
        {
            if(sol[row][j]==1)
                return false;
        }
        for(int i=row,j=col;i>=0&&j>=0;i--,j--)
        {
            if(sol[i][j]==1)
                return false;
        }
        for(int i=row,j=col;i<N&&j>=0;i++,j--)
        {
            if(sol[i][j]==1)
                return false;
        }
        return true;
    }
    boolean NqueenSolUtil(int col,int sol[][])
    {
        if(col>=N)
            return true;

        for(int i=0;i<N;i++)
        {
            if(IsSafe(i,col,sol))
            {
                sol[i][col]=1;
                if(NqueenSolUtil(col+1,sol))
                    return true;
                else
                    sol[i][col]=0;
            }
        }
        return false;

    }
    public void NqueenSol()
    {
        int [][]sol =new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                sol[i][j]=0;
            }
        }
        int col=0;

        if(!NqueenSolUtil(col,sol))
        {
            System.out.println("no solution exist");
        }
        else
            print(sol);
        return;
    }
    public static void main(String[] args) {
        Nqueen nqueen = new Nqueen();
        nqueen.NqueenSol();
    }
}
