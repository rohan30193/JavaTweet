package com.example.helloworld;

public class MedianofArrays {

    static int median(int arr1[],int start,int end)
    {
        int n = end-start+1;

        if(n % 2==0)
            return (arr1[(start+end+1)/2]+arr1[(start+end-1)/2])/2;
        else
            return arr1[(start+end+1)/2];
    }
     static int getMedian(int arr1[],int arr2[],int start1,int start2,int end1,int end2)
    {
        if(arr1.length==0)
            return 0;
        if (end1 - start1 == 1) {
            return (
                    Math.max(arr1[start1],
                            arr2[start2])
                            + Math.min(arr1[end1], arr2[end2]))
                    / 2;
        }
        int m1=median(arr1,start1,end1);
        int m2=median(arr2,start2,end2);

        if(m1==m2)
            return m1;
        else if(m1<m2)
        {
            return getMedian(arr1,arr2,(start1+end1+1)/2,start2,end1,(start2+end2+1)/2);
        }
        else return getMedian(arr1,arr2,start1,(start2+end2+1)/2,(start1+end1+1)/2,end2);


    }

    public static void main(String[] args) {

        int arr1[] = {1,2,3,5,6};
        int arr2[] = {6,6,7,8,9};
        System.out.println(getMedian(arr1,arr2,0,0,arr1.length-1,arr2.length-1));

    }


}
