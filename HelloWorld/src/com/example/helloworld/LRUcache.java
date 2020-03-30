package com.example.helloworld;

import java.util.*;

public class LRUcache {

    static int n;
    static Deque<Integer> dq ;
    static HashSet<Integer> hm ;

    LRUcache(int n)
    {
        dq = new ArrayDeque<>();
        hm = new HashSet<>();
        this.n=n;
    }
    public void add(int val)
    {
        if(!hm.contains(val)) {

            if(dq.size()==n) {
                int value = dq.removeLast();
                hm.remove(value);
            }
        }
        else {
            dq.remove(val);
        }
        dq.push(val);
        hm.add(val);
    }

    public void traverse()
    {
        Iterator<Integer> it = dq.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());

        }
    }
    public static void main(String[] args) {
        LRUcache lrUcache = new LRUcache(5);
        lrUcache.add(1);
        lrUcache.add(2);
        lrUcache.add(3);
        lrUcache.add(4);
        lrUcache.add(5);
        System.out.println();
        lrUcache.traverse();
        lrUcache.add(9);
        System.out.println();
        lrUcache.traverse();
        lrUcache.add(5);
        System.out.println();
        lrUcache.add(45);
        lrUcache.add(9);
        lrUcache.traverse();
    }
}
