/*  Name: Ethan Chen
 *  PennKey: etc
 *  Recitation: 217
 *
 *  Execution: java LinkedList
 * 
 *  Creates a LinkedList implementing the List API
 */

public class LinkedList<T> implements List<T> {
    private Node head;
    private Node lastNode;
    
    public class Node {
        private Node next;
        private T nodeElement;
        
        public Node(T element) {
            next = null;
            nodeElement =  element;
        }
        
        public Node(Node n, T element) {
            next = n;
            nodeElement = element;
        }
    }
    
    /**
     * Adds the object x to the end of the list.
     * @param x the element to be added to this list
     * @return true
     */
    public boolean add(T x) {
         //create two node objects referring to same point
        if (head == null) {
            lastNode = new Node(x);
            head = new Node(lastNode, x);
        }
        //iterate through node until reaching the end or reference last node
        else {
            Node y = head;
            while (y.next != lastNode) {
                y = y.next;
            }
            //insert node referencing last node; next insert node will replace
            Node insert = new Node(lastNode, x);
            y.next = insert;
        }
        return true;
    }
    
    /**
     * Adds the object x at the specified position
     * @param index the position to add the element
     * @param x the element to be added to the list
     * @return true if the operation succeeded, false otherwise
     * @throws IllegalArgumentException - if index is longer
     * than the currentlength of the list
     */
    public boolean add(int index, T x) {
        illegalArgumentCheck(index);
        //add head and last node if empty
        if (head == null) {
            return add(x);
        }
        Node y = head;
        int currentIndex = 0;
        //add new head if index 0
        if (index == 0) {
            head = new Node(y, x);
            return true;
        }
        //iterate through list until reach placeto insert
        else {
            while (currentIndex < index - 1) {
                y = y.next;
                currentIndex++;
            }
            //insert node 
            y.next = new Node(y.next, x);
            return true;
        }
    }

    /**
     * Returns the number of elements in this list
     * @return the number of elements in this list
     */
    public int size() {
        //return 0 if tour empty
        if (head == null) {
            return 0;
        }
        //iterate through nodes and count them
        Node x = head;
        int numberNodes = 1;
        while (x.next != null) {
            numberNodes++;
            x = x.next;
        }
        //make sure not to double count lastNode
        if (head.next != null) {
            numberNodes -= 1;
        }
        return numberNodes;
    }
    
    /**
     * Returns the element with the specified position in this list
     * @param index the position of the element
     * @return the element at the specified position in this list
     * @throws IllegalArugmentException if index is longer than the
     * number of elements in the list
     */
    public T get(int index) {
        illegalArgumentCheckSize(index);
        //iterate through list until reach index to get value from
        Node y = head;
        int currentIndex = 0;
        while (currentIndex < index) {
            y = y.next;
            currentIndex++;
        }
        return y.nodeElement;
    }
    
    /**
     * Replaces the object at the specified position
     * @param index the position to replace
     * @param x the element to be stored
     * @return the previous value of the element at index
     * @throws IllegalArugmentException if index is longer than the
     * number of elements in the list
     */
    public T set(int index, T x) {
        illegalArgumentCheckSize(index);
        //iterate through list until reach the correct index to replace node
        Node y = head;
        int currentIndex = 0;
        while (currentIndex < index) {
            y = y.next;
            currentIndex++;
        }
        //return old element and replace
        T currentNodeElement = y.nodeElement;
        y.nodeElement = x;
        return currentNodeElement;
    }
    
    /**
     * Removes the object at the specified position
     * @param index the position to remove
     * @return the object that was removed
     * @throws IllegalArugmentException if index is more than
     * the number of elements in the list
     */
    public T remove(int index) {
        illegalArgumentCheck(index);
        Node y = head;
        int currentIndex = 0;
        //remove head if index is 0
        if (index == 0) {
            T removedElement = head.nodeElement;
            head = new Node(y.next.next, y.next.nodeElement);
            //clear list if index 0 and head/lastNode only Nodes remaining
            if (head.next == null) {
                head = null;
            }
            return removedElement;
        }
        //iterate through list until reach right index to remove node
        else {
            while (currentIndex < index - 1) {
                y = y.next;
                currentIndex++;
            }
            //return removed object and remove
            T removedElement = y.next.nodeElement;
            y.next = y.next.next;
            return removedElement;
        }
    }
    
    /**
     * Tests if this list has no elements.
     * @return  <tt>true</tt> if this list has no elements;
     *          <tt>false</tt> otherwise.
     */
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     *
     * @param element element whose presence in this List is to be tested.
     * @return  <code>true</code> if the specified element is present;
     *  <code>false</code> otherwise.
     */
    public boolean contains(T element) {
        //if no items in list, can't contain element
        if (isEmpty()) {
            return false;
        }
        //iterate through list to see if element is there
        else {
            Node y = head;
            while (y.next != null) {
                if (y.nodeElement == element) {
                    return true;
                }
                 y = y.next;
            }
        }
            return false;
    }
    
    /** 
     * Returns the index of the specified element
     *
     * @param element the element we're looking for
     * @return the index of the element in the list, or -1 
     * if it is not contained within the list
     */
    public int indexOf(T element) {
        //only iterate through list if it is contained in list
        if (contains(element)) {
            Node y = head;
            int currentIndex = 0;
            //iterate through list and return the index location
            while (y.next != null) {
                if (y.nodeElement == element) {
                    return currentIndex;
                }
                y = y.next;
                currentIndex++;
            }
        }
        return -1;
    }
    
    //helper function
    public void illegalArgumentCheck(int index) {
        if (index > size() || index < 0) {
            throw new IllegalArgumentException("Enter appropriate index");
        }
    }
    
    //get and set helper function (this one can't reference an index = size)
    public void illegalArgumentCheckSize(int index) {
        if (index >= size() || index < 0) {
            throw new IllegalArgumentException("Enter appropriate index");
        }
    }
    
    //main function to test
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("a string");
        ll.add("two");
        ll.add("three");
        System.out.println(ll.size());
        System.out.println(ll.indexOf("one"));
    }
        
}