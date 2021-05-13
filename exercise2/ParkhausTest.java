import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ParkhausTest {

    private long counter;

    //Parkplatz fpark;
    //Parkplatz hpark;
    Parkhaus haus;


    @BeforeEach
    void setUp() {
       //fpark = new Frauenparkplatz(1);
       //hpark = new Handicapparkplatz(2);
       haus = new Parkhaus(20,5,5,5,5);
    }

    @Test
    @DisplayName("Die Anzahl der verfügbaren Parkplätze werden wiedergegeben")
    void test_anzahl() {
        counter = 0;
        assertEquals(20, haus.getParkplaetze(),"something went wrong no" + ++counter);
        assertEquals(5, haus.getFamilienparkplaetze(),"something went wrong no" + ++counter);
        assertEquals(5, haus.getFrauenparkplaetze(),"something went wrong no" + ++counter);
        assertEquals(5, haus.getHandicapparkplaetze(),"something went wrong no" + ++counter);
        assertEquals(5, haus.getTageskundenparkplaetze(),"something went wrong no" + ++counter);
        assertNotEquals(4, haus.getTageskundenparkplaetze(),"something went wrong no" + ++counter);

    }
/*
    @Disabled
    @Test
    @DisplayName("stimmt es, dass die kindklassen nicht gleich sind?")
    void testChildClasses(){
        counter = 0;
        //assertNotEquals(fpark, hpark, "something went wrong no" + ++counter);
    }
*/
    @AfterEach
    void tearDown() {
        //fpark = null;
        //hpark = null;
        haus = null;
    }
}