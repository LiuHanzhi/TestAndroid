package com.codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryRegexpTest {

  @Test
  public void testSimple() {
    assertEquals(false, BinaryRegexp.multipleOf3().matcher(" 0").matches());
    assertEquals(false, BinaryRegexp.multipleOf3().matcher("abc").matches());
    assertEquals(true, BinaryRegexp.multipleOf3().matcher("000").matches());

    assertEquals(true, BinaryRegexp.multipleOf3().matcher("110").matches());
    assertEquals(false, BinaryRegexp.multipleOf3().matcher("111").matches());
    assertEquals(true, BinaryRegexp.multipleOf3().matcher(Integer.toBinaryString(12345678)).matches());
  }

}