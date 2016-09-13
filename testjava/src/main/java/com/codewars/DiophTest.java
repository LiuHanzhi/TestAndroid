package com.codewars;

import static org.junit.Assert.*;
import org.junit.Test;


public class DiophTest {

	@Test
	public void test1() {
		assertEquals("[[3, 1]]", Dioph.solEquaStr(5));
	}
	@Test
	public void test2() {
		assertEquals("[[4, 1]]", Dioph.solEquaStr(12));
	}
	@Test
	public void test3() {
		assertEquals("[[7, 3]]", Dioph.solEquaStr(13));
	}
	@Test
	public void test4() {
		assertEquals("[[4, 0]]", Dioph.solEquaStr(16));
	}
	@Test
	public void test5() {
		assertEquals("[[4505, 2252], [1503, 750], [647, 320], [505, 248], [415, 202], [353, 170], [225, 102], [153, 60], [135, 48], [103, 20], [97, 10], [95, 2]]", Dioph.solEquaStr(900000009));
	}
}