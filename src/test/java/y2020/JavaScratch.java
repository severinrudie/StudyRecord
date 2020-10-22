package y2020;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JavaScratch {

    @Test
    void fun() {
        HashMap<Character, Integer> strChars = new HashMap<>();
        HashMap<Character, Integer> patChars = new HashMap<>();
        strChars.put('a', 5);
        patChars.put('a', 5);

        assertEquals(strChars, patChars);
        assertTrue(strChars.equals(patChars));
    }

}
