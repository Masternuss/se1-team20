import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringSortIFTest {

    StringSortIF s = new StringSortImpl(new String[][]{{"A","C"},{"C","D"},{"B","C"}});
    StringSortIF s1 = new StringSortImpl(new String[][]{{"A","B"},{"B","C"}});
    String[] arr1 = {"A","B","C","D"};
    String[] arr2 = {"D","C","B","A"};
    String[] arr3 = {"B","A","C","D"};
    String[] arr4 = {"C","A"};

    @BeforeEach
    void setUp() {
        s = new StringSortImpl(new String[][]{{"A","C"},{"C","D"},{"B","C"}});
        s1 = new StringSortImpl(new String[][]{{"A","B"},{"B","C"}});
        arr1 = new String[]{"A", "B", "C", "D"};
        arr2 = new String[]{"D", "C", "B", "A"};
        arr3 = new String[]{"B", "A", "C", "D"};
    }

    @Test
    @DisplayName("Test if Sequence {A,B,C,D} is correct")
    void isWellSortedTest1() {
        assertTrue(s.isWellSorted(arr1));
    }

    @Test
    @DisplayName("Test if Sequence {D, C, B, A} is false")
    void isWellSortedTest2() {
        assertFalse(s.isWellSorted(arr2));
    }

    @Test
    @DisplayName("Test if Sequence {B, A, C, D} is True")
    void isWellSortedTest3() {
        assertTrue(s.isWellSorted(arr3));
    }

    @Test
    @DisplayName("Test if Sequence {C,A} is False")
    void isWellSortedTest4() {
        assertFalse(s1.isWellSorted(arr4));
    }

    @AfterEach
    void tearDown() {
    }
}