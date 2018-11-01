package de.stevenschwenke.java.writingawesomejavacodeworkshop.part1JavaLanguageAndMethods.bigdecimal;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * Tests to visualize the difference between compareTo() and equals()
 */
class BigDecimalCompareEqual {

    /**
     * The method compareTo() returns an int -1, 0, +1 based on the difference of both numbers.
     *
     * Figurative: Like a pointer that points to the smaller number:
     *  0: there is no smaller number
     * -1: the smaller number is on the left
     * +1: the smaller number is on the right
     *
     *         <- - - - - ->
     *         -1    0    +1
     */
    @Test
    void compareTo() {
        int c1_5 = new BigDecimal("1").compareTo(new BigDecimal("5"));
        int c1_1 = new BigDecimal("1").compareTo(new BigDecimal("1"));
        int c5_1 = new BigDecimal("5").compareTo(new BigDecimal("1"));

        System.out.println(c1_5); // 1 < 5 :  -1
        System.out.println(c1_1); // 1 = 1 :   0
        System.out.println(c5_1); // 5 > 1 :  +1
    }

    /**
     * The method equals() returns a boolean based on whether the numbers are equal or not.
     */
    @Test
    void equals() {
        boolean e1_1 = new BigDecimal("1").equals(new BigDecimal("1"));
        boolean e1_5 = new BigDecimal("1").equals(new BigDecimal("5"));
        boolean e5_1 = new BigDecimal("5").equals(new BigDecimal("1"));

        System.out.println(e1_1); // 1 = 1 :  true
        System.out.println(e1_5); // 1 < 5 :  false
        System.out.println(e5_1); // 5 > 1 :  false
    }

    /**
     * The reason behind the difference of the results of compareTo() and equals() in this test lies in the fact that:
     *
     * {@link BigDecimal#compareTo(BigDecimal)} -  compares based on the difference(!)
     * {@link BigDecimal#equals(Object)}        -  compares the equality of both numbers including the scale(!)
     *
     * Look inside the respective JavaDoc for more information.
     */
    @Test
    void differenceOnScale() {
        BigDecimal dec1_5  = new BigDecimal("1.5");
        BigDecimal dec1_50 = new BigDecimal("1.50");

        System.out.println(     dec1_5.compareTo(dec1_50) == 0   );    // 1.5 = 1.50 : true
        System.out.println(     dec1_5.equals(dec1_50)           );    // 1.5 = 1.50 : false ?!
    }

}
