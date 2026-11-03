package Laba4_1;

public class MinStackImpl implements MinStack<Integer> {

    private Node head;
    private int size;

    public MinStackImpl() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void push(Integer value) {
        int newMin = (head == null) ? value : Math.min(value, head.currentMin);
        head = new Node(value, newMin, head);
        size++;
    }

    @Override
    public Integer pop() {
        if (head == null) {
            return null;
        }
        int value = head.value;
        head = head.next;
        size--;
        return value;
    }

    @Override
    public Integer top() {
        return (head == null) ? null : head.value;
    }

    @Override
    public Integer min() {
        return (head == null) ? null : head.currentMin;
    }
}