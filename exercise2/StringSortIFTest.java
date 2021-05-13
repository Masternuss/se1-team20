package exercise2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringSortIFTest {

    StringSortIF depend1;
    StringSortIF depend2;
    String[] arr1;
    String[] arr2;
    String[] arr3;
    String[] arr4;

    @BeforeEach
    void setUp() {
        depend1 = new StringSortImpl(new String[][]{{"A","C"},{"C","D"},{"B","C"}});
        depend2 = new StringSortImpl(new String[][]{{"A","B"},{"B","C"}});
        arr1 = new String[]{"A", "B", "C", "D"};
        arr2 = new String[]{"D", "C", "B", "A"};
        arr3 = new String[]{"B", "A", "C", "D"};
        arr4 = new String[]{"C", "A"};
    }

    @Test
    @DisplayName("Test if sequence {A,B,C,D} is correct in dependencies depend1.")
    void isWellSortedTest1() {
        assertTrue(depend1.isWellSorted(arr1));
    }

    @Test
    @DisplayName("Test if sequence {D, C, B, A} is false in dependencies depend1.")
    void isWellSortedTest2() {
        assertFalse(depend1.isWellSorted(arr2));
    }

    @Test
    @DisplayName("Test if sequence {B, A, C, D} is true in dependencies depend1.")
    void isWellSortedTest3() {

        assertTrue(depend1.isWellSorted(arr3));
    }


    @Test
    @DisplayName("Test if sequence {C,A} is false in dependencies depend2")
    void isWellSortedTest4()
    {
        assertFalse(depend2.isWellSorted(arr4));
    }

    @Test
    @DisplayName("Test if function throws InvalidArgumentException with extra strings.")
    void isWellSortedIAExceptionStringNotIncludedTest()
    {
        assertThrows(IllegalArgumentException.class, () -> depend1.isWellSorted(new String[]{"A","F"}));
    }

    @Test
    @DisplayName("Test if function throws InvalidArgumentException with multiple same strings.")
    void isWellSortedIAExceptionSameStringTest()
    {
        assertThrows(IllegalArgumentException.class, () -> depend1.isWellSorted(new String[]{"A","A","B"}));
    }

    @Test
    @DisplayName("Test if function is transitive")
    void isWellSortedTransitiveTest()
    {
        assertFalse(depend1.isWellSorted(new String[] {"A","C","B"}));
    }

    @AfterEach
    void tearDown() {
        depend1 = null;
        depend2 = null;
        arr1 = null;
        arr2 = null;
        arr3 = null;
        arr4 = null;
    }
}