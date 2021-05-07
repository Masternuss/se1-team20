package com.example.Parkhaus;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class Parkhaus_UnitTest {

    private Long counter;
    final private ParkhausServlet servlet = new ParkhausServlet();


    @BeforeEach
    void setUp(){
    }

    @AfterEach
    void tearDown(){
        this.counter = 0L;
    }

    @Test
    @DisplayName("tests if getBill() equals body[4]")
    void testGetBill(){
    }

}
