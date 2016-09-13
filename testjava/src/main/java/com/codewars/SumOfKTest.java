package com.codewars;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfKTest {
 
    @Test
    public void BasicTests1() {
        System.out.println("****** Basic Tests small numbers******");
        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        int n;
        //n = SumOfK.chooseBestSum(163, 3, ts);
        //assertEquals(163, n);


        ts = new ArrayList<>(Arrays.asList(50));
        Integer m = SumOfK.chooseBestSum(163, 3, ts);
        assertEquals(null, m);      
        ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        //n = SumOfK.chooseBestSum(230, 3, ts);
        //assertEquals(228, n);


        n = SumOfK.chooseBestSum(331,5,ts);
        assertEquals(0,n);
    }
}
















