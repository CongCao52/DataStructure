package test;

import org.junit.Test;
import org.junit.Assert;

// 
// Decompiled by Procyon v0.5.36
// 

public class ArrayListRemoveElementTest
{
    @Test
    public void testReturnValueWhenElementDoesNotExist() {
        final String[] array = { "a", "b", "c", "d", "e", "f" };
        final MyArrayList list = new MyArrayList();
        final String[] array2 = array;
        for (int length = array2.length, i = 0; i < length; ++i) {
            list.add((Object)array2[i]);
        }
        try {
            Assert.assertFalse("MyArrayList.remove returns incorrect value when attempting to remove element that is not in list", list.remove((Object)"k"));
        }
        catch (Exception ex) {
            Assert.fail("Exception occurred when trying to remove element that does not occur in list: " + ex.toString());
        }
    }
    
    @Test
    public void testReturnValueWhenElementExists() {
        final String[] array = { "a", "b", "c", "d", "e", "f" };
        final MyArrayList list = new MyArrayList();
        final String[] array2 = array;
        for (int length = array2.length, i = 0; i < length; ++i) {
            list.add((Object)array2[i]);
        }
        try {
            Assert.assertTrue("MyArrayList.remove returns incorrect value when attempting to remove element that exists in list", list.remove((Object)"c"));
        }
        catch (Exception ex) {
            Assert.fail("Exception occurred when trying to remove element that exists in list: " + ex.toString());
        }
    }
    
    @Test
    public void testSizeChangesWhenElementRemoved() {
        final String[] array = { "a", "b", "c", "d", "e", "f" };
        final MyArrayList list = new MyArrayList();
        final String[] array2 = array;
        for (int length = array2.length, i = 0; i < length; ++i) {
            list.add((Object)array2[i]);
        }
        try {
            final int size = list.size;
            list.remove((Object)"c");
            Assert.assertTrue("MyArrayList.size field is not correctly modified after removing element from list", list.size == size - 1);
        }
        catch (Exception ex) {
            Assert.fail("Exception occurred when trying to remove element that exists in list: " + ex.toString());
        }
    }
    
    @Test
    public void testElementsInCorrectLocationsAfterElementRemoved() {
        final String[] array = { "a", "b", "c", "d", "e" };
        final MyArrayList list = new MyArrayList();
        final String[] array2 = array;
        for (int length = array2.length, i = 0; i < length; ++i) {
            list.add((Object)array2[i]);
        }
        try {
            list.remove((Object)"c");
            Assert.assertTrue("MyArrayList.remove incorrectly modifies elements in list after element is removed", ((String)list.get(0)).equals("a"));
            Assert.assertTrue("MyArrayList.remove incorrectly modifies elements in list after element is removed", ((String)list.get(1)).equals("b"));
            Assert.assertFalse("MyArrayList.remove does not correctly remove element; it still occurs in list", ((String)list.get(2)).equals("c"));
            Assert.assertTrue("MyArrayList.remove does not correctly modify elements in list after element is removed", ((String)list.get(2)).equals("d"));
            Assert.assertTrue("MyArrayList.remove does not correctly modify elements in list after element is removed", ((String)list.get(3)).equals("e"));
        }
        catch (Exception ex) {
            Assert.fail("Exception occurred when trying to remove element that exists in list: " + ex.toString());
        }
    }
    
    @Test
    public void testElementsInCorrectLocationsAfterDuplicateElementRemoved() {
        final String[] array = { "a", "b", "c", "b", "e" };
        final MyArrayList list = new MyArrayList();
        final String[] array2 = array;
        for (int length = array2.length, i = 0; i < length; ++i) {
            list.add((Object)array2[i]);
        }
        try {
            list.remove((Object)"b");
            Assert.assertTrue("MyArrayList.remove should only remove first instance of element that occurs multiple times in list", ((String)list.get(2)).equals("b"));
        }
        catch (Exception ex) {
            Assert.fail("Exception occurred when trying to remove element that exists in list more than once: " + ex.toString());
        }
    }
}
