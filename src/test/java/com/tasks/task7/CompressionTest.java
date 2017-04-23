package com.tasks.task7;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tasks.task7.exeptions.InputValidationExeption;

public class CompressionTest {

    private Compression test;

    @DataProvider(name = "tests")
    public static String[][] parametersSet() {
        return new String[][] { { "aaaaaaaaaaaaaaaaaabBBbcrrr", "9a9ab2Bbc3r" }, { "aaaaaaabbchhrrrrry", "7a2bc2h5ry" }, { "world", "world" } };
    }

    @BeforeTest
    public void prepare() {
        test = new Compression();
    }

    @Test(dataProvider = "tests")
    public void testCompress(String compression, String expectedResult) {
        Assert.assertEquals(test.compress(compression), expectedResult);
    }

    @Test(dataProvider = "tests")
    public void testDecompress(String expectedResult, String incomingString) {
        Assert.assertEquals(test.decompress(incomingString), expectedResult);
    }

    @Test
    public void testDecompresMyFavoriteCase() {
        Assert.assertEquals(test.decompress("0h0o0u"), "");
    }

    @Test(expectedExceptions = InputValidationExeption.class)
    public void testCompressThrow() {
        test.compress("fgfggfggg66");
    }

    @Test(expectedExceptions = InputValidationExeption.class)
    public void testCompressEmptyInputString() {
        test.compress("");
    }

    @Test(expectedExceptions = InputValidationExeption.class)
    public void testDecompressThrow() {
        test.decompress("9hh7");
    }

    @Test(expectedExceptions = InputValidationExeption.class)
    public void testDecompressEmptyInputString() {
        test.decompress("");
    }
}
