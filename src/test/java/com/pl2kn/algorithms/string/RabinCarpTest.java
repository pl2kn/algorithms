package com.pl2kn.algorithms.string;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RabinCarpTest {

    @Test
    public void Simple_Test() {
        RabinKarp rk = new RabinKarp("pattern");
        assertEquals(3, rk.search("pwepattern"));
    }

    @Test
    public void Repeated_Char_Test() {
        RabinKarp rk = new RabinKarp("ffff");
        assertEquals(3, rk.search("asdfffff"));
    }
}
