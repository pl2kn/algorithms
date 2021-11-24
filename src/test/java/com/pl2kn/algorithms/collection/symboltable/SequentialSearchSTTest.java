package com.pl2kn.algorithms.collection.symboltable;

public class SequentialSearchSTTest extends SymbolTableTest {

  @Override
  public SymbolTable<String, Integer> createSymbolTable() {
    return new SequentialSearchST<>();
  }
}
