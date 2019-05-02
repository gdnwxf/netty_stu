package org.xtwy.nio.thrift;

import java.util.TreeMap;

/**
 * #author qinghao
 * #date 2019-04-27 12:48
 */
public class TreemapTest {

    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();

        treeMap.put(1,"321321");
        treeMap.put(2,"321321");
        treeMap.put(3,"321321");
        treeMap.put(4,"321321");
        treeMap.put(5,"321321");
        treeMap.put(6,"321321");
        treeMap.put(7,"321321");
        treeMap.put(8,"321321");
        treeMap.put(9,"321321");
        treeMap.put(10,"321321");
        treeMap.put(11,"321321");
        treeMap.put(12,"321321");
        treeMap.put(13,"321321");
        treeMap.put(14,"321321");
        treeMap.put(15,"321321");


        System.out.println(treeMap);

        treeMap.remove(8) ;

        System.out.println(treeMap);

    }
}
