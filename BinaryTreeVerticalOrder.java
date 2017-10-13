package com.example.tests;

import java.util.*;

/**
 * Created by TanmayPC on 10/13/2017.
 */
public class BinaryTreeVerticalOrder {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) {
            val = v;
        }
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        BinaryTreeVerticalOrder btree = new BinaryTreeVerticalOrder();
        List<List<Integer>> res;
        res = btree.verticalOrder(btree.buildTree(null, 1));

        //display
        for(List<Integer> i : res) {
            StringBuilder sb = new StringBuilder();
            for(int j : i)
                sb.append(j + ",");

            System.out.println(sb.toString().substring(0, sb.length() - 1));
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        //treemap is used to get keys in correct order-lowest column to highest
        TreeMap<Integer,List<Integer>> hm = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        verticalOrderHelper(root, hm); //dfs wont work--we need traversal in order of vertical line--dfs will eval children first

        for(int k : hm.keySet())
            res.add(new ArrayList<>(hm.get(k)));

        return res;
    }

    public void verticalOrderHelper(TreeNode root, TreeMap<Integer,List<Integer>> hm) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        q.offer(root);
        cols.offer(0);
        //level order traversal-- put root and its desired column value(col + 1, col - 1) in 2 queues
        //when we poll element temp, it has its related col,value, see if hashmap has col as key, if yes append temp.val
        //if not add col and temp.val to map
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            int col = cols.poll();

            List<Integer> t = new ArrayList<>();
            if (hm.containsKey(col))
                t = hm.get(col);
            t.add(temp.val);
            hm.put(col, t);

            if (temp.left != null) {
                q.offer(temp.left);
                cols.offer(col - 1);
            }
            if (temp.right != null) {
                q.offer(temp.right);
                cols.offer(col + 1);
            }
        }
    }

    public TreeNode buildTree(TreeNode root, int v) {
        /*root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Ans:    4
                2
                1,5,6
                3
                7
        */

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);
        root.right.right.left.right.right = new TreeNode(12);

        /*
            ans:    4
                    2
                    1,5,6
                    3,8,10
                    7,11
                    9,12

        */

        return root;
    }
}
