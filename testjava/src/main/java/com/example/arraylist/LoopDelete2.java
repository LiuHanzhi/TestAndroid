package com.example.arraylist;

import java.util.ArrayList;

/**
 * Created by liuhanzhi on 16/3/2.
 */
public class LoopDelete2 {

    public static void main(String... args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("two");
        list.add("two");
        list.add("two");
        for(String s:list){
            if(s.equals("two")){
                list.remove(s);
            }
        }
        System.out.println(list);
    }
}
