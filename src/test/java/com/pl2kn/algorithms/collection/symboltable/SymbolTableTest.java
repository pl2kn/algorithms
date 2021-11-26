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
    symbolTable.put("D", 4);
    symbolTable.put("E", 5);
    symbolTable.delete("A");

    assertEquals(4, symbolTable.size());
    assertNull(symbolTable.get("A"));
    assertEquals(2, symbolTable.get("B"));
    assertEquals(3, symbolTable.get("C"));
    assertEquals(4, symbolTable.get("D"));
    assertEquals(5, symbolTable.get("E"));
  }

  @Test
  public void Delete_Middle_Test() throws IllegalAccessException {
    SymbolTable<String, Integer> symbolTable = createSymbolTable();

    symbolTable.put("A", 1);
    symbolTable.put("B", 2);
    symbolTable.put("C", 3);
    symbolTable.put("D", 4);
    symbolTable.put("E", 5);
    symbolTable.delete("C");

    assertEquals(4, symbolTable.size());
    assertEquals(1, symbolTable.get("A"));
    assertEquals(2, symbolTable.get("B"));
    assertNull(symbolTable.get("C"));
    assertEquals(4, symbolTable.get("D"));
    assertEquals(5, symbolTable.get("E"));
  }

  @Test
  public void Delete_Last_Test() throws IllegalAccessException {
    SymbolTable<String, Integer> symbolTable = createSymbolTable();

    symbolTable.put("A", 1);
    symbolTable.put("B", 2);
    symbolTable.put("C", 3);
    symbolTable.put("D", 4);
    symbolTable.put("E", 5);
    symbolTable.delete("E");

    assertEquals(4, symbolTable.size());
    assertEquals(1, symbolTable.get("A"));
    assertEquals(2, symbolTable.get("B"));
    assertEquals(3, symbolTable.get("C"));
    assertEquals(4, symbolTable.get("D"));
    assertNull(symbolTable.get("E"));
  }

  @Test
  public void Replace_Test() throws IllegalAccessException {
    SymbolTable<String, Integer> symbolTable = createSymbolTable();

    symbolTable.put("A", 1);
    symbolTable.put("B", 2);
    symbolTable.put("C", 3);
    symbolTable.put("B", 5);

    assertEquals(3, symbolTable.size());
    assertEquals(1, symbolTable.get("A"));
    assertEquals(5, symbolTable.get("B"));
    assertEquals(3, symbolTable.get("C"));
  }


  @Test
  public void Min_Key_Test() throws IllegalAccessException {
    SymbolTable<String, Integer> symbolTable = createSymbolTable();

    symbolTable.put("D", 4);
    symbolTable.put("B", 2);
    symbolTable.put("C", 3);
    symbolTable.put("A", 1);
    symbolTable.put("E", 5);

    assertEquals("A", symbolTable.min());
  }

  @Test
  public void Max_Key_Test() throws IllegalAccessException {
    SymbolTable<String, Integer> symbolTable = createSymbolTable();

    symbolTable.put("D", 4);
    symbolTable.put("B", 2);
    symbolTable.put("E", 5);
    symbolTable.put("C", 3);
    symbolTable.put("A", 1);

    assertEquals("E", symbolTable.max());
  }

  @Test
  public void Floor_Key_Test() throws IllegalAccessException {
    SymbolTable<String, Integer> symbolTable = createSymbolTable();

    symbolTable.put("D", 4);
    symbolTable.put("B", 2);
    symbolTable.put("F", 6);
    symbolTable.put("A", 1);
    symbolTable.put("G", 7);
    symbolTable.put("E", 5);

    assertEquals("B", symbolTable.floor("C"));
  }

  @Test
  public void Ceil_Key_Test() throws IllegalAccessException {
    SymbolTable<String, Integer> symbolTable = createSymbolTable();

    symbolTable.put("B", 2);
    symbolTable.put("F", 6);
    symbolTable.put("A", 1);
    symbolTable.put("D", 4);
    symbolTable.put("G", 7);
    symbolTable.put("E", 5);

    assertEquals("D", symbolTable.ceiling("C"));
  }
}
