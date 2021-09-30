package hu.flowacademy.lambda._01_collections;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TwoKeyMapTest {

    TwoKeyMap<Integer, Integer, Integer> twoKeyMap;

    @BeforeAll
    static void beforeAll(){
        System.out.println("BeforeAll");
    }
    @BeforeEach
    void beforeEach(){
        twoKeyMap = new TwoKeyMap<>();
    }
    @AfterEach
    void afterEach(){
        System.out.println("AfterEach");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("AfterAll");
    }

    @Test
    void startsEmpty() {
        Integer value = twoKeyMap.get(1, 1);

        assertNull(value);
//        assertTrue(value == null);
    }

    @Test
    void canGetValueThatWasPut() {
        TwoKeyMap<Integer, Integer, Integer> twoKeyMap = new TwoKeyMap<>();
        Integer k1 = 1;
        Integer k2 = 2;
        Integer value = 5;

        twoKeyMap.put(k1,k2,value);
        Integer result = twoKeyMap.get(k1, k2);

        assertEquals(value, result, "Returned value must be equal to the one put.");
        assertSame(value, result, () -> "Returned value must be equal to the one put.");

        assertAll("equal and same",
                () -> assertEquals(value, result),
                () -> assertSame(value, result)
        );
    }

    @Test
    @DisplayName("Using null as a key causes an IllegalArgumentException to be thrown.")
    void nullKeyThrowsException() {
        // fapados megoldás
        IllegalArgumentException iae = null;
        try {
            twoKeyMap.put(null, 1, 1);
        } catch (IllegalArgumentException e) {
            iae = e;
        }
        assertNotNull(iae);
        assertEquals("Keys must not be null.", iae.getMessage());

        // assertThrows
        IllegalArgumentException iae2 = assertThrows(IllegalArgumentException.class, () -> twoKeyMap.put(null, 1, 1));
        assertEquals("Keys must not be null.", iae.getMessage());
    }

    @Test
    @Disabled
    public void someTest() {

    }
}
