package com.pl2kn.algorithms.collection.symboltable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest extends SymbolTableTest {

  @Override
  public SymbolTable<String, Integer> createSymbolTable() {
    return new BinarySearchTree<>();
  }

  @Test
  public void Rank_Left_Test() throws IllegalAccessException {
    BinarySearchTree<String, Integer> symbolTable = new BinarySearchTree<>();

    symbolTable.put("B", 2);
    symbolTable.put("F", 6);
    symbolTable.put("A", 1);
    symbolTable.put("D", 4);
    symbolTable.put("G", 7);
    symbolTable.put("E", 5);

    assertEquals(1, symbolTable.rank("B"));
  }

  @Test
  public void Rank_Right_Test() throws IllegalAccessException {
    BinarySearchTree<String, Integer> symbolTable = new BinarySearchTree<>();

    symbolTable.put("B", 2);
    symbolTable.put("F", 6);
    symbolTable.put("A", 1);
    symbolTable.put("D", 4);
    symbolTable.put("G", 7);
    symbolTable.put("E", 5);

    assertEquals(2, symbolTable.rank("C"));
  }

  @Test
  public void Iterator_Test() throws IllegalAccessException {
    BinarySearchTree<String, Integer> symbolTable = new BinarySearchTree<>();

    symbolTable.put("B", 2);
    symbolTable.put("F", 6);
    symbolTable.put("A", 1);
    symbolTable.put("D", 4);
    symbolTable.put("G", 7);
    symbolTable.put("E", 5);

    String[] keys = new String[symbolTable.size()];
    int i = 0;
    for (String key : symbolTable.keys()) {
      keys[i++] = key;
    }

    String[] expectedKeys = {"A", "B", "D", "E", "F", "G"};
    assertArrayEquals(expectedKeys, keys);
  }

  @Test
  public void Delete_Min_Test() throws IllegalAccessException {
    BinarySearchTree<Integer, Integer> symbolTable = new BinarySearchTree<>();

    symbolTable.put(3, 3);
    symbolTable.put(1, 1);
    symbolTable.put(5, 5);
    symbolTable.put(2, 2);
    symbolTable.put(0, 0);
    symbolTable.put(4, 4);
    symbolTable.put(6, 6);

    symbolTable.deleteMin();

    Integer[] keys = new Integer[symbolTable.size()];
    int i = 0;
    for (Integer key : symbolTable.keys()) {
      keys[i++] = key;
    }

    Integer[] expectedKeys = {1, 2, 3, 4, 5, 6};
    assertArrayEquals(expectedKeys, keys);
  }

  @Test
  public void Delete_Max_Test() throws IllegalAccessException {
    BinarySearchTree<Integer, Integer> symbolTable = new BinarySearchTree<>();

    symbolTable.put(3, 3);
    symbolTable.put(1, 1);
    symbolTable.put(5, 5);
    symbolTable.put(2, 2);
    symbolTable.put(0, 0);
    symbolTable.put(4, 4);
    symbolTable.put(6, 6);

    symbolTable.deleteMax();

    Integer[] keys = new Integer[symbolTable.size()];
    int i = 0;
    for (Integer key : symbolTable.keys()) {
      keys[i++] = key;
    }

    Integer[] expectedKeys = {0, 1, 2, 3, 4, 5};
    assertArrayEquals(expectedKeys, keys);
  }

  @Test
  public void Delete_No_Child_Test() throws IllegalAccessException{
    BinarySearchTree<Integer, Integer> symbolTable = new BinarySearchTree<>();

    symbolTable.put(3, 3);
    symbolTable.put(1, 1);
    symbolTable.put(5, 5);
    symbolTable.put(2, 2);
    symbolTable.put(0, 0);
    symbolTable.put(4, 4);
    symbolTable.put(6, 6);

    symbolTable.delete(0);

    Integer[] keys = new Integer[symbolTable.size()];
    int i = 0;
    for (Integer key : symbolTable.keys()) {
      keys[i++] = key;
    }

    Integer[] expectedKeys = {1, 2, 3, 4, 5, 6};
    assertArrayEquals(expectedKeys, keys);
  }

  @Test
  public void Delete_One_Test() throws IllegalAccessException{
    BinarySearchTree<Integer, Integer> symbolTable = new BinarySearchTree<>();

    symbolTable.put(3, 3);
    symbolTable.put(1, 1);
    symbolTable.put(5, 5);
    symbolTable.put(2, 2);
    symbolTable.put(4, 4);
    symbolTable.put(6, 6);

    symbolTable.delete(1);

    Integer[] keys = new Integer[symbolTable.size()];
    int i = 0;
    for (Integer key : symbolTable.keys()) {
      keys[i++] = key;
    }

    Integer[] expectedKeys = {2, 3, 4, 5, 6};
    assertArrayEquals(expectedKeys, keys);
  }

  @Test
  public void Delete_Two_Children() throws IllegalAccessException{
    BinarySearchTree<Integer, Integer> symbolTable = new BinarySearchTree<>();

    symbolTable.put(3, 3);
    symbolTable.put(1, 1);
    symbolTable.put(5, 5);
    symbolTable.put(2, 2);
    symbolTable.put(0, 0);
    symbolTable.put(4, 4);
    symbolTable.put(6, 6);

    symbolTable.delete(1);

    Integer[] keys = new Integer[symbolTable.size()];
    int i = 0;
    for (Integer key : symbolTable.keys()) {
      keys[i++] = key;
    }

    Integer[] expectedKeys = {0, 2, 3, 4, 5, 6};
    assertArrayEquals(expectedKeys, keys);
  }
}
