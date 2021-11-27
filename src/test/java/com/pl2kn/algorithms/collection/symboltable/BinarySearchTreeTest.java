package com.pl2kn.algorithms.collection.symboltable;

public class BinarySearchTreeTest extends SymbolTableTest {

  @Override
  public SymbolTable<String, Integer> createSymbolTable() {
    return new BinarySearchTree<>();
  }
}
