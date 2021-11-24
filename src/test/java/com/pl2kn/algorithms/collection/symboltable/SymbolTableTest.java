package com.pl2kn.algorithms.collection.symboltable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

abstract class SymbolTableTest {

  public abstract SymbolTable<String, Integer> createSymbolTable();

  @Test
  public void Put_Get_Test() throws IllegalAccessException {
    SymbolTable<String, Integer> symbolTable = createSymbolTable();

    symbolTable.put("A", 1);
    symbolTable.put("B", 2);
    symbolTable.put("C", 3);

    assertEquals(3, symbolTable.size());
    assertEquals(1, symbolTable.get("A"));
    assertEquals(2, symbolTable.get("B"));
    assertEquals(3, symbolTable.get("C"));
  }

  @Test
  public void Contains_Test() throws IllegalAccessException {
    SymbolTable<String, Integer> symbolTable = createSymbolTable();

    symbolTable.put("A", 1);
    symbolTable.put("B", 2);
    symbolTable.put("C", 3);

    assertTrue(symbolTable.contains("A"));
  }

  @Test
  public void Not_Contains_Test() throws IllegalAccessException {
    SymbolTable<String, Integer> symbolTable = createSymbolTable();

    symbolTable.put("A", 1);
    symbolTable.put("B", 2);
    symbolTable.put("C", 3);

    assertFalse(symbolTable.contains("D"));
  }

  @Test
  public void Get_Not_Existing_Key_Test() throws IllegalAccessException {
    SymbolTable<String, Integer> symbolTable = createSymbolTable();

    symbolTable.put("A", 1);
    symbolTable.put("B", 2);
    symbolTable.put("C", 3);

    assertNull(symbolTable.get("D"));
  }

  @Test
  public void Delete_First_Test() throws IllegalAccessException {
    SymbolTable<String, Integer> symbolTable = createSymbolTable();

    symbolTable.put("A", 1);
    symbolTable.put("B", 2);
    symbolTable.put("C", 3);
    symbolTable.delete("A");

    assertEquals(2, symbolTable.size());
    assertNull(symbolTable.get("A"));
    assertEquals(2, symbolTable.get("B"));
    assertEquals(3, symbolTable.get("C"));
  }

  @Test
  public void Delete_Middle_Test() throws IllegalAccessException {
    SymbolTable<String, Integer> symbolTable = createSymbolTable();

    symbolTable.put("A", 1);
    symbolTable.put("B", 2);
    symbolTable.put("C", 3);
    symbolTable.delete("B");

    assertEquals(2, symbolTable.size());
    assertEquals(1, symbolTable.get("A"));
    assertNull(symbolTable.get("B"));
    assertEquals(3, symbolTable.get("C"));
  }

  @Test
  public void Delete_Last_Test() throws IllegalAccessException {
    SymbolTable<String, Integer> symbolTable = createSymbolTable();

    symbolTable.put("A", 1);
    symbolTable.put("B", 2);
    symbolTable.put("C", 3);
    symbolTable.delete("C");

    assertEquals(2, symbolTable.size());
    assertEquals(1, symbolTable.get("A"));
    assertEquals(2, symbolTable.get("B"));
    assertNull(symbolTable.get("C"));
  }
}
