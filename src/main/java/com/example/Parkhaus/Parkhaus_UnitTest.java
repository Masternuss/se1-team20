package com.example.Parkhaus;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class Parkhaus_UnitTest {

    private Long counter;
    private String body1;
    private String body2;
    String[] params1;
    String[] params2;


    @BeforeEach
    void setUp(){
        this.body1 = "leave,955,1620544094579,7029,703,7f7530ab7d9b69ed3906d0e89509ccdb,#70fe5c,2,_,_,955";
        this.body2 = "enter,611,1620547220594,_,_,01b0de5dfad55a254e10948a5a769c90,#497067,7,_,_,611";
        this.params1 = body1.split(",");
        this.params2 = body2.split(",");
        this.counter = 0L;
    }


    @AfterEach
    void tearDown(){
        this.counter = 0L;
        this.body1 = null;
        this.body2 = null;
        this.params1 = null;
        this.params2 = null;
    }


    @Test
    @DisplayName("tests if getBill() equals body[4]")
    void testGetBill(){
        assertEquals(Double.parseDouble(this.params1[4]), ParkhausServletDummy.getBill(this.body1), "damn! something works not like intended - no." + ++counter);
        assertEquals(0L, ParkhausServletDummy.getBill(this.body2), "damn! something works not like intended - no." + ++counter);
    }

    @Test
    @DisplayName("tests if getTotalCars() count the leaving cars correctly (only increments when cars leaving)")
    void testGetTotalCars(){
        assertEquals(1l, ParkhausServletDummy.getTotalCars(body1), "damn! something works not like intended - no." + ++counter);
        assertEquals(1l, ParkhausServletDummy.getTotalCars(body2), "damn! something works not like intended - no." + ++counter);
    }

}
