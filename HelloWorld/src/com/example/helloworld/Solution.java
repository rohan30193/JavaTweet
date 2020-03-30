package com.example.helloworld;

import java.util.*;

public class Solution {

    public static class node {
        String term;
        int value;

        public void add(String term, int value)
        {
            this.term=term;
            this.value=value;
        }
    }
    static class mycomp implements Comparator<node>
    {

        public int compare(node a, node b)
        {
            if(a.value==b.value)
            {
                a.term.compareTo(b.term);
            }
            if(a.value>b.value)
                return 0;
            else return 1;
        }
    }

    static public ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests)
    {
        HashMap<String ,Integer> hm = new HashMap<String, Integer>();
        for(int i=0;i<possibleFeatures.size();i++)
        {
            hm.put(possibleFeatures.get(i),0);
        }

        for(int i=0;i<featureRequests.size();i++)
        {
            String[] s=featureRequests.get(i).split("\\s+");

            for(int j=0;j<s.length;j++)
            {
                if(hm.containsKey(s[j]))
                {
                    int value=hm.get(s[j])+1;
                    hm.put(s[j],value);
                }
            }
        }
        List<node> list= new LinkedList<>();

        for(Map.Entry<String, Integer> entry:hm.entrySet())
        {
            node node = new node();
            node.add(entry.getKey(),entry.getValue());
            list.add(node);
        }

        Collections.sort(list,new mycomp());

        ArrayList<String> result = new ArrayList<>();

        for(int i=0;i<topFeatures && i<list.size();i++)
        {
            node n = new node();
            n=list.get(i);
            String s=n.term;
            result.add(s);
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> possiblefeatures = new LinkedList<>();
        possiblefeatures.add("storage");
        possiblefeatures.add("alexa");
        List<String> featurereq = new LinkedList<>();
        featurereq.add("i wish my storage storage");
        featurereq.add("i wish my alexa");
        System.out.println(popularNFeatures(6,2,possiblefeatures,7,featurereq));
    }
}
