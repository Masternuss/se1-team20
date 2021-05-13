package exercise2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class junit_test_case {

    private String[] sequence1;
    private String[] sequence2;
    private long counter;

    @BeforeEach
    public void set_up()throws Exception{
        sequence1 = new String[]{"A", "B", "C", "D"};
        sequence2 = new String[]{"D", "C", "B", "A"};
    }

    @AfterEach
    public void tear_down(){
        sequence1 = null;
        sequence2 = null;
    }

    @Test
    public void test_is_well_sorted(){
        counter = 0;
        Assertions.assertTrue(string_sort.isWellSorted(sequence1), "something went wrong no." + ++counter);
        Assertions.assertFalse(string_sort.isWellSorted(sequence2), "something went wrong no." + ++counter);

    }







}
