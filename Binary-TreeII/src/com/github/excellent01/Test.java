package com.github.excellent01;

/**
 * @auther plg
 * @date 2019/5/28 23:11
 */
public class Test {
    public static void main(String[] args) {
        Binnary_Tree binnary_tree = new Binnary_Search_Tree();
        binnary_tree.add(50);
        binnary_tree.add(40);
        binnary_tree.add(60);
        binnary_tree.add(30);
        binnary_tree.add(45);
        binnary_tree.add(70);
        binnary_tree.add(55);
        binnary_tree.add(42);
        binnary_tree.leverOrder();
        System.out.println("=========================");
        ((Binnary_Search_Tree) binnary_tree).delete(50);
        binnary_tree.leverOrder();

    }
}
