package com.example.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by liuhanzhi on 16/3/2.
 */
public class LoopDelete4 {

    public static void main(String... args) {
        MyArrayList<String> list = new MyArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("two");
        list.add("two");
        list.add("two");
        list.log("init");

        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            String s = iter.next();
            if(s.equals("two")){
                iter.remove();
            }
        }
        System.out.println(list);
    }
}
