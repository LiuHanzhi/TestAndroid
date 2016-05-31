package com.example.arraylist;

import java.util.ArrayList;

/**
 * Created by liuhanzhi on 16/3/21.
 */
public class ArrayList2StringArray {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        String[] strings = list.toArray(new String[list.size()]);
        for (String s :
                strings) {
            System.out.println(s);
        }
    }
}
