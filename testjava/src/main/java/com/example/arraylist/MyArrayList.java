package com.example.arraylist;

import java.util.ArrayList;

/**
 * Created by liuhanzhi on 16/3/2.
 */
public class MyArrayList<E> extends ArrayList<E> {

    @Override
    public boolean add(E o) {
        boolean add = super.add(o);
        log("add");
        return add;
    }

    @Override
    public boolean remove(Object o) {
        boolean remove = super.remove(o);
        log("remove");
        return remove;
    }

    @Override
    public E remove(int index) {
        E remove = super.remove(index);
        log("remove");
        return remove;
    }

    public void log(String methed) {
        System.out.println(methed + "  modCount:" + modCount);
    }
}
