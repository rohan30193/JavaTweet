package com.example.helloworld;

import com.company.MainTest;

import java.util.*;
import java.io.*;
import java.lang.*;


public class HelloWorld  {

    public static void main(String[] args) {


        MyMap myMap=new MyMap();
        TreeMap<String,Integer> treeMap=myMap.tm;
        treeMap.put("rohan",1);
        treeMap.put("rohit",3);
        treeMap.put("abhishek",34);
        treeMap.put("prashant",4576);
        for(Map.Entry<String,Integer> entry:treeMap.entrySet())
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();
        String s="collection";
        for(int i=0;i<s.length();i++)
        {
            if(!linkedHashMap.containsKey(s.charAt(i)))
            {
                linkedHashMap.put(s.charAt(i),1);
            }
            else
            {
                linkedHashMap.put(s.charAt(i),linkedHashMap.get(s.charAt(i))+1);
            }

        }
        for(Map.Entry<Character,Integer> entry:linkedHashMap.entrySet())
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

}
