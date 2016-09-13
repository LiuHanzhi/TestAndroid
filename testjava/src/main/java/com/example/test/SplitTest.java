package com.example.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by liuhanzhi on 16/8/24.
 */
public class SplitTest {

    public static void main(String[] args) {
        String s = "[106531,106530]";
        List<String> list = Arrays.asList(s.replace("[", "").replace("]", "").split(","));

        HashSet<String> set = new HashSet<>();
        set.addAll(list);
        String tttt = "106530";
        for (String l : list) {
            System.out.println("l:"+l);
        }

        System.out.println("list is contain: "+list.contains(tttt));
        System.out.println("set is contain: "+set.contains(tttt));
    }
}
