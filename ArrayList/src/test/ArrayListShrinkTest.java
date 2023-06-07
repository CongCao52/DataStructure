package test;

import org.junit.Test;
import org.junit.Assert;

// 
// Decompiled by Procyon v0.5.36
// 

public class ArrayListShrinkTest
{
    @Test
    public void testRemoveByIndex() {
        final String[] array = { "a", "b", "c", "d", "e", "f" };
        final MyArrayList list = new MyArrayList();
        final String[] array2 = array;
        for (int length = array2.length, i = 0; i < length; ++i) {
            list.add((Object)array2[i]);
        }
        try {
            list.remove(1);
            
            Assert.assertTrue("MyArrayList.remove(int) incorrectly shrinks array when number of elements is greater than 25% of array size", list.data.length == 8);
            list.remove(1);
            Assert.assertTrue("MyArrayList.remove(int) incorrectly shrinks array when number of elements is greater than 25% of array size", list.data.length == 8);
            list.remove(1);
            Assert.assertTrue("MyArrayList.remove(int) incorrectly shrinks array when number of elements is greater than 25% of array size", list.data.length == 8);
            list.remove(1);
            
            Assert.assertTrue("MyArrayList.remove(int) does not shrink array when number of elements is 25% of array size", list.data.length == 4);
        }
        catch (Exception ex) {
            Assert.fail("MyArrayList.remove(int) throws exception when attempting to remove element by index: " + ex.toString());
        }
    }
    
    @Test
    public void testRemoveByValue() {
        final String[] array = { "a", "b", "c", "d", "e", "f" };
        final MyArrayList list = new MyArrayList();
        final String[] array2 = array;
        for (int length = array2.length, i = 0; i < length; ++i) {
            list.add((Object)array2[i]);
        }
        try {
            list.remove((Object)"b");
            Assert.assertTrue("MyArrayList.remove(E) incorrectly shrinks array when number of elements is greater than 25% of array size", list.data.length == 8);
            list.remove((Object)"c");
            Assert.assertTrue("MyArrayList.remove(E) incorrectly shrinks array when number of elements is greater than 25% of array size", list.data.length == 8);
            list.remove((Object)"d");
            Assert.assertTrue("MyArrayList.remove(E) incorrectly shrinks array when number of elements is greater than 25% of array size", list.data.length == 8);
            list.remove((Object)"e");
            Assert.assertTrue("MyArrayList.remove(E) does not shrink array when number of elements is 25% of array size", list.data.length == 4);
        }
        catch (Exception ex) {
            Assert.fail("MyArrayList.remove(E) throws exception when attempting to remove element by index: " + ex.toString());
        }
    }
    
}