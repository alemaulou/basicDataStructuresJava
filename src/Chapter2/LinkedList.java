package Chapter2;

import java.util.Iterator;
import java.util.NoSuchElementException;


/* Solution to Array fixed size problem.
 * Store each element in a different object.
 * Hold a reference to the next element.
 * Creating the element and attaching it at the end of the orignal LinkedList.
 */

public class LinkedList<E> implements Iterator<E> {
    
    // initialize length of LinkedList.
    int length = 0;
    
    // Last modified noed.
    Node<E>[] lastModifiedNode;
    Node<E> first;
    Node<E> last;
    
    // wrapper for elements and hold reference for the next node.
    public static class Node<E> {
        protected E value;
        protected Node<E> next;
        
        public E getValue() {
            return value;
        }
        public Node<E> getNext() {
            return next;
        }
        
        @Override
        public String toString() {
            return "Node [value=" + value + ", next=" + next + "]";
        }
    }
    
    protected Node<E> getNewNode() {
        Node<E> node = new Node<>();
        lastModifiedNode = new Node[] {node};
        return node;
    }
}
