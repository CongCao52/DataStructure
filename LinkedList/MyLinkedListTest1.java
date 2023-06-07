/* Decompiler 18ms, total 510ms, lines 45 */
import org.junit.Assert;
import org.junit.Test;

public class MyLinkedListTest1 {
    @Test
    public void testRemoveSingleLargestSizeDecreases() {
        final MyLinkedList list = new MyLinkedList();
        list.addFirst("cat");
        list.addFirst("dog");
        list.addFirst("gorilla");
        list.addFirst("elephant");
        try {
            final int size = list.size;
            list.removeMaximumValues(1);
            Assert.assertTrue("MyLinkedList.size not correctly modified after removing single maximum value", list.size == size - 1);
        }
        catch (Exception ex) {
            Assert.fail("MyLinkedList.removeMaximumValues threw exception when attempting to remove single maximum value: " + ex.toString());
        }
    }
    
    @Test
    public void testRemoveSingleLargestElementIsRemoved() {
        final MyLinkedList list = new MyLinkedList();
        list.addFirst("cat");
        list.addFirst("dog");
        list.addFirst("gorilla");
        list.addFirst("elephant");
        try {
            list.removeMaximumValues(1);
            Assert.assertFalse("MyLinkedList.removeMaximumValue does not remove element from list when attempting to remove single maximum value", list.contains("gorilla"));
        }
        catch (Exception ex) {
            Assert.fail("MyLinkedList.removeMaximumValues threw exception when attempting to remove single maximum value: " + ex.toString());
        }
    }
    
    @Test
    public void testRemoveTwoLargestElementsAreRemoved() {
        final MyLinkedList list = new MyLinkedList();
        list.addFirst("cat");
        list.addFirst("dog");
        list.addFirst("gorilla");
        list.addFirst("elephant");
        try {
            list.removeMaximumValues(2);
            Assert.assertFalse("MyLinkedList.removeMaximumValue does not remove elements from list when attempting to remove more than one maximum value", list.contains("gorilla") || list.contains("elephant"));
        }
        catch (Exception ex) {
            Assert.fail("MyLinkedList.removeMaximumValues threw exception when attempting to remove more than one maximum value: " + ex.toString());
        }
    }
}