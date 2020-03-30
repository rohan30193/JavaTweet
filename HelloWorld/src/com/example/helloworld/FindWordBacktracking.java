package com.example.helloworld;

import java.util.Scanner;

public class FindWordBacktracking {

    static int N = 8;
    static char[] res = new char[]{'0','0','0','0','0','0','0','0','0'};

    Boolean IsSafe(int row, int col, int [][] flag,char [][] box,int index,String name)
    {
        //System.out.println("row col"+ row+" "+col);
        //System.out.println(box[row][col]+" "+name.charAt(index));
        return (row>=0 && row<N && col >=0 && col<N && flag[row][col]==0 && box[row][col]==name.charAt(index));
    }

    Boolean IsNameUtil(int row,int col,int [][]flag,char [][]box,String name,int []xArr,int []yArr,int index)
    {

        if(index>=name.length())
            return true;

        int xnew;
        int ynew;
        for(int i=0;i<N;i++)
        {
            //System.out.println(row +" "+col+" "+xArr[i]+" "+yArr[i]+" ");
            xnew = row + xArr[i];
            ynew = col + yArr[i];

            if(IsSafe(xnew,ynew,flag,box,index,name))
            {
                System.out.println(box[xnew][ynew]+" "+xnew+" "+ynew+" ");
                res[index]=box[xnew][ynew];
                flag[xnew][ynew]=1;

                if(IsNameUtil(xnew,ynew,flag,box,name,xArr,yArr,index+1))
                    return true;
                else {
                    res[index] = '0';
                    flag[xnew][ynew]=0;
                }
            }
        }
        return false;


    }
    public boolean IsName(char [][] box,String name)
    {
        int [][] flag = new int [N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                flag[i][j]=0;
            }
        }

        int []xArr = new int[]{1,1,1,0,0,-1,-1,-1};
        int []yArr = new int[]{1,0,-1,1,-1,0,-1,1};


        int index=1;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(i<N && j<N && name.charAt(0)==box[i][j]) {
                    System.out.println(box[i][j]+" "+i+" "+j+" ");
                    res[0]=box[i][j];
                    flag[i][j] = 1;
                    if (IsNameUtil(i, j, flag, box, name, xArr, yArr, index)) {
                        System.out.println("pattern found");
                        return true;
                    }
                }
                else
                {
                    res[0]='0';
                    flag[i][j] = 0;
                }

            }

        }
        return true;



    }
    public static void main(String[] args) {
        FindWordBacktracking findWordBacktracking = new FindWordBacktracking();
        char [][] box = new char[][]{{'r','o','h','m','s','s','s','s'},
                                     {'c','o','j','a','l','s','g','s'},
                                     {'a','k','a','l','b','a','l','n'},
                                     {'a','o','a','a','j','s','i','s'},
                                     {'g','o','m','k','n','s','s','r'},
                                     {'r','a','h','m','l','s','t','s'},
                                     {'r','o','h','u','s','s','s','s'},
                                     {'r','o','h','m','s','s','s','s'}};

        Scanner myObj = new Scanner(System.in);
        String inputString = myObj.nextLine();
        System.out.println(findWordBacktracking.IsName(box,inputString));
        for(int i=0;i<res.length;i++)
            System.out.print(res[i]);

    }
}
