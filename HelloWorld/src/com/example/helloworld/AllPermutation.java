package com.example.helloworld;

import java.util.Scanner;

public class AllPermutation {
    public static String swap(String s, int i,int j)
    {
        char temp;
        char [] arr = s.toCharArray();
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);
    }
    public static void premutationFun(String inputString,int l,int r)
    {
        if(l==r)
        {
            System.out.println(inputString);
        }
        else
        {
            for(int i=l;i<=r;i++)
            {
                inputString = swap(inputString,i,l);
                premutationFun(inputString,l+1,r);
                inputString = swap(inputString,i,l);
            }
        }

    }
    public static void main(String args[])
    {
        Scanner myObj = new Scanner(System.in);
        String inputString = myObj.nextLine();


        System.out.println(inputString);
        int l=0;
        int r=inputString.length();

        premutationFun(inputString,l,r-1);
    }
}
