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
}
