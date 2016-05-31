package com.example.arraylist;

import java.util.ArrayList;

/**
 * Created by liuhanzhi on 16/3/2.
 */
public class LoopDelete1 {

    public static void main(String... args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("two");
        list.add("two");
        list.add("two");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("two")) {
                list.remove(i);
            }
        }
        System.out.println(list);
    }
}
