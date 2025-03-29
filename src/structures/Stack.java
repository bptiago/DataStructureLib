package structures;

public class Stack<E> {
    private Node<E> top;
    private int length;

    public Stack() {
        top = null;
        length = 0;
    }

    public Stack(E element) {
        top = new Node<>(element);
        length = 1;
    }

    public void push(E element) {
        Node<E> node = new Node<>(element);
        node.setNext(this.top);
        top = node;
        length++;
    }

    public E pop() {
        if (top == null) {
            return null;
        }
        E element = top.getElement();
        top = top.getNext();
        return element;
    }

    public Node<E> getTop() {
        return top;
    }

    public void setTop(Node<E> top) {
        this.top = top;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
