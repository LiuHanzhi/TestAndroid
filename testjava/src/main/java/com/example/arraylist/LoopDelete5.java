package com.example.arraylist;

import java.util.ArrayList;

/**
 * Created by liuhanzhi on 16/3/2.
 */
public class LoopDelete5 {

    public static void main(String... args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("two");
        list.add("three");
        list.add("two");
        for (int i = list.size() -1; i >=0; i--) {
            if (list.get(i).equals("two")) {
                list.remove(i);
            }
        }
        System.out.println(list);
    }
}
