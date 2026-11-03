package Laba4_1;

public class Node {
    int value;
    int currentMin;
    Node next;

    public Node(int value, int currentMin, Node next) {
        this.value = value;
        this.currentMin = currentMin;
        this.next = next;
    }
}