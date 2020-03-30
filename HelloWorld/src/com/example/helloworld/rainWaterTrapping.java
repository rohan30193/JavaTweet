package com.example.helloworld;

public class rainWaterTrapping {
    static int totalWater(int arr[])
    {
        int lo=0;
        int hi=arr.length-1;
        int ri=0;
        int le=0;
        int total=0;
        while(lo<=hi)
        {
            if(arr[lo]<=arr[hi])
            {
                if(arr[lo]>le)
                {
                    le=arr[lo];
                }
                else
                    total+=le-arr[lo];
            lo++;
            }
            else
            {
                if(arr[hi]>ri)
                {
                    ri=arr[hi];
                }
                else
                    total+=ri-arr[hi];
                hi--;
            }


        }
        return total;
    }
    public static void main(String[] args) {

        int arr[] = {1,2,0,3,0,4,0,0,1,0};
        System.out.println(totalWater(arr));


    }
}
