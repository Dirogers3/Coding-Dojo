package SinglyLinkedList;

public class SinglyLinkedList {
    public Node head;

    public SinglyLinkedList() {
        // your code here
        this.head = null;
    }

    // SLL methods go here. As a starter, we will show you how to add a node to the
    // list.
    public void add(int value) {
        Node stickyNote= new Node(value);
        if (head == null) {
            head = stickyNote;
        } else {
            Node pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = stickyNote;
        }
    }

    public void remove(){
        if(head == null) {
            System.out.println("List already empty");
        } else {

            Node currentNode = head;
            
            while(currentNode.next.next != null){
                currentNode = currentNode.next;
            }
            
            currentNode.next = null;
        }
    }

    public void printValues(){
        Node currentNode = head;
        String list = "";
        while (currentNode != null) {
            list = list + "->" + currentNode.value;

            currentNode = currentNode.next;
        }
        System.out.println(list);
    }

    public Node find(int x){
        Node currentNode = head;
        try {
            while (currentNode.value != x) {
                currentNode = currentNode.next;
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("There is no such node");
        }
        while(currentNode.value != x){
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public void removeAt(int x) {
        if (head == null) {
            System.out.println("List already empty");
        } else {

            Node currentNode = head;

            while (currentNode.next.next != null | currentNode.next.next.value == x) {
                currentNode = currentNode.next;
            }

            currentNode.next = null;

        }
    }
}
