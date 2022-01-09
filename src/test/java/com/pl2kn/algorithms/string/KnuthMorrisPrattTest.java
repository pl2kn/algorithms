package com.pl2kn.algorithms.string;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class KnuthMorrisPrattTest {

    @Test
    public void Simple_Test() {
        KnuthMorrisPratt knp = new KnuthMorrisPratt("pattern");
        assertEquals(3, knp.search("pwepattern"));
    }

    @Test
    public void Repeated_Char_Test() {
        KnuthMorrisPratt knp = new KnuthMorrisPratt("ffff");
        assertEquals(3, knp.search("asdfffff"));
    }
}
