import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RemoveLetterToEqualizeFrequencyTest {



    @Test
    void test1(){
        var response=RemoveLetterToEqualizeFrequency.equalFrequency("abcc");
        assertTrue(response);
    }

    @Test
    void test2(){
        var response=RemoveLetterToEqualizeFrequency.equalFrequency("aazz");
        assertFalse(response);
    }

    @Test
    void test3(){
        var response=RemoveLetterToEqualizeFrequency.equalFrequency("bac");
        assertTrue(response);
    }

    @Test
    void test4(){
        var response=RemoveLetterToEqualizeFrequency.equalFrequency("ddaccb");
        assertFalse(response);
    }

    @Test
    void test5(){
        var response=RemoveLetterToEqualizeFrequency.equalFrequency("abbcc");
        assertTrue(response);
    }

    @Test
    void test6(){
        var response=RemoveLetterToEqualizeFrequency.equalFrequency("zz");
        assertTrue(response);
    }

    @Test
    void test7(){
        var response=RemoveLetterToEqualizeFrequency.equalFrequency("cccd");
        assertTrue(response);
    }

    @Test
    void test8(){
        var response=RemoveLetterToEqualizeFrequency.equalFrequency("aaaabbbbccc");
        assertFalse(response);
    }

    @Test
    void test9(){
        var response=RemoveLetterToEqualizeFrequency.equalFrequency("cccaa");
        assertTrue(response);
    }



}
