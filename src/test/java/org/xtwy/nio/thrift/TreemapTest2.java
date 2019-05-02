package org.xtwy.nio.thrift;

import java.util.TreeSet;

/**
 * #author qinghao
 * #date 2019-04-27 12:48
 */
public class TreemapTest2 {
    public static void main(String[] args) {
        TreeSet treeMap = new TreeSet();

        treeMap.add(new User(1,"321"));
        treeMap.add(new User(2,"321"));

        System.out.println(treeMap);
    }


    static class User{
        String name;
        int id;

        public User(int id,String name) {
            this.name = name;
            this.id = id;
        }
    }
}
