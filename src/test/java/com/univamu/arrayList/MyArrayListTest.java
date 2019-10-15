package com.univamu.arrayList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;


import static org.junit.Assert.*;

public class MyArrayListTest {

  MyArrayList<Integer> emptyMAL = new MyArrayList<>();
  ArrayList<Integer> emptyAL = new ArrayList<>();
  MyArrayList<Integer> someMAL = generateMAL(10);
  ArrayList<Integer> someAL = generateAL(10);

  private static MyArrayList<Integer> generateMAL(int size) {
    MyArrayList<Integer> someMAL = new MyArrayList<>(size);
    for (int index = 0; index < size; index++) {
      someMAL.add(index);
    }
    return someMAL;
  }

  private static ArrayList<Integer> generateAL(int size) {
    ArrayList<Integer> someAL = new ArrayList<>(size);
    for (int index = 0; index < size; index++) {
      someAL.add(index);
    }
    return someAL;
  }

  @Test
  public void testToString() {
    assertEquals(emptyAL.toString(), emptyMAL.toString());
    assertEquals(someAL.toString(), someMAL.toString());
  }

  @Test
  public void testEquals() {
    assertEquals(emptyAL, emptyMAL);
    assertEquals(someAL, someMAL);
    assertNotEquals(someAL, emptyMAL);
    assertNotEquals(emptyAL, someMAL);
  }

  @Test
  public void size() {
    assertEquals(0, emptyMAL.size());
    assertEquals(10, someMAL.size());
  }

  @Test
  public void testConstructor() {
    assertEquals(emptyAL, new MyArrayList<Integer>(emptyAL));
    assertEquals(emptyAL, new MyArrayList<Integer>(emptyMAL));
    assertEquals(someAL, new MyArrayList<Integer>(someAL));
    assertEquals(someAL, new MyArrayList<Integer>(someMAL));
  }

  @Test
  public void isEmpty() {
    assertTrue(emptyMAL.isEmpty());
    assertFalse(someMAL.isEmpty());
  }

  @Test
  public void add() {
  }

  @Test
  public void get() {
  }

  @Test
  public void set() {
    ArrayList<Integer> copyAL = new ArrayList<>(someAL);
    MyArrayList<Integer> copyMAL = new MyArrayList<>(someMAL);
    copyAL.set(3, 42);
    copyMAL.set(3, 42);
    assertEquals(copyAL, copyMAL);
  }


  @Test
  public void iterator() {
    Iterator<Integer> alIter = someAL.iterator();
    Iterator<Integer> malIter = someMAL.iterator();
    for (int iterCount = 0; alIter.hasNext(); iterCount++) {
      assertTrue(
        "test hasNext iteration " + iterCount,
        malIter.hasNext()
      );
      assertEquals(
        "test next iteration " + iterCount,
        alIter.next(),
        malIter.next()
      );
    }
    assertFalse("test last hasNext", malIter.hasNext());
  }
}