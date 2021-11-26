package com.pl2kn.algorithms.collection.symboltable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinarySearchSymbolTableTest extends SymbolTableTest {

  @Override
  public SymbolTable<String, Integer> createSymbolTable() {
    return new BinarySearchSymbolTable<>(100);
  }

  @Test
  public void Put_Fast_Test() throws IllegalAccessException {
    SymbolTable<String, Integer> symbolTable = createSymbolTable();

    symbolTable.put("B", 2);
    symbolTable.put("C", 3);
    symbolTable.put("D", 4);
    symbolTable.put("E", 5);
    symbolTable.put("A", 1);

    assertEquals(1, symbolTable.get("A"));
    assertEquals(2, symbolTable.get("B"));
    assertEquals(3, symbolTable.get("C"));
    assertEquals(4, symbolTable.get("D"));
    assertEquals(5, symbolTable.get("E"));
  }

  @Test
  public void Put_Middle_Test() throws IllegalAccessException {
    SymbolTable<String, Integer> symbolTable = createSymbolTable();

    symbolTable.put("A", 1);
    symbolTable.put("B", 2);
    symbolTable.put("D", 4);
    symbolTable.put("E", 5);
    symbolTable.put("C", 3);

    assertEquals(1, symbolTable.get("A"));
    assertEquals(2, symbolTable.get("B"));
    assertEquals(3, symbolTable.get("C"));
    assertEquals(4, symbolTable.get("D"));
    assertEquals(5, symbolTable.get("E"));
  }

  @Test
  public void Put_Last_Test() throws IllegalAccessException {
    SymbolTable<String, Integer> symbolTable = createSymbolTable();

    symbolTable.put("A", 1);
    symbolTable.put("B", 2);
    symbolTable.put("C", 3);
    symbolTable.put("D", 4);
    symbolTable.put("E", 5);

    assertEquals(1, symbolTable.get("A"));
    assertEquals(2, symbolTable.get("B"));
    assertEquals(3, symbolTable.get("C"));
    assertEquals(4, symbolTable.get("D"));
    assertEquals(5, symbolTable.get("E"));
  }

}
