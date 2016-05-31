package com.example.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by liuhanzhi on 16/3/2.
 */
public class LoopDelete3 {

    public static void main(String... args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("two");
        list.add("two");
        list.add("two");
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            String s = iter.next();
            if(s.equals("two")){
                list.remove(s);
            }
        }
        System.out.println(list);
    }
}
