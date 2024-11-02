package com.csc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTriangleNumberCalculator {

  TriangleNumberCalculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new TriangleNumberCalculator();
  }

  @Test
  void testValue(){
    assertEquals(1, calculator.value(1));
    assertEquals(3, calculator.value(2));
    assertEquals(10, calculator.value(4));
  }


  @Test
  void testAdd(){
    assertEquals(2, calculator.add(1, 1));
    assertEquals(9, calculator.add(2, 3));
    assertEquals(13, calculator.add(4, 2));
  }

  @Test
  void testSubtract(){
    assertEquals(0, calculator.subtract(1,1));
    assertEquals(-3, calculator.subtract(2,3));
    assertEquals(7, calculator.subtract(4,2));
  }

  @Test
  void testStackOverflowValue() {
    int n = 1;
    try {
      while (true) {
        calculator.value(n);
        n++;
      }
    } catch (StackOverflowError e) {
      System.out.println("Stack overflow (value) at: " + n);
    }
  }

  @Test
  void testStackOverflowAdd() {
    int n = 1;
    try {
      while (true) {
        calculator.add(n, n);
        n++;
      }
    } catch (StackOverflowError e) {
      System.out.println("Stack overflow (add) at: " + n);
    }
  }

  @Test
  void testStackOverflowSubtract() {
    int n = 1;
    try {
      while (true) {
        calculator.subtract(n, n);
        n++;
      }
    } catch (StackOverflowError e) {
      System.out.println("Stack overflow (subtract) at: " + n);
    }
  }

  @Test
  void testMultiply(){
    assertEquals(1,calculator.multiply(1,1));
    assertEquals(18,calculator.multiply(2,3));
    assertEquals(30,calculator.multiply(4,2));
  }

  @Test
  void testDivide(){
    assertEquals(1.0,calculator.divide(1,1));
    assertEquals(0.5,calculator.divide(2,3));
    assertEquals(2.5,calculator.divide(5,3));
  }

  @Test
  void testSequence(){
    List<Integer> expected = Arrays.asList(1, 3, 6, 10, 15);
    assertEquals(expected, calculator.sequence(5));

    expected = Arrays.asList(1, 3);
    assertEquals(expected, calculator.sequence(2));

    expected = Arrays.asList(1);
    assertEquals(expected, calculator.sequence(1));
  }
}

