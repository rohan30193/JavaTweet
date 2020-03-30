package com.example.helloworld;

import java.util.LinkedList;
import java.util.Stack;

public class StackMin {
    int min;

    Stack<Integer> list;
    StackMin()
    {
        list = new Stack<>();
    }

    void push(Integer a)
    {
        if(list.isEmpty())
        {
            list.add(a);
            min=a;
            return ;
        }
        else
        {
            if(min<a)
            {
                list.add(a);
            }
            else
            {

                list.add(2*a-min);
                min = a;
            }
        }
    }

    int pop()
    {
        if(list.isEmpty())
        {
            System.out.println("Stack is empty bro!!");
        }

            Integer integer = list.pop();

            if(integer<min)
            {
                int temp = min;
                min = 2*min - integer;
                return temp;
            }
            else
                return integer;

    }

    public static void main(String[] args) {
        StackMin stackMin = new StackMin();
        stackMin.push(10);
        stackMin.push(1);
        System.out.println(stackMin.min);
        stackMin.push(4);
        stackMin.push(3);
        System.out.println(stackMin.min);
        System.out.println(stackMin.pop());
        System.out.println(stackMin.min);
        System.out.println(stackMin.pop());
        System.out.println(stackMin.min);
        System.out.println(stackMin.pop());
        System.out.println(stackMin.min);
        System.out.println(stackMin.pop());
    }

}
