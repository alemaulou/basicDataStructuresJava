package Chapter2;

import java.util.Arrays;

// Elements are co-located sequentially in an array
public class Array {
    
    // Traversal and random access in an array
    // Store in contiguous memory.
    // Required to compute the offset that corresponds to an index to access element
    // Limited and fixed in size
    // Inserting a new element in array - create new array with one more element, copy all original data.
    public static void printAllElements(int[] integerArray) {
        for(int i = 0; i < integerArray.length; i++) {
            System.out.print(integerArray[i] + " ");
        }
    }
    
    public static void insertElementAtIndex(int[] array, int startIndex, int targetIndex) {
        int value = array[startIndex];
        
        if(startIndex == targetIndex) {
            return;
        } else if(startIndex < targetIndex) {
            for(int i = startIndex + 1; i <= targetIndex; i++) {
                array[i-1] = array[i];
            }
            array[targetIndex] = value;
        } else {
            for(int i = startIndex-1; i >= targetIndex; i--) {
                array[i+1] = array[i];
            }
        } 
        array[targetIndex] = value;
    }
    
    public static int[] insertExtraElementAtIndex(int[] array, int index, int value) {
        int[] arrayCopy = new int[array.length + 1];
        
        for(int i = 0; i < index; i++) {
            arrayCopy[i] = array[i];
        }
        
        arrayCopy[index] = value;
        
        for(int i = index + 1; i < arrayCopy.length; i++) {
            arrayCopy[i] = array[i-1];
        }
        return arrayCopy;
    } 
    
    public static int[] appendElement(int[] array, int value) {
        return insertExtraElementAtIndex(array, array.length, value);
    }
    
    public static void main(String[] args) {
        int[] arrayTest = {0,1,2,3,4,5};
        System.out.print("This is an example of how to print all elements of an array: "); 
        printAllElements(arrayTest);
        insertElementAtIndex(arrayTest, 0, 2);
        System.out.println();
        System.out.print("Re-order elements involving shifting indexes 0 and 2: ");
        printAllElements(arrayTest);
        System.out.println();
        int[] newArray = insertExtraElementAtIndex(arrayTest, 0, 3);
        printAllElements(newArray);
        System.out.println();
        int[] appendArray = appendElement(newArray, 7);
        printAllElements(appendArray);
        
    }
}
