package com.github.excellent01;

/**
 * @auther plg
 * @date 2019/5/28 23:11
 */
public class Test {
    public static void main(String[] args) {
        Binnary_Tree binnary_tree = new Binnary_Search_Tree();
        binnary_tree.add(5);
        binnary_tree.add(1);
        binnary_tree.add(3);
        binnary_tree.add(7);
        binnary_tree.add(8);
        System.out.println(((Binnary_Search_Tree) binnary_tree).getSize());
        System.out.println(binnary_tree.contains(5));
        System.out.println(binnary_tree.contains(0));
        System.out.println(binnary_tree.contains(1));
        System.out.println(binnary_tree.contains(6));

    }
}
