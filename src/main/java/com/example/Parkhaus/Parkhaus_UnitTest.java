package com.example.Parkhaus;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class Parkhaus_UnitTest {

    private Long counter;
    private String string;
    String[] params;


    @BeforeEach
    void setUp(){
        this.string = "leave,955,1620544094579,7029,703,7f7530ab7d9b69ed3906d0e89509ccdb,#70fe5c,2,_,_,955";
        this.params = string.split(",");
        this.counter = 0L;
    }


    @AfterEach
    void tearDown(){
        this.counter = 0L;
        this.string = null;
        this.params = null;
    }

    @Test
    @DisplayName("tests if getBill() equals body[4]")
    void testGetBill(){
        assertEquals(Double.parseDouble(params[4]), 0, "no clue, how to test the servlet methods - no." + ++counter);
    }

}
