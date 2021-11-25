package com.pl2kn.algorithms.collection.symboltable;

public class SequentialSearchSymbolTableTest extends SymbolTableTest {

  @Override
  public SymbolTable<String, Integer> createSymbolTable() {
    return new SequentialSearchSymbolTable<>();
  }
}
