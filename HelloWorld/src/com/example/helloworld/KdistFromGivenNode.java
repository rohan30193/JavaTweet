package com.example.helloworld;

public class KdistFromGivenNode {

    Node root;
    public void printnodedown(Node root , int k)
    {
        if(root==null)
            return ;
        if(k==0) {
            System.out.println(root.data);
            return ;
        }
        printnodedown(root.left,k-1);
        printnodedown(root.right,k-1);
    }
    public int printnodeKdist(Node root, Node node, int k)
    {
        if(root==null)
            return -1;
        if(root==node)
        {
            printnodedown(root,k);
            return 0;
        }
        int dl=printnodeKdist(root.left,node,k);
        if(dl!= -1)
        {
            if(dl+1 == k)
            {
                System.out.println(root.data);
            }
            else
                printnodedown(root.right,k-dl-2);
            return dl+1;
        }
        int dr=printnodeKdist(root.left,node,k);
        if(dr!= -1)
        {
            if(dr+1 == k)
            {
                System.out.println(root.data);
            }
            else
                printnodedown(root.left,k-dr-2);
            return dr+1;
        }
        return -1;

    }
    public static void main(String[] args) {
        KdistFromGivenNode kdist = new KdistFromGivenNode();
        kdist.root = new Node(1);
        kdist.root.left= new Node(2);
        kdist.root.right= new Node(3);
        kdist.root.left.left= new Node(4);
        kdist.root.left.right= new Node(5);
        kdist.root.right.left= new Node(6);
        kdist.root.right.right= new Node(7);
        kdist.printnodeKdist(kdist.root,kdist.root,2);
    }
}
