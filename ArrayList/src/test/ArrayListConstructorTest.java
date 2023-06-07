package test;

import org.junit.Test;
import org.junit.Assert;

// 
// Decompiled by Procyon v0.5.36
// 

public class ArrayListConstructorTest
{
    @Test
    public void testElementsSetCorrectly() {
        final String[] array = { "a", "b", "c" };
        try {
            final MyArrayList list = new MyArrayList((Object[])array);
            Assert.assertTrue("MyArrayList does not correctly set elements in underlying array when input array is passed to constructor", ((String)list.get(0)).equals("a"));
            Assert.assertTrue("MyArrayList does not correctly set elements in underlying array when input array is passed to constructor", ((String)list.get(1)).equals("b"));
            Assert.assertTrue("MyArrayList does not correctly set elements in underlying array when input array is passed to constructor", ((String)list.get(2)).equals("c"));
        }
        catch (Exception ex) {
            Assert.fail("MyArrayList constructor throws exception when attempting to initialize with array: " + ex.toString());
        }
    }
    
    @Test
    public void testSizeSetCorrectly() {
        final String[] array = { "a", "b", "c" };
        try {
            Assert.assertTrue("MyArrayList does not correctly set size when input array is passed to constructor", new MyArrayList((Object[])array).size == 3);
        }
        catch (Exception ex) {
            Assert.fail("MyArrayList constructor throws exception when attempting to initialize with array: " + ex.toString());
        }
    }
    
    @Test
    public void testNullInput() {
        try {
            Assert.assertTrue("MyArrayList does not correctly initialize underlying array when null input array is passed to constructor", new MyArrayList((Object[])null).data != null);
        }
        catch (Exception ex) {
            Assert.fail("MyArrayList constructor throws exception when attempting to initialize with null input array: " + ex.toString());
        }
    }
    
    @Test
    public void testNullInputSize() {
        try {
            Assert.assertTrue("MyArrayList does not correctly set size when null input array is passed to constructor", new MyArrayList((Object[])null).size == 0);
        }
        catch (Exception ex) {
            Assert.fail("MyArrayList constructor throws exception when attempting to initialize with null input array: " + ex.toString());
        }
    }
    
    @Test
    public void testElementsAreCopied() {
        final String[] array = { "a", "b", "c" };
        try {
            final MyArrayList list = new MyArrayList((Object[])array);
            array[1] = "dog";
            Assert.assertFalse("MyArrayList does not make copy of elements when input array is passed to constructor", ((String)list.get(1)).equals("dog"));
        }
        catch (Exception ex) {
            Assert.fail("MyArrayList constructor throws exception when attempting to initialize with array: " + ex.toString());
        }
    }
}