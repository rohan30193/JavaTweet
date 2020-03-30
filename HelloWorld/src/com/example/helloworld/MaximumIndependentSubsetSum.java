package com.example.helloworld;

public class MaximumIndependentSubsetSum {

    static TreeNode root;
    public static class TreeNode {
        int val;
        TreeNode left=null;
        TreeNode right=null;
        int maxVal=0;
        TreeNode(int val)
        {
            this.val=val;
        }
    }
    public static int maxSum(TreeNode root)
    {
        if(root==null)
            return 0;
        if(root.maxVal!=0)
            return root.maxVal;
        if(root.left==null && root.right==null)
        {
            root.maxVal=root.val;
            return root.maxVal;
        }
        int inc=0;
        inc+=root.val;
        if(root.left!=null)
            inc+=maxSum(root.left.left)+maxSum(root.left.right);
        if(root.right!=null)
            inc+=maxSum(root.right.left)+maxSum(root.right.right);
        int exc=0;
        exc+=maxSum(root.left)+maxSum(root.right);
        System.out.println(inc+" "+exc);
        root.maxVal=Math.max(inc,exc);
        return root.maxVal;
    }
    public static void main(String[] args) {
        MaximumIndependentSubsetSum maximumIndependentSubsetSum = new MaximumIndependentSubsetSum();
        maximumIndependentSubsetSum.root = new TreeNode(10);
        maximumIndependentSubsetSum.root.left = new TreeNode(20);
        maximumIndependentSubsetSum.root.right = new TreeNode(30);
        maximumIndependentSubsetSum.root.left.left = new TreeNode(41);
        System.out.println(MaximumIndependentSubsetSum.maxSum(root));
    }
}
