package common;

import org.testng.Assert;
import java.util.logging.Logger;

public class Validation {

    public static void assertEquals(String description, String actual, String expected){
        Assert.assertEquals(actual,expected);
    }

    public static void assertTrue(Boolean condition){
        Assert.assertTrue(condition);
    }

    public static void assertFalse(Boolean condition){
        Assert.assertTrue(condition);
    }
}
