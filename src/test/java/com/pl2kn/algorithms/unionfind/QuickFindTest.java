package com.pl2kn.algorithms.unionfind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuickFindTest {

    @Test
    void Node_Count()
    {
        QuickFind quickFind = new QuickFind(5);

        assertEquals(5, quickFind.nodes.length);
    }

    @Test
    void Two_Node_Union()
    {
        QuickFind quickFind = new QuickFind(2);
        quickFind.union(0, 1);

        assertEquals(1, quickFind.find(0));
        assertEquals(1, quickFind.find(1));
    }

    @Test
    void Three_Node_Union()
    {
        QuickFind quickFind = new QuickFind(3);
        quickFind.union(0, 1);
        quickFind.union(1, 2);

        assertEquals(2, quickFind.find(0));
        assertEquals(2, quickFind.find(1));
        assertEquals(2, quickFind.find(2));
    }
}
