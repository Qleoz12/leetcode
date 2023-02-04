import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VerifyinganAlienDictionaryTest{

    @Test
    void testisAlienSorted(){

        String[] array= {"hello","leetcode"};
        var order = "hlabcdefgijkmnopqrstuvwxyz";

        var response=new VerifyinganAlienDictionary().isAlienSorted(array,order);

        assertTrue(response);
    }

    @Test
    void testisAlienSorted2(){

        String[] array= {"word","world","row"};
        var order = "worldabcefghijkmnpqstuvxyz";

        var response=new VerifyinganAlienDictionary().isAlienSorted(array,order);

        assertFalse(response);
    }

    @Test
    void testisAlienSorted3(){

        String[] array= {"apple","app"};
        var order = "abcdefghijklmnopqrstuvwxyz";

        var response=new VerifyinganAlienDictionary().isAlienSorted(array,order);

        assertFalse(response);
    }

    @Test
    void testisAlienSorted4(){

        String[] array= {"app","apple"};
        var order = "abcdefghijklmnopqrstuvwxyz";

        var response=new VerifyinganAlienDictionary().isAlienSorted(array,order);

        assertTrue(response);
    }


    @Test
    void testisAlienSorted5(){

        String[] array= {"aa","a"};
        var order = "abqwertyuioplkjhgfdszxcvnm";

        var response=new VerifyinganAlienDictionary().isAlienSorted(array,order);

        assertFalse(response);
    }

    @Test
    void testisAlienSorted6(){

        String[] array= {"fxasxpc","dfbdrifhp","nwzgs","cmwqriv","ebulyfyve","miracx","sxckdwzv","dtijzluhts","wwbmnge","qmjwymmyox"};
        var order = "zkgwaverfimqxbnctdplsjyohu";

        var response=new VerifyinganAlienDictionary().isAlienSorted(array,order);

        assertFalse(response);
    }
}
